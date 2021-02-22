package top.parak.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.config </p>
 * <p> FileName: MybatisConfig <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/21
 */

@Configuration
@MapperScan({"top.parak.springcloud.mapper"})
public class MybatisConfig {

}
