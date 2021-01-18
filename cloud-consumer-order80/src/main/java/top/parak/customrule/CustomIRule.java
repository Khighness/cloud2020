package top.parak.customrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.customrule </p>
 * <p> FileName: CustomIRule <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/18
 */

@Configuration
public class CustomIRule {

    @Bean
    public IRule muRule() {
        // 随机规则
        return new RandomRule();
    }

}
