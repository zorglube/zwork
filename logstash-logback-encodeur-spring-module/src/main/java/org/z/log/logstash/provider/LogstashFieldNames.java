package org.z.log.logstash.provider;

public class LogstashFieldNames extends net.logstash.logback.fieldnames.LogstashFieldNames {

  private String springUser = SpringUserValueJsonProvider.FIELD_SPRING_USER;
  private String host = HostValueJsonProvider.FIELD_HOST;

  public String getSpringUser() {
    return springUser;
  }

  public void setSpringUser(String springUser) {
    this.springUser = springUser;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

}
