package com.example.jv_sv.service.impl;

import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.jv_sv.service.LoggingService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class LoggingServiceImpl implements LoggingService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingServiceImpl.class);

    @Override
    public void logRequest(HttpServletRequest httpServletRequest, Object body) {
        logger.info("Request Method: {}", httpServletRequest.getMethod());
        logger.info("Request URI: {}", httpServletRequest.getRequestURI());
        logger.info("Request Body: {}", body.toString());

        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = httpServletRequest.getHeader(headerName);
            logger.info("Request Header: {} = {}", headerName, headerValue);
        }
    }

    @Override
    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            Object body) {
        logger.info("Response Status: {}", httpServletResponse.getStatus());
        logger.info("Response Body: {}", body != null ? body.toString() : "No Response Body");
    }
}
