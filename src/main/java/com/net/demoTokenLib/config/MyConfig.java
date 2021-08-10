package com.net.demoTokenLib.config;

import com.net.demoTokenLib.security.Information;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyConfig {

    @Bean
    public Map<String, Information> map() {
        return new HashMap<>();
    }

}
