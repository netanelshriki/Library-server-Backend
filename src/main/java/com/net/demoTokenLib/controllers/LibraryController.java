package com.net.demoTokenLib.controllers;

import com.net.demoTokenLib.beans.User;
import com.net.demoTokenLib.services.BorrowerService;
import com.net.demoTokenLib.services.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public abstract class LibraryController {

    protected EmployeeService employeeService;
    protected BorrowerService borrowerService;

    @Autowired
    public LibraryController(EmployeeService employeeService, BorrowerService borrowerService) {
        this.employeeService = employeeService;
        this.borrowerService = borrowerService;
    }

    public abstract boolean register(User user);
}
