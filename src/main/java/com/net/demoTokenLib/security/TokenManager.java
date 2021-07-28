package com.net.demoTokenLib.security;

import com.net.demoTokenLib.beans.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
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

    public boolean isTokenExist(String token) throws Exception {
        if (!map.containsKey(token)) {
            throw new Exception("......");
        }
        return true;
    }

}
