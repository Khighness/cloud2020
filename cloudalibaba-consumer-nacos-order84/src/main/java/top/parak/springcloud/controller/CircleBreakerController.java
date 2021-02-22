package top.parak.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.IncompleteArgumentException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.parak.springcloud.entity.CommonResult;
import top.parak.springcloud.entity.Payment;
import top.parak.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.controller </p>
 * <p> FileName: CircleBreakerController <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/20
 */

@Slf4j
@RestController
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") // 无配置
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler") // blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback", fallback = "handleFallback") // fallback只负责业务异常
    @SentinelResource(value = "fallback", fallback = "handleFallback", blockHandler = "blockHandler", exceptionsToIgnore = {IncompleteArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("参数非法");
        } else if (result.getData() == null) {
            throw new NullPointerException("未查询到相关内容");
        }
        return result;
    }

    /**
     * fallback
     * @param id
     * @param e
     * @return
     */
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常 => [" + e.getMessage() + "]", payment);
    }

    /**
     * blockHandler
     * @param id
     * @param exception
     * @return
     */
    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException exception) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(445, "blockHandler-sentinel限流 => [" + exception.getMessage() + "]", payment);
    }

    // ===== OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }

}
