package com.springrabbitmq.utils;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class RequestObject {
   private String username;
   private String password;
}
