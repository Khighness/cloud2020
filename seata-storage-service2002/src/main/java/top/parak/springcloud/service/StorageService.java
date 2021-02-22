package top.parak.springcloud.service;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service </p>
 * <p> FileName: StorageService <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/22
 */

public interface StorageService {

    void decrease(Long productId, Integer count);

}
