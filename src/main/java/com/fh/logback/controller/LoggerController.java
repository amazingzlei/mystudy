package com.fh.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoggerController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("logger")
    @ResponseBody
    public String logger(){
        /* 下面几个级别是由低到高 */
        logger.trace("这是trace级别的日志");
        logger.debug("这是debug级别的日志");
        logger.info("这是info级别的日志");
        logger.warn("这是warn级别的日志");
        logger.error("这是error级别的日志");
        return "logger";
    }

}
