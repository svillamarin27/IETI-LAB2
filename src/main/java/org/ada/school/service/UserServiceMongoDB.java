package org.ada.school.service;
import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserServiceMongoDB
        implements UserService
{

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }


    @Override
    public User create(User user){
        UserDocument userDocument = null;
        return userRepository.save(userDocument);
    }

    @Override
    public User findById(String id )
    {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public ArrayList<User> all()
    {
        UserDocument userDocument = null;
        return userRepository.findAll(userDocument);
    }

    @Override
    public boolean deleteById(String id )
    {
        boolean flag = false;
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            flag=true;
        }
        return flag;
    }

    @Override
    public User update(UserDto userDto, String id )
    {
        User user = userRepository.findById(id).get();
        user.update(userDto);
        return user;
    }
}