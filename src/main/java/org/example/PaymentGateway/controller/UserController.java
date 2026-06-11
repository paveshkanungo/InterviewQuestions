package org.example.PaymentGateway.controller;

import org.example.PaymentGateway.dto.UserDTO;
import org.example.PaymentGateway.service.UserService;

public class UserController {
    UserService userService;

    public UserController(){
        userService = new UserService();
    }

    public UserDTO addUser(UserDTO userDto){
        return userService.addUser(userDto);
    }

    public UserDTO getUser(int userID){
        return userService.getUser(userID);
    }
}
