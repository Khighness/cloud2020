package top.parak.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.mapper </p>
 * <p> FileName: StorageMapper <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/21
 */

@Mapper
@Repository
public interface StorageMapper {

    /**
     * 扣减库存数量
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
