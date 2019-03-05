//package com.vitalinvent;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class FilterCustomTwo implements Filter {
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        //response.setHeader("HTTP/1.1", "200");
//        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
////        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, OPTIONS");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "parameter1, x-requested-with");
//        System.out.println("filter called");
//        chain.doFilter(req, res);
//    }
//
//    //этот вызов реально работает и вызывается
//    public void init(FilterConfig filterConfig) {System.out.println("init /rest/* filter");}
//
//    public void destroy() {}
//}
