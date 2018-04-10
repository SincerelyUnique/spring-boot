package com.example.demo;

import com.example.demo.message.Receiver;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@Log4j
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		// 创建应用上下文
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		// 创建上下文时会实例化消息监听容器这个bean，同时这个container会监听消息

		// 运行main方法时会从上下文检索StringRedisTemplate这个bean，获取该bean并使用其作为模板在topic为chat的频道上发送一条消息
		// 此时container容器会监听到这条消息，调用Receiver类中receiveMessage方法打印该消息
		// 注意channel和message必须都是字符串，否则报ClassCastException错
		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);

		// 该类位于java并发包下，类似计数器功能，用于等待其他任务执行完毕后做相关操作，
		// 这里等待消息发送和消息接收两个任务完毕后，关闭Spring应用上下文，即关闭应用
		CountDownLatch latch = ctx.getBean(CountDownLatch.class);

		log.info("Sending message...");
		template.convertAndSend("chat", "Hello from Redis!");
		template.convertAndSend("chat", "Hello from Redis twice!");
		template.convertAndSend("chat", "Hello from Redis third!");

		latch.await();

		System.exit(0);
	}

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
											MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		// 监听topic为chat的消息
		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		// MessageListenerAdapter实现MessageListener接口，当消息到达时，调用Receiver类中receiveMessage方法
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	Receiver receiver(CountDownLatch latch) {
		return new Receiver(latch);
	}

	@Bean
	CountDownLatch latch() {
		return new CountDownLatch(1);
	}

	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}
}
