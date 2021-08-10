package com.net.demoTokenLib.controllers;

import com.net.demoTokenLib.beans.Book;
import com.net.demoTokenLib.beans.User;
import com.net.demoTokenLib.exceptions.LibraryLoginException;
import com.net.demoTokenLib.repos.UserRepository;
import com.net.demoTokenLib.security.LoginManager;
import com.net.demoTokenLib.security.TokenManager;
import com.net.demoTokenLib.services.BorrowerService;
import com.net.demoTokenLib.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("lib/")
public class EmployeeController extends LibraryController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService, BorrowerService borrowerService, TokenManager tokenManager, LoginManager loginManager) {
        super(employeeService, borrowerService, tokenManager, loginManager);
    }

    @PostMapping("register")
    @Override
    public ResponseEntity<?> register(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(tokenManager.addToken(user), HttpStatus.CREATED);
    }

    @DeleteMapping("logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void logout(@RequestBody LogoutDetails logoutDetails) {
        tokenManager.removeToken(logoutDetails.getToken());
    }

    @PostMapping("books")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book) {
        employeeService.addBook(book);
    }

    @PutMapping("books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book) {
        employeeService.updateBook(book);
    }

    @DeleteMapping("books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        employeeService.deleteBook(id);
    }

    @DeleteMapping("employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }


    @GetMapping("books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable int id) {
        return employeeService.getOneBook(id);
    }

    @GetMapping("books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks(@RequestHeader(value = "Authorization") String token) throws LibraryLoginException {
        tokenManager.isTokenExist(token);
        return borrowerService.getAllBooks();
    }


    @GetMapping("employees")
    public ResponseEntity<?> getAllUsers() {

        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userRepository.getById(id), HttpStatus.OK);
    }

    @PutMapping("employees/update")
    public ResponseEntity<?> UpdatesEmployee(@RequestBody User user) {
        userRepository.saveAndFlush(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
