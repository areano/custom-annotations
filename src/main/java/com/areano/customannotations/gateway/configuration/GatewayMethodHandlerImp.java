package com.areano.customannotations.gateway.configuration;

import com.areano.customannotations.gateway.annotation.GatewayMethod;

import java.lang.reflect.Method;

class GatewayMethodHandlerImp implements GatewayMethodHandler {

    private final String baseUrl;
    private Method method;
    private String message;

    GatewayMethodHandlerImp(String baseUrl, Method method) {
        this.baseUrl = baseUrl;
        this.method = method;
        initParameterHandlers();
    }

    @Override
    public Object processGatewayMethod(Object[] args) {
        return message;
    }

    private void initParameterHandlers() {
        GatewayMethod annotation = method.getAnnotation(GatewayMethod.class);
        message = baseUrl + " - " + annotation.method() + " - " + annotation.message();
    }
}
