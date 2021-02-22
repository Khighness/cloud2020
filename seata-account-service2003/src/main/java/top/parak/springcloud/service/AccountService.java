package top.parak.springcloud.service;

import java.math.BigDecimal;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service </p>
 * <p> FileName: AccountService <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/22
 */

public interface AccountService {

    void decrease(Long userId, BigDecimal money);

}
