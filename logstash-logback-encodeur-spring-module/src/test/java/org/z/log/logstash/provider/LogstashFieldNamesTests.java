package org.z.log.logstash.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class LogstashFieldNamesTests {

  @Test
  void readSpringUser() {
    final LogstashFieldNames llfn = new LogstashFieldNames();
    assertEquals(SpringUserValueJsonProvider.FIELD_SPRING_USER, llfn.getSpringUser());
  }

  @Test
  void changeSpringUser() {
    final UUID uuid = UUID.randomUUID();
    final LogstashFieldNames llfn = new LogstashFieldNames();
    llfn.setSpringUser(uuid.toString());
    assertEquals(uuid.toString(), llfn.getSpringUser());
  }

  @Test
  void readHost() {
    final LogstashFieldNames llfn = new LogstashFieldNames();
    assertEquals(HostValueJsonProvider.FIELD_HOST, llfn.getHost());
  }

  @Test
  void changeHost() {
    final UUID uuid = UUID.randomUUID();
    final LogstashFieldNames llfn = new LogstashFieldNames();
    llfn.setHost(uuid.toString());
    assertEquals(uuid.toString(), llfn.getHost());
  }
}
