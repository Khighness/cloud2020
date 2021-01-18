package top.parak.springcloud.service;

import top.parak.springcloud.entity.Payment;

import java.util.List;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service </p>
 * <p> FileName: PaymentService <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/26
 */

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

    public List<Payment> getAllPayment();

}
