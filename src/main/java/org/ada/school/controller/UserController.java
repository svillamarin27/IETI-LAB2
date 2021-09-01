package org.ada.school.controller;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController
{

    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> all()
    {
        return new ResponseEntity<>(this.userService.all(), HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id )
    {
        return new ResponseEntity<> (this.userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto )
    {
        return new ResponseEntity<> (this.userService.create(new User(userDto)), HttpStatus.OK);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id )
    {
        return new ResponseEntity<>(this.userService.update(new UserDto(userDto),id), HttpStatus.OK);
    }
    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        return new ResponseEntity(this.userService.deleteById(id), HttpStatus.OK);
    }
}
