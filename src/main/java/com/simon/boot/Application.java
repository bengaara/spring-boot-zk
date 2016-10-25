package com.simon.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.simon")
public class Application {
    public static void main(String args[]) {
        new SpringApplicationBuilder().sources(Application.class).bannerMode(Banner.Mode.OFF).run();
    }
}

// https://www.zkoss.org/wiki/Small_Talks/2012/November/Integrate_ZK_with_Spring_MVC_3