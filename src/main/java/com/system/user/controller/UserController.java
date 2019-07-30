package com.system.user.controller;

import com.system.user.dto.UserDto;
import com.system.user.model.UserData;
import com.system.user.service.UserService;
import com.system.user.util.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public UserData createNewUser(@Valid @RequestBody UserDto userDto){
        //setting automatic id
        // userDto.setId(nextId.incrementAndGet());

        if (userService.userExitsByEmail(userDto.getEmail()) || userService.userExitsByPhoneNumber(userDto.getPhoneNumber())){
            throw new UserException("user found with phone number or email address");
        }



        return  userService.add(userDto);
    }
    @GetMapping("/user")
    public @ResponseBody
    List<UserData> getUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable("id") Integer userId){
            return userService.getUserById(userId);




    }

    @PutMapping("/user")
    public UserDto editOneUser(
            @RequestBody UserDto newUser
    ) {
            UserDto userDto = userService.getUserById(newUser.getId());
            if (newUser.getEmail() != null){

                userDto.setEmail(newUser.getEmail() );
            }
            if (newUser.getName() != null){
                userDto.setName(newUser.getName() );
            }
            if (newUser.getPhoneNumber() != null){

                userDto.setPhoneNumber(newUser.getPhoneNumber() );
            }
            userService.add(userDto);

            return userDto;


    }
}
