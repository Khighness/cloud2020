package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>
 * <p> FileName: ConfigCenterMain3344Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/1/23
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344Application.class, args);
    }
}
