package com.net.demoTokenLib.services;

import com.net.demoTokenLib.beans.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl extends UserService implements BorrowerService {

    @Override
    public Book getOneBook(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean login(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }
}
