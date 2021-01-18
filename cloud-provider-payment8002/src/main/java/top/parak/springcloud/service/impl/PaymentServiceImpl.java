package top.parak.springcloud.service.impl;

import org.springframework.stereotype.Service;
import top.parak.springcloud.entity.Payment;
import top.parak.springcloud.mapper.PaymentMapper;
import top.parak.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service.impl </p>
 * <p> FileName: PaymentServiceImpl <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/26
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentMapper.getAllPayment();
    }
}
