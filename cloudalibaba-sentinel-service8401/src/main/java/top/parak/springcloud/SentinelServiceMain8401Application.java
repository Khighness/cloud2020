package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>
 * <p> FileName: SentinelServiceMain8401Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/19
 */

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelServiceMain8401Application {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain8401Application.class, args);
    }
}
