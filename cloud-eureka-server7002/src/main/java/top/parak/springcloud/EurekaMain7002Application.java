package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>
 * <p> FileName: EurekaMain7002Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/29
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002Application.class, args);
    }
}
