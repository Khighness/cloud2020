package top.parak.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.parak.springcloud.mapper.AccountMapper;
import top.parak.springcloud.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service.impl </p>
 * <p> FileName: AccountServiceImpl <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/22
 */

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("用户id => [{}], 扣减金额 => [{}]", userId, money);
        log.info("[扣减余额] => start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountMapper.decrease(userId, money);
        log.info("[扣减余额] => end");
    }

}
