package com.net.demoTokenLib.controllers;

import com.net.demoTokenLib.beans.Book;
import com.net.demoTokenLib.beans.User;
import com.net.demoTokenLib.services.BorrowerService;
import com.net.demoTokenLib.services.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lib/")
public class EmployeeController extends LibraryController{

    public EmployeeController(EmployeeService employeeService, BorrowerService borrowerService) {
        super(employeeService, borrowerService);
    }

    @Override
    public boolean register(User user) {
        return false;
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

    @GetMapping("books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable int id) {
        return employeeService.getOneBook(id);
    }

    @GetMapping("books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks(){
       return employeeService.getAllBooks();
    }

}
