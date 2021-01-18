package top.parak.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.parak.springcloud.entity.Payment;

import java.util.List;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.mapper </p>
 * <p> FileName: PaymentMapper <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/26
 */

@Mapper
public interface PaymentMapper {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public List<Payment> getAllPayment();

}
