package com.memorynotfound.server;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import java.util.List;
import java.util.Properties;

@EnableWs
@Configuration
public class SoapServerConfig extends WsConfigurerAdapter {

    @Bean
    public SimplePasswordValidationCallbackHandler securityCallbackHandler(){
        SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
        Properties users = new Properties();
        users.setProperty("admin", "secret");
        callbackHandler.setUsers(users);
        return callbackHandler;
    }

    @Bean
    public Wss4jSecurityInterceptor securityInterceptor(){
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setValidationActions("Timestamp UsernameToken");
        securityInterceptor.setValidationCallbackHandler(securityCallbackHandler());
        return securityInterceptor;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext appContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(appContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "beers")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BeersPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(BeerEndpoint.NAMESPACE_URI);
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema beersSchema(){
        return new SimpleXsdSchema(new org.springframework.core.io.ClassPathResource("xsd/beers.xsd"));
    }

}
