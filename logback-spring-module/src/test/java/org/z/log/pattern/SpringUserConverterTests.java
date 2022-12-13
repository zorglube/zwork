package org.z.log.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.slf4j.Marker;
import org.z.log.suppliers.SpringUserSupplier;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggerContextVO;

class SpringUserConverterTests {

  @Test
  void noUser() {
    final SpringUserConverter suc = new SpringUserConverter();
    final ILoggingEvent le = new ILoggingEvent() {

      @Override
      public void prepareForDeferredProcessing() {}

      @Override
      public boolean hasCallerData() {
        return false;
      }

      @Override
      public long getTimeStamp() {
        return 0;
      }

      @Override
      public IThrowableProxy getThrowableProxy() {
        return null;
      }

      @Override
      public String getThreadName() {
        return null;
      }

      @Override
      public String getMessage() {
        return null;
      }

      @Override
      public Map<String, String> getMdc() {
        return Map.of();
      }

      @Override
      public Marker getMarker() {
        return null;
      }

      @Override
      public Map<String, String> getMDCPropertyMap() {
        return Map.of();
      }

      @Override
      public String getLoggerName() {
        return null;
      }

      @Override
      public LoggerContextVO getLoggerContextVO() {
        return null;
      }

      @Override
      public Level getLevel() {
        return null;
      }

      @Override
      public String getFormattedMessage() {
        return null;
      }

      @Override
      public StackTraceElement[] getCallerData() {
        return new StackTraceElement[] {};
      }

      @Override
      public Object[] getArgumentArray() {
        return new Object[] {};
      }
    };

    assertEquals("ANONYMOUS", suc.convert(le));
  }

  @Test
  void userTest() {
    final UUID uuid = UUID.randomUUID();
    final ILoggingEvent le = new ILoggingEvent() {

      @Override
      public void prepareForDeferredProcessing() {}

      @Override
      public boolean hasCallerData() {
        return false;
      }

      @Override
      public long getTimeStamp() {
        return 0;
      }

      @Override
      public IThrowableProxy getThrowableProxy() {
        return null;
      }

      @Override
      public String getThreadName() {
        return null;
      }

      @Override
      public String getMessage() {
        return null;
      }

      @Override
      public Map<String, String> getMdc() {
        return Map.of();
      }

      @Override
      public Marker getMarker() {
        return null;
      }

      @Override
      public Map<String, String> getMDCPropertyMap() {
        return Map.of(SpringUserSupplier.MDC_FIELD, uuid.toString());
      }

      @Override
      public String getLoggerName() {
        return null;
      }

      @Override
      public LoggerContextVO getLoggerContextVO() {
        return null;
      }

      @Override
      public Level getLevel() {
        return null;
      }

      @Override
      public String getFormattedMessage() {
        return null;
      }

      @Override
      public StackTraceElement[] getCallerData() {
        return new StackTraceElement[] {};
      }

      @Override
      public Object[] getArgumentArray() {
        return new Object[] {};
      }
    };

    final SpringUserConverter suc = new SpringUserConverter();
    assertEquals(uuid.toString(), suc.convert(le));
  }
}
