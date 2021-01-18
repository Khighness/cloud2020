package top.parak.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.config </p>
 * <p> FileName: ApplicationContextConfig <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/26
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    // 赋予RestTemplate负载均衡的能力，轮询
    // @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
