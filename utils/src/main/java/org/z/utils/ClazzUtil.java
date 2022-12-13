package org.z.utils;

public class ClazzUtil {

  private ClazzUtil() {}

  public static boolean isClassAvailable(String clazz) {
    try {
      Class.forName(clazz, false, ClazzUtil.class.getClassLoader());
    } catch (LinkageError | ClassNotFoundException e) {
      return false;
    }
    return true;
  }

}
