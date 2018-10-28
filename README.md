# Custom Annotations

This is a demo project for creating proxy objects from annotated interfaces. 
The project creates a set of custom annotations and provides concrete implementations using proxy objects.

It uses the spring features but quite a lot of steps need to be done before creating a proxy
* Create customs annotations to use with with the interfaces (@GatewayProxy and @GatewayMethod)
* Create a custom annotation to indicate the application needs to configure the GatewayProxy objects 
(@EnableGatewayProxy)
* Create a custom Registrar for configuring the GatewayProxy objects. This includes scanning the packages for looking 
for annotated interfaces
* Create a ProxyBeanFactory which will provide the proxy implementations for the annotated interfaces
* Create a method handler which will be used when a method form the proxied interfaces is called

## References
I was trying to do some similar to the JPARespository but I failed to understand the logic in the Spring source code.
Finally, I found project [Muon](https://github.com/muoncore/muon-java) which implements some of its core features with 
a similar pattern.

## Building
The project uses Gradlew can be run with the following commands
* gradlew clean build
* gradlew bootrun
