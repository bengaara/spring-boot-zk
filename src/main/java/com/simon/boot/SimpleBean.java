package com.simon.boot;

import org.springframework.stereotype.Component;

@Component
public class SimpleBean {

    public static String echo(String message) {
        return message;
    }
}
