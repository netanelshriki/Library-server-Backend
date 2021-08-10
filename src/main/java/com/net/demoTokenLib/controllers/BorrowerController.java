package com.net.demoTokenLib.controllers;

import com.net.demoTokenLib.beans.Book;
import com.net.demoTokenLib.beans.User;
import com.net.demoTokenLib.exceptions.LibraryLoginException;
import com.net.demoTokenLib.security.LoginManager;
import com.net.demoTokenLib.security.TokenManager;
import com.net.demoTokenLib.services.BorrowerService;
import com.net.demoTokenLib.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("borrow/")

public class BorrowerController extends LibraryController {

    @Autowired
    public BorrowerController(EmployeeService employeeService, BorrowerService borrowerService, TokenManager tokenManager, LoginManager loginManager) {
        super(employeeService, borrowerService, tokenManager, loginManager);
    }


    @PostMapping("register")
    @Override
    public ResponseEntity<?> register(@RequestBody User user) {
        return new ResponseEntity<>(tokenManager.addToken(user), HttpStatus.CREATED);
    }

    @DeleteMapping("logout")
    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(@RequestBody LogoutDetails logoutDetails) {
        tokenManager.removeToken(logoutDetails.getToken());
    }

    @GetMapping("books/{id}")
    public Book getBook(@PathVariable int id) {
        return borrowerService.getOneBook(id);
    }

    @GetMapping("books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks(@RequestHeader(value = "Authorization") String token) throws LibraryLoginException {
        tokenManager.isTokenExist(token);
        return borrowerService.getAllBooks();
    }

}
