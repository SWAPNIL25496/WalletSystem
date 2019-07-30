package com.system.user.service;

import com.system.user.dto.UserDto;
import com.system.user.model.UserData;
import com.system.user.repository.UserRepository;
import com.system.user.util.UserException;

import com.system.user.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserData add(UserDto userDto){
        UserData userData = UserMapper.toEntity(userDto);
        userRepository.save(userData);
        return userData;
    }

    public List<UserData> getAllUsers(){
        return (List<UserData>) userRepository.findAll();
    }

    public UserDto getUserById(Integer id){
        Optional<UserDto> optionalUserData = Optional.ofNullable(UserMapper.toDto(userRepository.findOne(id)));
        return optionalUserData.orElseThrow(() -> new UserException("User not find with id " + id));
    }

    public UserDto getUserByPhoneNumber(String  phoneNumber){
        Optional<UserDto> optionalUserDto = Optional.ofNullable( UserMapper.toDto(userRepository.findByPhoneNumber(phoneNumber)));
        return optionalUserDto.orElseThrow(() -> new UserException("User not find with phone number " + phoneNumber));
    }

    public Boolean userExitsById(Integer id){
        return userRepository.exists(id);
    }
    public Boolean userExitsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
    public Boolean userExitsByPhoneNumber(String phoneNumber){
        return userRepository.existsByPhoneNumber(phoneNumber);
    }




}
