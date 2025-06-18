package com.example.login.dao;

import com.example.login.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {
    
    private UserDAO userDAO = new UserDAO();
    
    @Test
    public void testValidateWithValidCredentials() {
        assertTrue(userDAO.validate("admin", "admin123"));
        assertTrue(userDAO.validate("user", "user123"));
    }
    
    @Test
    public void testValidateWithInvalidCredentials() {
        assertFalse(userDAO.validate("admin", "wrongpassword"));
        assertFalse(userDAO.validate("wronguser", "admin123"));
        assertFalse(userDAO.validate("", ""));
        assertFalse(userDAO.validate(null, null));
    }
    
    @Test
    public void testGetUser() {
        User adminUser = userDAO.getUser("admin");
        assertNotNull(adminUser);
        assertEquals("admin", adminUser.getUsername());
        assertEquals("admin123", adminUser.getPassword());
        
        User nonExistentUser = userDAO.getUser("nonexistent");
        assertNull(nonExistentUser);
    }
}
