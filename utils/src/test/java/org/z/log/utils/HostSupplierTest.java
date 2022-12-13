package org.z.log.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.z.log.suppliers.HostSupplier;

class HostSupplierTest {

  // @Test
  // void getValue() throws UnknownHostException {
  // final String host = InetAddress.getLocalHost().getCanonicalHostName();
  // final HostSupplier hs = new HostSupplier();
  // assertEquals(host, hs.getValue());
  // }

  // @Test
  // void get() throws UnknownHostException {
  // final String host = InetAddress.getLocalHost().getCanonicalHostName();
  // final HostSupplier hs = new HostSupplier();
  // assertEquals(host, hs.get());
  // }

  @Test
  void setValue() {
    final UUID uuid = UUID.randomUUID();
    final HostSupplier hs = new HostSupplier();
    hs.setDefaultValue(uuid.toString());
    assertEquals(uuid.toString(), hs.getDefaultValue());
  }

  @Test
  void setValueConstructor() throws UnknownHostException {
    final String host = InetAddress.getLocalHost().getCanonicalHostName();
    final UUID uuid = UUID.randomUUID();
    final HostSupplier hs = new HostSupplier(uuid.toString());
    assertEquals(host, hs.getDefaultValue());
  }

  @Test
  void defautValue() throws UnknownHostException {
    final MockedStatic<InetAddress> inetA = mockStatic(InetAddress.class);
    inetA.when(InetAddress::getLocalHost).thenThrow(new UnknownHostException());
    final UUID uuid = UUID.randomUUID();
    final HostSupplier hs = new HostSupplier(uuid.toString());
    assertEquals(uuid.toString(), hs.get());
  }

}
