package com.simon.zk.controllers;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class RideController {

    final static Log logger = LogFactory.getLog(RideController.class);

    @RequestMapping("/ride")
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
