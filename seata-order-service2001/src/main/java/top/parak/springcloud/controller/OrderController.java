package top.parak.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.parak.springcloud.domain.CommonResult;
import top.parak.springcloud.domain.Order;
import top.parak.springcloud.service.OrderService;

import javax.annotation.Resource;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.controller </p>
 * <p> FileName: OrderController <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/21
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/create")
    public CommonResult createOrder(Order order) {
        orderService.createOrder(order);
        return new CommonResult(200, "订单创建成功");
    }

}
