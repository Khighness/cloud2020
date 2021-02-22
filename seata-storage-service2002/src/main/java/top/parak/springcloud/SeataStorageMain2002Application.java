package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>
 * <p> FileName: SeataStorageMain2002Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/21
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
public class SeataStorageMain2002Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain2002Application.class, args);
    }
}
