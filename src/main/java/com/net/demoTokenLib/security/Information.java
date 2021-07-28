package com.net.demoTokenLib.security;

import com.net.demoTokenLib.beans.ClientType;
import com.net.demoTokenLib.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Information {

    private ClientType clientType;
    private LocalDateTime time;
    private int userID;


}
