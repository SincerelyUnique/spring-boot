/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * <code>Runner</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/2/24 14:51
 */
@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");

        // 通过RabbitTemplate模板给队列spring-boot发送一条消息
        rabbitTemplate.convertAndSend(DemoApplication.queueName, "Hello from RabbitMQ!");
        rabbitTemplate.convertAndSend(DemoApplication.queueName, "Hello from RabbitMQ twice!");
        rabbitTemplate.convertAndSend(DemoApplication.queueName, "Hello from RabbitMQ third!");

        // 让当前线程等待10000毫秒，直到计数器数字为0，除非线程被打断
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);

        // 关闭context上下文
        context.close();
    }

}
