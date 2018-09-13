package com.fendi.ttclub.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceMethodInterceptor implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMethodInterceptor.class);

    public ServiceMethodInterceptor() {
        super();
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        LOGGER.info("before ServiceMethodInterceptor invoke");
        LOGGER.info(invocation.getMethod().getName());
        Object object = invocation.proceed();
        System.out.println("after ServiceMethodInterceptor invoke");
        return object;
    }
}
