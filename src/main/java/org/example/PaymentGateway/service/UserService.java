package org.example.PaymentGateway.service;

import org.example.PaymentGateway.dto.UserDTO;
import org.example.PaymentGateway.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {
    static List<User> usersList = new ArrayList<>();

    public UserDTO addUser(UserDTO userDto){
        // some validations and create User Obj
        User userObj = new User();
        userObj.setUserName(userDto.getName());
        userObj.setEmail(userDto.getMail());
        userObj.setUserID((int) new Random().nextInt(100-10) + 10);
        usersList.add(userObj);
        return convertUsertoUserDTO(userObj);
    }

    public UserDTO getUser(int userID){
        for(User user: usersList){
            if(user.getUserID() == userID){
                return convertUsertoUserDTO(user);
            }
        }
        return null;
    }

    private UserDTO convertUsertoUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(user.getUserID());
        userDTO.setName(user.getUserName());
        userDTO.setMail(user.getEmail());
        return userDTO;
    }
}
