package top.parak.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.parak.springcloud.entity.CommonResult;
import top.parak.springcloud.service.PaymentHystrixService;

import javax.annotation.Resource;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.controller </p>
 * <p> FileName: PaymentHystrixController <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/25
 */

@Slf4j
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/success/{id}")
    public CommonResult paymentInfoSuccess(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoSuccess(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand
//            (
//            fallbackMethod = "paymentInfoTimeoutHandler"
//            , commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//        }
//    )
    public CommonResult paymentInfoTimeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    public CommonResult paymentInfoTimeoutHandler(Integer id) {
        return new CommonResult(200, "服务繁忙", "线程池：" + Thread.currentThread().getName() + ", id: " + id + ", 服务消费者信息：服务繁忙");
    }

    /**
     * <p>全局服务降级处理</p>
     * @return
     */
    public CommonResult paymentGlobalFallback() {
        return new CommonResult(200, "处理异常", "Global异常信息处理异常。请稍后再试。");
    }


}
