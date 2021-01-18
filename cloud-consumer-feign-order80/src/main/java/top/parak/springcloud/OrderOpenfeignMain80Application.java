package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>
 * <p> FileName: OrderOpenfeignMain80Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/23
 */

@SpringBootApplication
@EnableFeignClients
public class OrderOpenfeignMain80Application {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenfeignMain80Application.class, args);
    }
}
