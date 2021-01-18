package top.parakspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parakspringcloud </p>
 * <p> FileName: PaymentHystrixMain8001Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/23
 */

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixMain8001Application {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001Application.class, args);
    }
}
