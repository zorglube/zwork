package org.z.log.pattern;

import org.z.log.suppliers.HostSupplier;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class HostConverter extends ClassicConverter {

  private final HostSupplier supplier;

  public HostConverter() {
    supplier = new HostSupplier();
  }

  @Override
  public String convert(ILoggingEvent le) {
    return supplier.get();
  }

}
