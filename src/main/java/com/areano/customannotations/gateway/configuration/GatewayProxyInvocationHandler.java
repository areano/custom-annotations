package com.areano.customannotations.gateway.configuration;

import com.areano.customannotations.gateway.annotation.GatewayMethod;
import com.areano.customannotations.gateway.annotation.GatewayProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class GatewayProxyInvocationHandler implements InvocationHandler {

    private Class<?> type;

    private Map<Method, GatewayMethodHandler> methodHandlers = new HashMap<>();

    GatewayProxyInvocationHandler(Class<?> type) {
        this.type = type;
        GatewayProxy annotation = type.getAnnotation(GatewayProxy.class);
        for (Method method : type.getDeclaredMethods()) {
            if (method.isAnnotationPresent(GatewayMethod.class)) {
                methodHandlers.put(method, new GatewayMethodHandlerImp(annotation.baseUrl(), method));
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("equals".equals(method.getName())) {
            Object otherHandler = args.length > 0 && args[0] != null ? Proxy.getInvocationHandler(args[0]) : null;
            return equals(otherHandler);
        }

        if ("hashCode".equals(method.getName())) {
            return hashCode();
        }

        if ("toString".equals(method.getName())) {
            return toString();
        }

        GatewayMethodHandler handler = methodHandlers.get(method);
        if (handler != null) {
            return handler.processGatewayMethod(args);
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return type.getName() + "@" + Integer.toHexString(hashCode()) + "(proxied by GatewayProxyInvocationHandler)";
    }
}
