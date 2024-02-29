package com.qnp.configs;

import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RateLimiterInterceptor implements HandlerInterceptor {

    private static final int MAX_REQUESTS = 10;
    private static final long TIME_INTERVAL = 60000; // 60 seconds
    private Queue<Long> requests = new LinkedList<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long currentTime = System.currentTimeMillis();
        synchronized (requests) {
            while (!requests.isEmpty() && currentTime - requests.peek() > TIME_INTERVAL) {
                requests.poll();
            }
            if (requests.size() < MAX_REQUESTS) {
                requests.offer(currentTime);
                return true;
            }
        }
        response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        response.getWriter().write("Too many requests");
        return false;
    }
}