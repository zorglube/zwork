package org.z.log.logstash.provider;

import java.io.IOException;

import org.z.log.suppliers.HostSupplier;

import com.fasterxml.jackson.core.JsonGenerator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import net.logstash.logback.composite.AbstractFieldJsonProvider;
import net.logstash.logback.composite.FieldNamesAware;
import net.logstash.logback.composite.JsonWritingUtils;

public class HostValueJsonProvider extends AbstractFieldJsonProvider<ILoggingEvent>
    implements FieldNamesAware<LogstashFieldNames> {

  public static final String FIELD_HOST = "host";
  private final HostSupplier supplier;

  public HostValueJsonProvider() {
    supplier = new HostSupplier();
  }

  @Override
  public void writeTo(JsonGenerator generator, ILoggingEvent event) throws IOException {
    JsonWritingUtils.writeStringField(generator, getFieldName(), supplier.get());
  }

  @Override
  public void setFieldNames(LogstashFieldNames fieldNames) {
    setFieldName(fieldNames.getHost());
  }

  public void setDefaultValue(String str) {
    supplier.setDefaultValue(str);
  }

  public String getDefaultValue() {
    return supplier.getDefaultValue();
  }

}
