package org.z.log.logstash.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.TokenBuffer;

class HostValueJsonProviderTests {

  HostValueJsonProvider hp = new HostValueJsonProvider();

  @Test
  void getFieldName() {
    assertNull(hp.getFieldName());
    hp.setFieldNames(new LogstashFieldNames());
    assertEquals(new LogstashFieldNames().getHost(), hp.getFieldName());
  }

  @Test
  void jsonInsert() throws IOException {
    hp.setFieldNames(new LogstashFieldNames());
    final JsonGenerator jg = new TokenBuffer(new JsonMapper(), false);

    hp.writeTo(jg, null);

    assertEquals("[TokenBuffer: FIELD_NAME(" + new LogstashFieldNames().getHost()
        + "), VALUE_STRING]", jg.toString());
  }

  @Test
  void jsonChangeFieldName() throws IOException {
    final UUID uuid = UUID.randomUUID();
    hp.setFieldName(uuid.toString());
    final JsonGenerator jg = new TokenBuffer(new JsonMapper(), false);

    hp.writeTo(jg, null);

    assertEquals("[TokenBuffer: FIELD_NAME(" + uuid.toString() + "), VALUE_STRING]", jg.toString());
  }

  @Test
  void jsonGetDefautValue() throws IOException {
    final UUID uuid = UUID.randomUUID();
    hp.setDefaultValue(uuid.toString());

    assertEquals(uuid.toString(), hp.getDefaultValue());
  }
}
