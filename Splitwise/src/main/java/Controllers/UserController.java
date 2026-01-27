package Controllers;

import Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserController {
    List<User> userList;

    public UserController(){
        userList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public User getUserById(String userId){
        for(User user: userList){
            if(Objects.equals(user.getUserId(), userId)) return user;
        }
        return null;
    }

    public List<User> getAllUsers(){
        return userList;
    }


}
