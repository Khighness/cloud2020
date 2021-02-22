package top.parak.springcloud.service;

import org.springframework.stereotype.Component;
import top.parak.springcloud.entity.CommonResult;
import top.parak.springcloud.entity.Payment;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service </p>
 * <p> FileName: PaymentFallbackService <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/20
 */

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回，---PaymentFallbackService", new Payment(id, "ErrorSerial"));
    }
}
