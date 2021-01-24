package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>
 * <p> FileName: ConfigClientMain3366Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/1/24
 */

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366Application.class, args);
    }
}
