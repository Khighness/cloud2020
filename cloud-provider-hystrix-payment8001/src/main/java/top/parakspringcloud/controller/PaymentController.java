package top.parakspringcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.parak.springcloud.entity.CommonResult;
import top.parakspringcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parakspringcloud.controller </p>
 * <p> FileName: PaymentController <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/24
 */

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/success/{id}")
    public CommonResult paymentInfoSuccess(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoSuccess(id);
        log.info("result => [{}]", result);
        return new CommonResult(200, "success", result);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public CommonResult paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("result => [{}]", result);
        return new CommonResult(2000, "timeout", result);
    }

    @GetMapping("/payment/hystrix/circuit/{id}")
    public CommonResult paymentCircuitBreker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("result => [{}]", result);
        return new CommonResult(200, "circuit", result);
    }

}
