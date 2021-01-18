package top.parak.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p> Project: cloud2020 </P>
 * <p> Package: top.parak.springcloud.lb </p>
 * <p> FileName: LoadBalancer <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/18
 */

public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
