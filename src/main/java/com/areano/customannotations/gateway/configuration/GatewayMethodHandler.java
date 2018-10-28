package com.areano.customannotations.gateway.configuration;

public interface GatewayMethodHandler {
    Object processGatewayMethod(Object[] args);
}
