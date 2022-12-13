package org.z.log.suppliers;

import static org.z.utils.ClazzUtil.isClassAvailable;
import static java.util.Objects.requireNonNullElse;
import java.util.function.Supplier;
import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Class that provide the current user by interrogating the {@SecurityContextHolder}.
 *
 * @author ut2q4t
 *
 */
public class SpringUserSupplier implements LoggerSupplier {

  private static final String DEFAULT_VALUE = "NO_USER";
  public static final String MDC_FIELD = "springUser";

  private String defaultValue;
  private Supplier<String> internalSupplier;

  public SpringUserSupplier() {
    this(DEFAULT_VALUE);
  }

  public SpringUserSupplier(String defaultName) {
    defaultValue = requireNonNullElse(defaultName, DEFAULT_VALUE);

    if (isClassAvailable("org.springframework.security.core.context.SecurityContextHolder")) {
      internalSupplier = () -> {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null ? auth.getName() : defaultValue;
      };
    } else {
      internalSupplier = () -> defaultValue;
    }
  }

  @Override
  public String get() {
    return internalSupplier.get();
  }

  @Override
  public void setDefaultValue(String value) {
    defaultValue = value;
  }

  @Override
  public String getDefaultValue() {
    return defaultValue;
  }

  public void mdcSupplie(String mdcField) {
    MDC.put(mdcField, internalSupplier.get());
  }

}
