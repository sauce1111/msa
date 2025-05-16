package com.msa.zuul_service.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        // 사전필터 || 사후필터 결정 하는 부분, 예제는 사전
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 필터가 여러개 일 경우 순서 지정
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // 필터 사용여부
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("********************* printing logs :");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("********************* printing logs :" + request.getRequestURI());
        return null;
    }
}
