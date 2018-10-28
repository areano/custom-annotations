package com.areano.customannotations.gateway.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface GatewayProxy {
    String baseUrl();
}