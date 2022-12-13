package org.z.log.suppliers;

import static java.util.Objects.requireNonNullElse;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Class that provide the current user by interrogating the {@SecurityContextHolder}.
 *
 * @author ut2q4t
 *
 */
public class HostSupplier implements LoggerSupplier {

  private static final String DEFAULT_VALUE = "NO_HOST";

  private String defaultValue;

  public HostSupplier() {
    this(DEFAULT_VALUE);
  }

  public HostSupplier(String defaultName) {
    String _host;
    try {
      _host = InetAddress.getLocalHost().getCanonicalHostName();
    } catch (final UnknownHostException e) {
      _host = defaultName;
    }
    defaultValue = requireNonNullElse(_host, DEFAULT_VALUE);
  }

  @Override
  public String get() {
    return getDefaultValue();
  }

  @Override
  public String getDefaultValue() {
    return defaultValue;
  }

  @Override
  public void setDefaultValue(String value) {
    defaultValue = value;
  }

}
