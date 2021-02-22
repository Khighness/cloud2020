package top.parak.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.parak.springcloud.entity.CommonResult;
import top.parak.springcloud.entity.Payment;

import java.util.HashMap;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.controller </p>
 * <p> FileName: PaymentController <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/20
 */

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "593f6ea5-616e-4c92-96d7-b14daf2f9390"));
        hashMap.put(2L, new Payment(2L, "510dbc6c-41c5-4332-ba4a-2aa795e29100"));
        hashMap.put(3L, new Payment(3L, "f8791ed0-459e-4837-941f-797c2ac23dca"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "serverPort: " + serverPort, payment);
        return result;
    }

}
