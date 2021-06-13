package com.springrabbitmq.rabbitconfig;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessageConfig {

    public static final String queueName1="message-queue1";
    public static final String queueName2="message-queue2";
    public static final String queueName3="message-queue3";

    public static  final String queueExchange1="message-exchange1";
    public static  final String queueExchange2="message-exchange2";
    public static  final String queueExchange3="message-exchange3";

    public static final String routingKey1="rabbit-key-1929-1";
    public static final String routingKey2="rabbit-key-1929-2";
    public static final String routingKey3="rabbit-key-1929-3";


    @Bean
    public Queue queue1() {
        return new Queue(queueName1);
    }
    @Bean
    public Queue queue2() {
        return new Queue(queueName2);
    }
    @Bean
    public Queue queue3() {
        return new Queue(queueName3);
    }

    @Bean
    public TopicExchange exchange1() {
        return new TopicExchange(queueExchange1);
    }
    @Bean
    public TopicExchange exchange2() {
        return new TopicExchange(queueExchange2);
    }
    @Bean
    public TopicExchange exchange3() {
        return new TopicExchange(queueExchange3);
    }

    @Bean
    public Binding binding1(Queue queue1, TopicExchange exchange1) {
        return BindingBuilder.bind(queue1).to(exchange1).with(routingKey1);
    }
    @Bean
    public Binding binding2(Queue queue2, TopicExchange exchange2) {
        return BindingBuilder.bind(queue2).to(exchange2).with(routingKey2);
    }
    @Bean
    public Binding binding3(Queue queue3, TopicExchange exchange3) {
        return BindingBuilder.bind(queue3).to(exchange3).with(routingKey3);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory factory) {
        ConnectionFactory connectionFactory;
        RabbitTemplate template = new RabbitTemplate(factory);
        template.setMessageConverter(messageConverter());
        return template;
    }

}
