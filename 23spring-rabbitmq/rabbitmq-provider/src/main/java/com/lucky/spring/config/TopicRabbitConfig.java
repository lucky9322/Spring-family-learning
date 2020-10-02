package com.lucky.spring.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangdd on 2020/9/19
 */
@Configuration
public class TopicRabbitConfig {
    //绑定键
    public final static String MAN = "topic.man";
    public final static String WOMAN = "topic.woman";

    @Bean
    public Queue firstQueue() {
        return new Queue(MAN);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(WOMAN);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 将 firstQueue与topicExchange绑定，而且绑定的键值为topic.man
     * 这样只要是消息 携带的路由键是 topic.man 才会分发到该队列
     * @return
     */
    @Bean
    public Binding bindingExchange1() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(MAN);
    }

    /**
     * 将 secondQueue与topicExchange绑定，而且绑定的键值为用上通配路由键规则topic.#
     * 这样只要是消息 携带的路由键是 topic. 开头都会分发到该队列
     * @return
     */
    @Bean
    public Binding bindingExchange2() {
        return BindingBuilder.bind(secondQueue()).
                to(exchange())
                .with("topic.#");
    }
}
