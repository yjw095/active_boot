package com.fdc.active.controller;

import org.slf4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/8/5.
 */
@Component
@RabbitListener(queues = "demoMq")
public class MqClientController {

    @Autowired
    AmqpTemplate rabbitmqTemplate;
    final Logger log = org.slf4j.LoggerFactory.getLogger(MqClientController.class);

    @RabbitHandler
    public void recieved(String msg) {
        log.info("msg:{}" ,msg);
    }


}
