package com.guanwanli.rbcosumera.receiver;

import com.guanwanli.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author:wanliguan
 * @date:2019/12/10
 * @description:
 */
@Component
@RabbitListener(queues = "guanwanliDirectQueue")//CalonDirectQueue为队列名称
public class DirectReceiver {
    @RabbitHandler
    public void process(User user) {
        System.out.println("DirectReceiver消费者收到消息  : " + user.getId()+","+user.getUsername()+","+user.getPassword()+","+user.getType());
    }
}
