package com.simon.boot;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    RequestExecutionTimer requestExecutionTimer = new RequestExecutionTimer();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(requestExecutionTimer);

    }

    public class RequestExecutionTimer extends HandlerInterceptorAdapter {

        protected final Log logger = LogFactory.getLog(getClass());

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            request.setAttribute("requestReceivedAt", new Date());
            // logger.info("RequestExecutionTimer::preHandle() has been invoked");
            return super.preHandle(request, response, handler);
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            super.postHandle(request, response, handler, modelAndView);
            Date requestReceivedAt = (Date) request.getAttribute("requestReceivedAt");
            Date responseSentAt = new Date();
            long interval = responseSentAt.getTime() - requestReceivedAt.getTime();
            // logger.info("RequestExecutionTimer::postHandle() has been invoked");
            logger.info("*****************************************************************************");
            logger.info("*                                                                           *");
            logger.info("*    This request took " + interval + " ms to process on the server.");
            logger.info("*                                                                           *");
            logger.info("*****************************************************************************");
        }
    }
}