package top.parak.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.parak.springcloud.domain.Order;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.mapper </p>
 * <p> FileName: OrderMapper <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/21
 */

@Mapper
@Repository
public interface OrderMapper {

    int createOrder(Order order);

    int updateStatus(@Param("userId") Long userId, @Param("status") Integer status);
}
