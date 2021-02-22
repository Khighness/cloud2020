package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>
 * <p> FileName: SeataOrderMain2001Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/21
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 使用seata数据源
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrderMain2001Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain2001Application.class, args);
    }
}
