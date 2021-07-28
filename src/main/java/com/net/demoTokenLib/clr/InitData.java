package com.net.demoTokenLib.clr;

import com.net.demoTokenLib.beans.Book;
import com.net.demoTokenLib.beans.ClientType;
import com.net.demoTokenLib.beans.User;
import com.net.demoTokenLib.repos.BookRepository;
import com.net.demoTokenLib.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Order(1)
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Book b1 = Book.builder()
                .bookName("lord of rings 1")
                .build();

        Book b2 = Book.builder()
                .bookName("lord of rings 2")
                .build();
        Book b3 = Book.builder()
                .bookName("lord of rings 3")
                .build();
        Book b4 = Book.builder()
                .bookName("harry potter")
                .build();
        Book b5 = Book.builder()
                .bookName("the french revolution")
                .build();

        User u1 = User.builder()
                .name("john")
                .email("john@gmail.com")
                .password("11241")
                .clientType(ClientType.EMPLOYEE)
                .build();

        userRepository.save(u1);



        bookRepository.saveAll(Arrays.asList(b1,b2,b3,b4,b5));


    }
}
