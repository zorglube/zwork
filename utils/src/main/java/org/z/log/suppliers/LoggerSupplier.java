package org.z.log.suppliers;

import java.util.function.Supplier;

/**
 * @author ut2q4t
 *
 */
public interface LoggerSupplier extends Supplier<String> {

  /**
   * Return the supplied value
   */
  @Override
  String get();

  /**
   * @param <code>value</code> the default/fallback value
   */
  void setDefaultValue(String value);

  /**
   * @return the default/fallback value
   */
  String getDefaultValue();

}
