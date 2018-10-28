package com.areano.customannotations;

import com.areano.customannotations.gateway.configuration.EnableGatewayProxy;
import com.areano.customannotations.gateway.GatewayOne;
import com.areano.customannotations.gateway.GatewayTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableGatewayProxy
public class Application implements CommandLineRunner {

    private final GatewayOne gatewayOne;
    private final GatewayTwo gatewayTwo;

    @Autowired
    public Application(GatewayOne gatewayOne, GatewayTwo gatewayTwo) {
        this.gatewayOne = gatewayOne;
        this.gatewayTwo = gatewayTwo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(gatewayOne.getMessageOne());
        System.out.println(gatewayTwo.getMessageTwo());
    }
}
