package com.net.demoTokenLib.services;

import com.net.demoTokenLib.beans.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
    Book getOneBook(int id);
    List<Book> getAllBooks();
}
