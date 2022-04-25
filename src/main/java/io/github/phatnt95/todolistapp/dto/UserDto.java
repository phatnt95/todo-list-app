package io.github.phatnt95.todolistapp.dto;

import io.github.phatnt95.todolistapp.entity.Role;
import io.github.phatnt95.todolistapp.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author phatnt
 * @discription
 */


@Builder
@Getter
@Setter
public class UserDto implements GeneralDto<UserDto, User>{
    private String username;
    private String email;
    private String fullName;
    private Collection<Role> roles = new ArrayList<>();


    @Override
    public UserDto entity2model(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .roles(user.getRoles())
                .build();
    }

    @Override
    public User model2entity(UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .fullName(userDto.getFullName())
                .roles(userDto.getRoles())
                .build();
    }
}
