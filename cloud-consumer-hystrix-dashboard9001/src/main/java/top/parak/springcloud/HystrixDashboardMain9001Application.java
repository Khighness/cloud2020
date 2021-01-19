package top.parak.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud </p>
 * <p> FileName: HystrixDashboardMain9001Application <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/1/19
 */

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001Application {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001Application.class, args);
    }
}
