package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;


public class UserServiceHashMap
    implements UserService
{

    private final HashMap<String, User> usersHash = new HashMap<>();


    @Override
    public User create(User user) {
        return this.usersHash.put(user.getId(),user);
    }

    @Override
    public User findById(String id) {
        User user = usersHash.get(id);
        return user;
    }

    @Override
    public ArrayList<User> all() {
        return new ArrayList<User> (usersHash.values());
    }

    @Override
    public boolean deleteById(String id){
        boolean flag = false;
        if(usersHash.containsKey(id)){
            usersHash.remove(id);
            return true;
        }
        return flag;
    }

    @Override
    public User update(UserDto userDto, String id) {
        if ( usersHash.containsKey( id ) )
        {
            User user = usersHash.get( id );
            user.update( userDto );
            return user;
        }
        else
        {
            return null;
        }
    }



}
