# Logback Spring Module

Add the abbility to get the current user has a log pattern for Logback when you're running a `Spring` project, also contain the abbility to get the curren `host`
Tested for Spring-Boot 2.7.X. 

## Usage 

Maven : 

```xml
<dependency>
    <groupId>org.z</groupId>
    <artifactId>logback-spring-module</artifactId>
</dependency>
```

Logback conf : 

```xml
<configuration debug="true" scan="fase">
    ...    
    <conversionRule 
       conversionWord="springUser"
       converterClass="org.z.log.pattern.SpringUserConverter" />

    <appender name="..." class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>... User:%springUser ...</pattern>
        </encoder>
    </appender>
    ...
</configuration>
```
