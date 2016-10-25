package com.simon.vms;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import com.simon.boot.SimpleBean;

@VariableResolver(DelegatingVariableResolver.class)
public class IndexVM {

    @WireVariable // ("simpleBean")
    SimpleBean simpleBean;

    String message;

    @Init
    public void init() {
        message = simpleBean.echo("Hello zk  World!");

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
