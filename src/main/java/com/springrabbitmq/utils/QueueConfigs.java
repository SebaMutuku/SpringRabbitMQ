package com.springrabbitmq.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;


@Getter
@Setter
public class QueueConfigs {
    @Value("${rabbit.queue}")
    public static String queueName;

    @Value("${rabbit.routing.key}")
    public static String routingKey;

    @Value("${rabbit.exhange}")
    public static String exchange;
}
