package org.ada.school.dto;

public class UserDto
{
    String name;

    String email;

    String lastName;

    public UserDto(UserDto userDto)
    {
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLastName()
    {
        return lastName;
    }
}
