package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {
    List<User> userList;

    public UserService(){
        userList = new ArrayList<>();
    }

    public UserDO addUser(UserDO userDO){
        User userObj = new User();
        userObj.setUserName(userDO.getName());
        userObj.setEmail(userDO.getMail());
        userObj.setUserId(new Random().nextInt(100-10) +10);
        userList.add(userObj);
        return convertUserDOToUser(userObj);
    }

    public UserDO getUser(int userId){
        for(User user: userList){
            if(user.getUserId() == userId){
                return convertUserDOToUser(user);
            }
        }
        return null;
    }

    private UserDO convertUserDOToUser(User user){
        UserDO userDO = new UserDO();
        userDO.setMail(user.getEmail());
        userDO.setName(user.getUserName());
        userDO.setId(user.getUserId());
        return userDO;
    }
}
