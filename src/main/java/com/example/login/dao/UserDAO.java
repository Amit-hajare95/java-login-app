package com.example.login.dao;

import com.example.login.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private static final Map<String, User> userDatabase = new HashMap<>();
    
    static {
        // Pre-populate with some test users
        userDatabase.put("admin", new User("admin", "admin123"));
        userDatabase.put("user", new User("user", "user123"));
    }
    
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        
        User user = userDatabase.get(username);
        return user != null && password.equals(user.getPassword());
    }
    
    public User getUser(String username) {
        return userDatabase.get(username);
    }
}
