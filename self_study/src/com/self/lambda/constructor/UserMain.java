package com.self.lambda.constructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMain {
    public static void main(String[] args) {

        UserDto userDto1 = new UserDto();
        userDto1.setName("김철수");
        userDto1.setAge(22);
        userDto1.setPhone("010-2344-1234");

        UserDto userDto2 = new UserDto();
        userDto2.setName("김철수");
        userDto2.setAge(22);
        userDto2.setPhone("010-2344-1234");

        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(userDto1);
        userDtos.add(userDto2);

        List<User> users = userDtos.stream().map(User::new).collect(Collectors.toList());
        System.out.println(users);
    }
}
