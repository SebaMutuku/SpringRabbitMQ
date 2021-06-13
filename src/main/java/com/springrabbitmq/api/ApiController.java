package com.springrabbitmq.api;


import com.springrabbitmq.rabbitconfig.MessageConfig;
import com.springrabbitmq.utils.QueueConfigs;
import com.springrabbitmq.utils.RequestObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/")
public class ApiController {
    @Autowired
    private RabbitTemplate template;


    @PostMapping("/users/login")
    public ResponseEntity getPasswordUsername(@RequestBody RequestObject request) {
        request.setPassword("Usepassword");
        request.setPassword("Userpassword");
        template.convertAndSend(MessageConfig.queueExchange1, MessageConfig.routingKey1, request);
        return new ResponseEntity(request, HttpStatus.OK);
    }
    @PostMapping("/users/getAll")
    public ResponseEntity readAllUsers(@RequestBody RequestObject request) {
        request.setPassword("Usepassword");
        request.setPassword("Userpassword");
        template.convertAndSend(MessageConfig.queueExchange2, MessageConfig.routingKey2, request);
        return new ResponseEntity(request, HttpStatus.OK);
    }
    @PostMapping("/users/listAll")
    public ResponseEntity listOnlyAdminUsers(@RequestBody RequestObject request) {
        request.setPassword("Usepassword");
        request.setPassword("Userpassword");
        template.convertAndSend(MessageConfig.queueExchange3, MessageConfig.routingKey3, request);
        return new ResponseEntity(request, HttpStatus.OK);
    }
}
