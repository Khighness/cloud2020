package top.parak.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.parak.springcloud.domain.Order;
import top.parak.springcloud.mapper.OrderMapper;
import top.parak.springcloud.service.AccountService;
import top.parak.springcloud.service.OrderService;
import top.parak.springcloud.service.StorageService;

import javax.annotation.Resource;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service.impl </p>
 * <p> FileName: OrderServiceImpl <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/21
 */

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 业务流程：下订单 -> 减库存 -> 减余额 -> 改状态
     * @param order
     */
    @Override
    public void createOrder(Order order) {
        // (1)
        log.info(">>> 新建订单 <<<");
        orderMapper.createOrder(order);
        // (2)
        log.info("[订单微服务调用库存，进行数量扣减] => start");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("[订单微服务调用库存，进行数量扣减] => end");
        // (3)
        log.info("[订单微服务调用账户，进行余额扣减] => start");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("[订单微服务调用账户，进行余额扣减] => end");
        // (4)
        log.info("[修改订单状态] => start");
        orderMapper.updateStatus(order.getUserId(), 0);
        log.info("[修改订单状态] => end");

        log.info(">>> 下单成功 <<<");
    }

}
