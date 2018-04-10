package com.example.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	final static String queueName = "spring-boot";

	/**
	 * AMQP queue
	 * @return AMQP队列
	 */
	@Bean
	Queue queue() {
		// 如果是持久的队列，则为true
		return new Queue(queueName, false);
	}

	/**
	 * topic exchange
	 * @return exchange
	 */
	@Bean
	TopicExchange exchange() {
		// 通过提供的名字，构建一个持久的、不会自动被删除的exchange（应该可以称之为exchange容器）
		return new TopicExchange("spring-boot-exchange");
	}

	/**
	 * 绑定queue和exchange
	 * @param queue 队列
	 * @param exchange 交换
	 * @return 绑定
	 */
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		// 绑定队列，交换的主题
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
											 MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);	// rabbitmq工厂
		container.setQueueNames(queueName);	// 设置该容器监听的队列名字
		container.setMessageListener(listenerAdapter); // 设置该容器的消息适配器进行监听

		// set... ...

		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		// 当消息到达时，通过Receiver类中定义的监听方法打印该条消息
		return new MessageListenerAdapter(receiver, "receiveMessage111");
	}
}
