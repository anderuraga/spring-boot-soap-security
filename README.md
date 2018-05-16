# Spring Boot SOAP Web Service Security

Proyecto Web Service con SOAP con seguridad WSS4J, tambien se ha creado un cliente para poder consumirlo



	- Spring boot 2.0.1.RELEASE
	- Java 1.8
	- jaxb2
	- Security
	- WSS4J
	
	
## definir xs:schema para WS

src/main/resources/beer.xsd

Las clases java necesarias se generan solas mediante un plugin maven:

			<groupId>org.codehaus.mojo</groupId>
			<artifactId>jaxb2-maven-plugin</artifactId>
			<version>1.6</version>
			


## configuracion WS y seguridad

com.memorynotfound.server.SoapServerConfig

Usar anotacion @EnableWs
Se carga el beers.xsd y se define donde atiende el servicio web: [http://localhost:8080/ws/beers.wsdl](http://localhost:8080/ws/beers.wsdl)

### seguridad

com.memorynotfound.server.SoapServerConfig 
Usamos un UsernameToken (admin, secret) encriptado que se envia en la cabecera del envelope. Adicionalmente tambien usamos un Timestamp con el tiempo que la petición es valida.


    - *SimplePasswordValidationCallbackHandler  => UsernameToken(admin,user)
    - Wss4jSecurityInterceptor => Interceptor propio para TimeStamp
    - addInterceptors => añade el interceptor

*Recomendable cambiar SimplePasswordValidationCallbackHandler => SpringSecurityPasswordValidationCallbackHandler which you can register the UserDetailsService to retrieve your user information.






## Definir @Endpoint


com.memorynotfound.server.BeerEndpoint

Clase donde se definien los mensajes de entrada y salida para el servicio 


## Referencias 
Tutorial Ingles(https://memorynotfound.com/spring-ws-username-password-authentication-wss4j/) 

Apache WSS4J(https://ws.apache.org/wss4j/) 

Wss4jSecurityInterceptor JavaDoc(https://docs.spring.io/spring-ws/docs/2.2.4.RELEASE/api/org/springframework/ws/soap/security/wss4j/Wss4jSecurityInterceptor.html) 

Wss4jSecurityInterceptor Documentation(https://docs.spring.io/spring-ws/docs/2.2.4.RELEASE/reference/htmlsingle/#security-wss4j-security-interceptor) 

 



## Ejemplo llamada desde SOAP UI

Realizar la llamada desde el cliente de java RunClient => copiar y pegar desde la consola SOAP-ENV:Envelope completo para realizar peticion desde SOAP UI.
 
![Alt text](https://github.com/anderuraga/spring-boot-soap-security/blob/master/screenshot.png)

			
			 
