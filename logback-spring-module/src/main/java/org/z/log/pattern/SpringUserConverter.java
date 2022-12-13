package org.z.log.pattern;

import java.util.Map.Entry;

import org.z.log.suppliers.SpringUserSupplier;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * Return the event's Spring User.
 *
 * @author ut2q4t
 */
public class SpringUserConverter extends ClassicConverter {

  @Override
  public String convert(ILoggingEvent le) {
    return le.getMDCPropertyMap().entrySet().stream()
        .filter(e -> SpringUserSupplier.MDC_FIELD.equals(e.getKey())).findFirst()
        .map(Entry::getValue).orElse("ANONYMOUS");
  }

}
