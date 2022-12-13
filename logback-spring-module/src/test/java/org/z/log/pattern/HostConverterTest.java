package org.z.log.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HostConverterTest {

  String host;

  @BeforeEach
  public void init() throws UnknownHostException {
    host = InetAddress.getLocalHost().getCanonicalHostName();
  }

  @Test
  void getHost() {
    final HostConverter hc = new HostConverter();

    assertEquals(host, hc.convert(null));
  }

}
