package com.areano.customannotations.gateway;

import com.areano.customannotations.gateway.annotation.GatewayMethod;
import com.areano.customannotations.gateway.annotation.GatewayProxy;

@GatewayProxy(baseUrl = "http://bbc.co.uk")
public interface GatewayTwo {
    @GatewayMethod(method = "POST", message = "Message TWO")
    String getMessageTwo();
}
