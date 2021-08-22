package com.net.demoTokenLib.controllers;

import com.net.demoTokenLib.beans.User;
import com.net.demoTokenLib.exceptions.LibraryLoginException;
import com.net.demoTokenLib.security.LoginManager;
import com.net.demoTokenLib.security.TokenManager;
import com.net.demoTokenLib.services.BorrowerService;
import com.net.demoTokenLib.services.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public abstract class LibraryController {

    protected EmployeeService employeeService;
    protected BorrowerService borrowerService;
    protected TokenManager tokenManager;
    protected LoginManager loginManager;

    @Autowired
    public LibraryController(EmployeeService employeeService, BorrowerService borrowerService, TokenManager tokenManager, LoginManager loginManager) {
        this.employeeService = employeeService;
        this.borrowerService = borrowerService;
        this.tokenManager = tokenManager;
        this.loginManager = loginManager;
    }




    public abstract ResponseEntity<?> register(User user);
    public abstract ResponseEntity<?> login(LoginDetails loginDetails) throws LibraryLoginException;
    public abstract void logout(LogoutDetails logoutDetails);
}
