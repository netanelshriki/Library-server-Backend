package com.net.demoTokenLib.services;

import com.net.demoTokenLib.beans.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowerService {

    Book getOneBook(int id);
    List<Book> getAllBooks();
}