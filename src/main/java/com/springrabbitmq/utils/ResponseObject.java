package com.springrabbitmq.utils;


import lombok.*;
import org.springframework.http.HttpStatus;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ResponseObject {
    private HttpStatus status;
    private String message;
    private Object object;
}
