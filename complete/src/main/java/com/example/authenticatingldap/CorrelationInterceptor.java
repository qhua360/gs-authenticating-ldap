package com.example.authenticatingldap;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CorrelationInterceptor extends HandlerInterceptorAdapter {

    private static final String CORRELATION_ID_HEADER_NAME = "X-Correlation-Id";
    private static final String CORRELATION_ID_LOG_VAR_NAME = "correlationId";
    private static final String API_LOG_VAR_NAME = "api";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String correlationId = getCorrelationIdFromHeader(request);
        MDC.put(CORRELATION_ID_LOG_VAR_NAME, correlationId);
        MDC.put(API_LOG_VAR_NAME, request.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MDC.remove(CORRELATION_ID_LOG_VAR_NAME);
        MDC.remove(API_LOG_VAR_NAME);
    }

    private String getCorrelationIdFromHeader(final HttpServletRequest request) throws Exception {
        String correlationId = request.getHeader(CORRELATION_ID_HEADER_NAME);
        if (StringUtils.isEmpty(correlationId)) {
//            throw new Exception("No correlation id provided");
            correlationId = "correlationId123";
        }
        return correlationId;
    }
}
