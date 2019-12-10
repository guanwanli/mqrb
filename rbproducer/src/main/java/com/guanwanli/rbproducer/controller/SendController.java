package com.guanwanli.rbproducer.controller;


import com.guanwanli.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @author:wanliguan
 * @date:2019/12/10
 * @description:
 */
@Controller
public class SendController {
    @Autowired
    private RabbitTemplate template;

    @GetMapping("/sendDirect")
    private @ResponseBody String sendDirect(String message) throws Exception {
        User user = new User(UUID.randomUUID().toString(), message, "123456", "sendDirect");
        template.convertAndSend("guanwanliDirectExchange", "guanwanliDirectRouting", user);
        return "OK,sendDirect:" + message;
    }

}
