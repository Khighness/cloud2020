package top.parak.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import top.parak.springcloud.entity.CommonResult;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service </p>
 * <p> FileName: PaymentFallbackService <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/27
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public CommonResult paymentInfoSuccess(Integer id) {
        return new CommonResult(200, "正常降级处理", this.getClass().getName() + " fall back "
                + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public CommonResult paymentInfoTimeout(Integer id) {
        return new CommonResult(200, "超时降级处理", this.getClass().getName() + " fall back "
                + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}
