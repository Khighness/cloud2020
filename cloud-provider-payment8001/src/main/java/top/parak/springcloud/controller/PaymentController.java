package top.parak.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import top.parak.springcloud.entity.CommonResult;
import top.parak.springcloud.entity.Payment;
import top.parak.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.controller </p>
 * <p> FileName: PaymentController <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/26
 */

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int res = paymentService.create(payment);
        if (res > 0) {
            log.info("Add payment => [{}]", true);
            return new CommonResult(200, "success, serverPort: " + serverPort, res);
        } else {
            log.error("Add payment => [{}]", false);
            return new CommonResult(600, "error", res);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("Query payment => [{}]", payment);
        if (!ObjectUtils.isEmpty(payment)) {
            return new CommonResult(200, "success, serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(600, "error", null);
        }
    }

    @GetMapping(value = "/all")
    public CommonResult getAllPayment() {
        List<Payment> paymentList = paymentService.getAllPayment();
        log.info("Query all payment => [{}]", paymentList);
        if (!ObjectUtils.isEmpty(paymentList)) {
            return new CommonResult(200, "success, serverPort: " + serverPort, paymentList);
        } else {
            return new CommonResult(600, "error", null);
        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("service => " + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "Hi, I'm paymentZipkin server fall back. q(≧▽≦q)";
    }

}
