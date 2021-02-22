package top.parak.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.parak.springcloud.domain.CommonResult;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service </p>
 * <p> FileName: StorageService <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/21
 */

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 库存扣减
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
