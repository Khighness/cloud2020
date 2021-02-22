package top.parak.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.controller </p>
 * <p> FileName: FlowLimitController <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/2/19
 */

@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName() + " => [testA]]");
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + " => [testB]");
        return "-----testB";
    }

    @GetMapping("/testC")
    public String testC() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testC => [测试RT]");
        return "-----testC";
    }

    @GetMapping("/testD")
    public String testD() {
        log.info("testD => [异常比例]");
        int age = 10 / 0;
        return "-----testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE => [测试异常数]");
        int age = 10 / 0;
        return "-----testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String var1, @RequestParam(value = "p1", required = false) String var2) {
        return "-----test Hot Key";
    }

    public String dealTestHotKey(String var1, String var2, BlockException e) {
        return "-----deal Hot Key";
    }
}
