package top.parak.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.controller </p>
 * <p> FileName: ConfigClientController <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/1/23
 */

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    /**
     * 定点刷新
     * <p>
     * 当github上的配置文件修改后，
     * 为了保证返回的是修改后的yml文件内容，
     * 需要运维工程师发送一次请求：
     * {curl -X POST "http://localhost:3344/actuator/bus-refresh/cloud-config-client:3366"}
     * </p>
     * @return
     */
    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "serverPort: " + serverPort + "\nconfigInfo: " + configInfo;
    }

}
