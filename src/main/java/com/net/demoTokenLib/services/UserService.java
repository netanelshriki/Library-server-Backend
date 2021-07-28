package com.net.demoTokenLib.services;

import com.net.demoTokenLib.repos.BookRepository;
import com.net.demoTokenLib.repos.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public abstract class UserService {
    @Autowired
    protected BookRepository bookRepository;
    @Autowired
    protected UserRepository userRepository;

    public abstract boolean login(String email,String password);
}
