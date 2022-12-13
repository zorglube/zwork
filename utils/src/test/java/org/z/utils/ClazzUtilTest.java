package org.z.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class ClazzUtilTest {

  @Test
  void hasClazz() {
    assertTrue(ClazzUtil.isClassAvailable("java.lang.String"));
  }

  @Test
  void hasentClass() {
    final MockedStatic<ClazzUtil> cu = mockStatic(ClazzUtil.class);
    cu.when(() -> ClazzUtil.isClassAvailable(any())).thenThrow(LinkageError.class);
    assertThrows(LinkageError.class, () -> ClazzUtil.isClassAvailable("java.lang.String"));
  }

}
