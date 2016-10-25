package com.simon.controllers;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

//@Controller
@RestController
@VariableResolver(DelegatingVariableResolver.class)
public class IndexController {

    final static Log logger = LogFactory.getLog(IndexController.class);

    @RequestMapping("/")
    public ModelAndView index() {

        return new ModelAndView("indexVM.zul");
        // return "redirect:index";
    }

    @RequestMapping("/a")
    public @ResponseBody HashMap<String, Object> endRide() {

        HashMap<String, Object> map = new HashMap<String, Object>();
        try {

            map.put("success", "true");
            return map;
        } catch (Exception e) {
            // logger.error(e);
            logger.error("Unexpected Exception occurred", e);
            map.put("success", "false");
            return map;
        }
    }

}
