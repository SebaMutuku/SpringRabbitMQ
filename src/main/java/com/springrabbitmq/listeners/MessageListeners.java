package com.springrabbitmq.listeners;


import com.springrabbitmq.rabbitconfig.MessageConfig;
import com.springrabbitmq.utils.RequestObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MessageListeners {



    @RabbitListener(queues = MessageConfig.queueName1)
    public void listenToQueues1(RequestObject requestObject) {
        String username = requestObject.getPassword(), password = requestObject.getUsername();
        System.out.println("Processing Information for queue::"+MessageConfig.queueName1+" Username " + username + " Password " + password);

    }
    @RabbitListener(queues = MessageConfig.queueName2)
    public void listenToQueues2(RequestObject requestObject) {
        String username = requestObject.getPassword(), password = requestObject.getUsername();
        System.out.println("Processing Information for queue::"+MessageConfig.queueName2+" Username " + username + " Password " + password);

    }
    @RabbitListener(queues = MessageConfig.queueName3)
    public void listenToQueues3(RequestObject requestObject) {
        String username = requestObject.getPassword(), password = requestObject.getUsername();
        System.out.println("Processing Information for queue::"+MessageConfig.queueName3+" Username " + username + " Password " + password);

    }
}
