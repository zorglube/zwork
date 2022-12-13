package org.z.log.logstash.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.slf4j.Marker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggerContextVO;

class SpringUserValueJsonProviderTests {

  SpringUserValueJsonProvider sup = new SpringUserValueJsonProvider();

  @Test
  void getFieldName() {
    assertNull(sup.getFieldName());
    sup.setFieldNames(new LogstashFieldNames());
    assertEquals(new LogstashFieldNames().getSpringUser(), sup.getFieldName());
  }

  @Test
  void jsonInsert() throws IOException {
    sup.setFieldNames(new LogstashFieldNames());
    final JsonGenerator jg = new TokenBuffer(new JsonMapper(), false);
    final ILoggingEvent le = new ILoggingEvent() {

      @Override
      public void prepareForDeferredProcessing() {
        // TODO Auto-generated method stub

      }

      @Override
      public boolean hasCallerData() {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public long getTimeStamp() {
        // TODO Auto-generated method stub
        return 0;
      }

      @Override
      public IThrowableProxy getThrowableProxy() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public String getThreadName() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public String getMessage() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Map<String, String> getMdc() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Marker getMarker() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Map<String, String> getMDCPropertyMap() {
        return Map.of();
      }

      @Override
      public String getLoggerName() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public LoggerContextVO getLoggerContextVO() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Level getLevel() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public String getFormattedMessage() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public StackTraceElement[] getCallerData() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Object[] getArgumentArray() {
        // TODO Auto-generated method stub
        return null;
      }
    };
    sup.writeTo(jg, le);

    assertEquals("[TokenBuffer: FIELD_NAME(" + new LogstashFieldNames().getSpringUser()
        + "), VALUE_STRING]", jg.toString());
  }

  @Test
  void jsonChangeFieldName() throws IOException {
    final UUID uuid = UUID.randomUUID();
    sup.setFieldName(uuid.toString());
    final JsonGenerator jg = new TokenBuffer(new JsonMapper(), false);
    final ILoggingEvent le = new ILoggingEvent() {

      @Override
      public void prepareForDeferredProcessing() {
        // TODO Auto-generated method stub

      }

      @Override
      public boolean hasCallerData() {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public long getTimeStamp() {
        // TODO Auto-generated method stub
        return 0;
      }

      @Override
      public IThrowableProxy getThrowableProxy() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public String getThreadName() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public String getMessage() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Map<String, String> getMdc() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Marker getMarker() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Map<String, String> getMDCPropertyMap() {
        return Map.of();
      }

      @Override
      public String getLoggerName() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public LoggerContextVO getLoggerContextVO() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Level getLevel() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public String getFormattedMessage() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public StackTraceElement[] getCallerData() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Object[] getArgumentArray() {
        // TODO Auto-generated method stub
        return null;
      }
    };
    sup.writeTo(jg, le);

    assertEquals("[TokenBuffer: FIELD_NAME(" + uuid.toString() + "), VALUE_STRING]", jg.toString());
  }

  @Test
  void jsonGetDefautValue() throws IOException {
    final UUID uuid = UUID.randomUUID();
    sup.setDefaultValue(uuid.toString());

    assertEquals(uuid.toString(), sup.getDefaultValue());
  }
}
