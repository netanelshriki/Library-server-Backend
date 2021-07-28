package com.net.demoTokenLib.security;

import com.net.demoTokenLib.beans.ClientType;
import com.net.demoTokenLib.services.BorrowerService;
import com.net.demoTokenLib.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginManager {

    private final ApplicationContext ctx;

    public UserService login(String email, String password, ClientType clientType) throws Exception {


        UserService userService = null;

        switch (clientType) {
            case BORROWER:
                userService = (UserService) ctx.getBean(BorrowerService.class);
                if (userService.login(email, password)) {
                    return userService;
                }
            case EMPLOYEE:
        }
        throw new Exception("......");
    }

}
