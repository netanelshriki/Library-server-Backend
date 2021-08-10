package com.net.demoTokenLib.security;

import com.net.demoTokenLib.beans.User;
import com.net.demoTokenLib.exceptions.ErrorMsg;
import com.net.demoTokenLib.exceptions.LibraryLoginException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TokenManager {

    private final Map<String, Information> map;

    public String addToken(User user) {
        String token = UUID.randomUUID().toString();
        Information info = Information.builder()
                .time(LocalDateTime.now())
                .userID(user.getId())
                .clientType(user.getClientType())
                .build();
        map.put(token, info);

        return token;
    }

    public boolean isTokenExist(String token) throws LibraryLoginException {
        if (!map.containsKey(token)) {
            throw new LibraryLoginException(ErrorMsg.UNAUTHORIZED.getDescription());
        }
        return true;
    }

    public void removeToken(String token){
        map.remove(token);
    }

    public void removeExpiredToken(String token){

    }

}
