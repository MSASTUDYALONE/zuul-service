package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {
//    Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class); // 1. 객체생성
//    @Override
//    public Object run() throws ZuulException { // 실제 동작하는 부분. 사용자 요청이 들어오면 먼저 실행되는 메소드
//        // 2. 로거 러벨에 따라서 다음 단게에 어떤 데이터를 출력할 것인지 지정
////        logger.info("info"); // 로거의 레벨
////        logger.debug("debug"); // 로거의 디버그
////        logger.warn("warn"); // 원인 메시지
////        logger.error("error"); // 에러 메시지
//
//        log.info("*************** printing logs: ");
//
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        log.info("*************** " + request.getRequestURI());
//        return null;
//    }

    @Override
    public Object run() throws ZuulException {
        log.info("*************** printing logs: ");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("*************** " + request.getRequestURI());
        return null;
    }


    @Override
    public String filterType() {
        return "pre"; // 사전필터이다.
    }

    @Override
    public int filterOrder() { // 필터가 여러 개일 경우, 순서를 말한다.
        return 1;  // 하나밖에 없으니까 그냥 1넣겠음
    }

    @Override
    public boolean shouldFilter() {
        return true; // 필터를 쓰겠다.
    }
}
