package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>z
 * <p> FileName: PaymentMain8002Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/26
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002Application {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002Application.class, args);
    }
}
