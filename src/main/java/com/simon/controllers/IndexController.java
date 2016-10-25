package com.simon.controllers;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import com.simon.boot.SimpleBean;

@VariableResolver(DelegatingVariableResolver.class)
class IndexController {

    @WireVariable("simpleBean")
    SimpleBean simpleBean;

    String message;

    @Init
    void init() {
        message = simpleBean.echo("Hello World!");

    }
}
