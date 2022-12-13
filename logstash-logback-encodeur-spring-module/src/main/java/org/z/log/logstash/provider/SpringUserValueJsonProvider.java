package org.z.log.logstash.provider;

import java.io.IOException;
import java.util.Map.Entry;

import org.z.log.suppliers.SpringUserSupplier;

import com.fasterxml.jackson.core.JsonGenerator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import net.logstash.logback.composite.AbstractFieldJsonProvider;
import net.logstash.logback.composite.FieldNamesAware;
import net.logstash.logback.composite.JsonWritingUtils;

public class SpringUserValueJsonProvider extends AbstractFieldJsonProvider<ILoggingEvent>
    implements FieldNamesAware<LogstashFieldNames> {

  public static final String FIELD_SPRING_USER = SpringUserSupplier.MDC_FIELD;
  private final SpringUserSupplier supplier;

  public SpringUserValueJsonProvider() {
    supplier = new SpringUserSupplier();
  }

  @Override
  public void writeTo(JsonGenerator generator, ILoggingEvent event) throws IOException {
    final String user = event.getMDCPropertyMap().entrySet().stream()
        .filter(e -> e.getKey().equals(FIELD_SPRING_USER)).findFirst().map(Entry::getValue)
        .orElse(getDefaultValue());

    JsonWritingUtils.writeStringField(generator, getFieldName(), user);
  }

  @Override
  public void setFieldNames(LogstashFieldNames fieldNames) {
    setFieldName(fieldNames.getSpringUser());
  }

  public void setDefaultValue(String str) {
    supplier.setDefaultValue(str);
  }

  public String getDefaultValue() {
    return supplier.getDefaultValue();
  }

}
