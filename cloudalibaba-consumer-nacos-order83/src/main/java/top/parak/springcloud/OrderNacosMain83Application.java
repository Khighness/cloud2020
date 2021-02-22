package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>
 * <p> FileName: OrderNacosMain83Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/1/28
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain83Application {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain83Application.class, args);
    }
}
