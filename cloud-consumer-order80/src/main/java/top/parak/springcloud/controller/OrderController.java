package top.parak.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.parak.springcloud.entity.CommonResult;
import top.parak.springcloud.entity.Payment;
import top.parak.springcloud.lb.LoadBalancer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;


/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.controller </p>
 * <p> FileName: OrderController <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/26
 */

@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/all")
    public CommonResult getAllPayment() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/all", CommonResult.class);
    }

    @GetMapping("/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("Http Status Code => [{}]", entity.getStatusCodeValue());
            log.info("Handle message => [{}]", entity.getBody().getMessage());
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(HttpServletRequest request, HttpServletResponse response) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
        return result;
    }

}
