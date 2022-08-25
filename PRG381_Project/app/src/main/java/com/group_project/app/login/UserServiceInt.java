package com.group_project.app.login;

import java.util.List;

public interface UserServiceInt {
    void saveUser(UserDto userDto);

    AppUser findUserByEmail(String email);

    List<UserDto> findAllUsers();
}