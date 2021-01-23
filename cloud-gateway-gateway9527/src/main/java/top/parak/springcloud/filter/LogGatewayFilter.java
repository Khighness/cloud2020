package top.parak.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.filter </p>
 * <p> FileName: LogGatewayFilter <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/1/23
 */

@Slf4j
@Component
public class LogGatewayFilter implements GlobalFilter, Ordered {

    private static final String SUCCESS_LAUGH = "ヾ(≧ ▽ ≦)ゝ";
    private static final String ERROR_CRY = "┗( T﹏T )┛";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("RequestId => [{}]", exchange.getRequest().getId());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (ObjectUtils.isEmpty(username)) {
            log.info("用户名为空 => [{}]", ERROR_CRY);
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        log.info("访问用户名 => [{}]", username);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
