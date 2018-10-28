package com.areano.customannotations.gateway;

import com.areano.customannotations.gateway.annotation.GatewayMethod;
import com.areano.customannotations.gateway.annotation.GatewayProxy;

@GatewayProxy(baseUrl = "http://google.com")
public interface GatewayOne {
    @GatewayMethod(method = "GET", message = "Message ONE")
    String getMessageOne();
}
