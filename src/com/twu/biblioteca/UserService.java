package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    static List<User> userList = new ArrayList<>();
    static List<Admin> adminList = new ArrayList<>();

    public UserService() {
        init();
    }

    public boolean userLogin(String userName, String password) {
        for (User user: userList) {
            if (user.getName().equals(userName) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void init() {
        userList.add(new User("ctc-1234", "15929551794", "1171332103@qq.com", "123"));
        adminList.add(new Admin("admin", "admin"));
    }
}
