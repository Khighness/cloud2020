package top.parak.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.parak.springcloud.mapper.StorageMapper;
import top.parak.springcloud.service.StorageService;

import javax.annotation.Resource;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service.impl </p>
 * <p> FileName: StorageServiceImpl <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/22
 */

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("商品id => [{}], 扣减数量 => [{}]", productId, count);
        log.info("[扣减库存] => start");
        storageMapper.decrease(productId, count);
        log.info("[扣减库存] => end");
    }

}
