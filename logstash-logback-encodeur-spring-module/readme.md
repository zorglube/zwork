# Logstash Logback Encodeur Spring Module

Add the abbility to have the current `User` into the log pattern of the Logback module `logstash-logback-encoder` when you're running a `Spring` projet, also contain the abbility to get the curren `host`
Tested for Spring-Boot 2.7.X. 

## Usage 

Maven : 

```xml
<dependency>
    <groupId>org.z</groupId>
    <artifactId>logstash-logback-encodeur-spring-module</artifactId>
</dependency>
```

Logback conf : 

```xml
<configuration debug="true" scan="fase">
    ...
    <appender name="jsonSTDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="net.logstash.logback.encoder.LoggingEventCompositeJsonEncoder">
            <providers>
                <provider class="org.z.log.logstash.provider.SpringUserValueJsonProvider">
                    <fieldName>@u</fieldName>
                    <defaultValue>Not Identified</defaultValue>
                </provider>
                <provider class="org.z.log.logstash.provider.HostValueJsonProvider">
                    <fieldName>@h</fieldName>
                    <defaultValue>No Host</defaultValue>
                </provider>
                ...
                <pattern>
                    <pattern>
                        {
                            "@t": "%date{yyyy-MM-dd'T'HH:mm:ss.SSSZ}",
                            "@s": "%level",
                            "@m": "%message",
                            "@e": "${envName}",
                            "@sbe": "${subEnvName}",
                            "@a": "${appName}",
                            "@cp": "${componentName}",
                            "@scp": "%logger{40}",
                            "@co": "%mdc{correlationId}",
                            "@v": "${version}",
                            "@st": "%exception{full}",
                            "@d": "#asJson{%mdc{dataObject}}"
                        }
                    </pattern>
                </pattern>
                ...
            </providers>
        </encoder>
    </appender>
    ...
</configuration>
```
