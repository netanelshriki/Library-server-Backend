package com.net.demoTokenLib.controllers;

import com.net.demoTokenLib.beans.Book;
import com.net.demoTokenLib.beans.User;
import com.net.demoTokenLib.security.TokenManager;
import com.net.demoTokenLib.services.BorrowerService;
import com.net.demoTokenLib.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("borrow/")

public class BorrowerController extends LibraryController {

    @Autowired
    private TokenManager tokenManager;

    public BorrowerController(EmployeeService employeeService, BorrowerService borrowerService) {
        super(employeeService, borrowerService);
    }

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public boolean register(User user) {
        return false;
    }

    @GetMapping("books/{id}")
    public Book getBook(@PathVariable int id) {
        return borrowerService.getOneBook(id);
    }

    @GetMapping("books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks() {
        return borrowerService.getAllBooks();
    }

}
