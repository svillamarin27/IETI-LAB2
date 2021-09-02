package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;

import java.util.ArrayList;

public interface UserService
{
    User create( User user );

    User findById(String id );

    ArrayList<User> all();

    boolean deleteById(String id );

    User update( UserDto userDto, String id );
}
