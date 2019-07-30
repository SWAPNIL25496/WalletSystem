package com.system.user.util;

import com.system.user.dto.UserDto;
import com.system.user.model.UserData;

import javax.validation.Valid;

public class UserMapper {

    public static UserData toEntity(@Valid UserDto userDto) {
        UserData entity = new UserData();
        if (userDto.getId() != null) {
            entity.setId(userDto.getId());
        }
        entity.setName(userDto.getName());
        entity.setEmail(userDto.getEmail());
        entity.setPhoneNumber(userDto.getPhoneNumber());

        return entity;
    }

    public static UserDto toDto(@Valid UserData userData) {
        UserDto entity = new UserDto();
        entity.setId(userData.getId());
        entity.setName(userData.getName());
        entity.setEmail(userData.getEmail());
        entity.setPhoneNumber(userData.getPhoneNumber());

        return entity;
    }
}
