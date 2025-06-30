// src/main/java/com/highscope/curriculum/dto/UserCreateRequest.java
package com.highscope.curriculum.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer hsId;
    private Integer roleId;
}