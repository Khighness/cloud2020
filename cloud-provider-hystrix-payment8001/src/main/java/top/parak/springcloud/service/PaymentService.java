package top.parak.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import top.parak.springcloud.entity.CommonResult;

import java.util.concurrent.TimeUnit;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service </p>
 * <p> FileName: PaymentService <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/23
 */

@Slf4j
@Service
public class PaymentService {

    /**
     * <p>正常服务</p>
     * @param id
     * @return
     */
    public String paymentInfoSuccess(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + ", id: " + id + ", SUCCESS";
    }

    /*---------------- 服务降级 ----------------*/

    /**
     * <p>模拟超时</p>
     * 超时或者异常都会调用fallbackMethod
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id) {
        int timeout = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return "线程池：" + Thread.currentThread().getName() + ", id: " + id + ", Timout：耗时" + timeout / 1000 + "秒";
    }

    /**
     * <p>超时的兜底方法</p>
     * @param id
     * @return
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + ", id: " + id + ", 服务提供者信息：服务繁忙";
    }

    /*---------------- 服务熔断 ----------------*/

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                    // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),       // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期0
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")      // 失效率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("Excepion => [id不能为负数]");
        }
        String seriaNumber = IdUtil.simpleUUID();
        return "线程池: " + Thread.currentThread().getName() + ", id: " + id + ", 调用成功-流水号：" + seriaNumber;
    }

    public String paymentCircuitBreakerFallBack(@PathVariable("id") Integer id) {
        return  "id不能为负数，请重新输入";
    }

}
