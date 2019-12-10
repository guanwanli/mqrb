package com.guanwanli.rbcosumera.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:wanliguan
 * @date:2019/12/10
 * @description:
 */
@Configuration
public class DirectRabbitConfig {
    //队列
    @Bean
    public Queue CalonDirectQueue() {
        return new Queue("guanwanliDirectQueue",true);
    }

    //Direct交换机
    @Bean
    DirectExchange CalonDirectExchange() {
        return new DirectExchange("guanwanliDirectExchange");
    }

    //绑定
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(CalonDirectQueue()).to(CalonDirectExchange()).with("guanwanliDirectRouting");
    }

}
