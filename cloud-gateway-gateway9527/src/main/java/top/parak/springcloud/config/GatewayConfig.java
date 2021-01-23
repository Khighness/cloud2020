package top.parak.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.config </p>
 * <p> FileName: GatewayConfig <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/1/22
 */

@Configuration
public class GatewayConfig {

    /**
     * <p>配置路由规则</p>
     * <p>当访问地址为{http://localhost:9527/guonei}时会
     * 自动转发到地址：http://news.baidu.com/guonei</p>
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocatorOne(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path:route k1",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }

    /**
     * <p>配置路由规则</p>
     * <p>当访问地址为{http://localhost:9527/guoji}时会
     * 自动转发到地址：http://news.baidu.com/guoji</p>
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocatorTwo(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path:route k2",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }

}
