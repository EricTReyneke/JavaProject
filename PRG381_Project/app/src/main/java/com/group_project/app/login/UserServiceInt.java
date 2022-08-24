package com.group_project.app.login;



import com.group_project.app.login.UserDto;
import com.group_project.app.login.AppUser;

import java.util.List;

public interface UserServiceInt {
    void saveUser(UserDto userDto);

    AppUser findUserByEmail(String email);

    List<UserDto> findAllUsers();
}