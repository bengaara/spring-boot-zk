package com.simon.boot;

import java.util.HashMap;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.DHtmlLayoutServlet;

@Configuration
public class ZKConfiguration {
    @Bean
    public ServletRegistrationBean dHtmlLayoutServlet() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("update-uri", "/zkau");
        DHtmlLayoutServlet dHtmlLayoutServlet = new DHtmlLayoutServlet();
        ServletRegistrationBean reg = new ServletRegistrationBean(dHtmlLayoutServlet, "*.zul");
        reg.setLoadOnStartup(1);
        reg.setInitParameters(map);
        return reg;
    }

    @Bean
    public ServletRegistrationBean dHtmlUpdateServlet() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("update-uri", "/zkau/*");
        ServletRegistrationBean reg = new ServletRegistrationBean(new DHtmlUpdateServlet(), "/zkau/*");
        reg.setLoadOnStartup(2);
        reg.setInitParameters(map);
        return reg;
    }
}
