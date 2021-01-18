package top.parak.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.parak.springcloud.entity.CommonResult;

/**
 * <p> Project: cloud2020 </P>
 * <p> Package: top.parak.springcloud.service </p>
 * <p> FileName: PaymentHystrixService <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/25
 */

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/consumer/payment/hystrix/success/{id}")
    public CommonResult paymentInfoSuccess(@PathVariable("id") Integer id);

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public CommonResult paymentInfoTimeout(@PathVariable("id") Integer id);

}
