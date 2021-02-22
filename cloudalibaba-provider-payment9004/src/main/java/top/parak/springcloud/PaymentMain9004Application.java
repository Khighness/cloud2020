package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>
 * <p> FileName: PaymentMain9004Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/20
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9004Application {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9004Application.class, args);
    }
}
