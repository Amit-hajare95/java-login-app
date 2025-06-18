package com.example.login.servlet;

import com.example.login.dao.UserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class LoginServletTest {
    
    @Mock
    private HttpServletRequest request;
    
    @Mock
    private HttpServletResponse response;
    
    @Mock
    private HttpSession session;
    
    @Mock
    private RequestDispatcher dispatcher;
    
    @Mock
    private UserDAO userDAO;
    
    private LoginServlet servlet;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        servlet = new LoginServlet();
        servlet.setUserDAO(userDAO);
    }
    
    @Test
    public void testDoGetShouldForwardToLoginPage() throws ServletException, IOException {
        when(request.getRequestDispatcher("/login.jsp")).thenReturn(dispatcher);
        
        servlet.doGet(request, response);
        
        verify(request).getRequestDispatcher("/login.jsp");
        verify(dispatcher).forward(request, response);
    }
    
    @Test
    public void testDoPostWithValidCredentialsShouldRedirectToWelcome() throws ServletException, IOException {
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("admin123");
        when(userDAO.validate("admin", "admin123")).thenReturn(true);
        when(request.getSession()).thenReturn(session);
        
        servlet.doPost(request, response);
        
        verify(session).setAttribute("username", "admin");
        verify(response).sendRedirect("welcome.jsp");
    }
    
    @Test
    public void testDoPostWithInvalidCredentialsShouldForwardToLoginWithError() throws ServletException, IOException {
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("wrongpassword");
        when(userDAO.validate("admin", "wrongpassword")).thenReturn(false);
        when(request.getRequestDispatcher("/login.jsp")).thenReturn(dispatcher);
        
        servlet.doPost(request, response);
        
        verify(request).setAttribute("errorMessage", "Invalid username or password");
        verify(request).getRequestDispatcher("/login.jsp");
        verify(dispatcher).forward(request, response);
    }
}
