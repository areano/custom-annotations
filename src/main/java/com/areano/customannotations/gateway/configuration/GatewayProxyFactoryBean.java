package com.areano.customannotations.gateway.configuration;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

import java.lang.reflect.Proxy;

class GatewayProxyFactoryBean implements FactoryBean<Object>, EmbeddedValueResolverAware {

    private Class<?> type;

    @Override
    public Object getObject() {
        GatewayProxyInvocationHandler invocationHandler = new GatewayProxyInvocationHandler(this.type);
        return Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[]{type}, invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        StringValueResolver valueResolver = resolver;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }
}