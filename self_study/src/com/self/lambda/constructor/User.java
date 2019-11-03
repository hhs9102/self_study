package com.self.lambda.constructor;

import lombok.ToString;

@ToString
public class User {
    private String name;
    private int age;
    private String tel;

    public User(UserDto userDto){
        this.name = userDto.getName();
        this.age = userDto.getAge();
        this.tel = userDto.getPhone();
    }
}
