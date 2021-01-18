package top.parak.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.lb </p>
 * <p> FileName: LoadBalancerImpl <p>
 * <p> Description: 实现轮询 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/18
 */

@Slf4j
@Component
public class LoadBalancerImpl implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        log.info("访问次数=> [{}]", next);
        return next;
    }

    /**
     * <p>负载均衡算法</p>
     * 实际服务器调用下标 = Rest接口请求次数 % 服务器集群数量
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
