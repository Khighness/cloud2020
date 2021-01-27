package top.parak.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import top.parak.springcloud.service.IMessageProvider;

import javax.annotation.Resource;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: top.parak.springcloud.service.impl </p>
 * <p> FileName: MessageProviderImpl <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/1/26
 */

@Slf4j
@EnableBinding(Source.class) // 定义消息的推送通道
public class MessageProviderImpl implements IMessageProvider {

    /* 消息发送管道 */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serialId = IdUtil.simpleUUID();
        log.info("serialId => [{}]", serialId);
        output.send(MessageBuilder.withPayload(serialId)
                .setHeader("partitionKey", "parak")
                .build());
        return serialId;
    }

}
