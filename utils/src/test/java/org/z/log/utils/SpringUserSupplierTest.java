package org.z.log.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Collection;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.z.log.suppliers.SpringUserSupplier;

class SpringUserSupplierTest {

  @AfterEach
  public void clean() {
    SecurityContextHolder.getContext().setAuthentication(null);
  }

  @Test
  void getValue() {
    final SpringUserSupplier hs = new SpringUserSupplier();
    assertEquals("NO_USER", hs.getDefaultValue());
  }

  @Test
  void get() {
    final SpringUserSupplier hs = new SpringUserSupplier();
    assertEquals("NO_USER", hs.get());
  }

  @Test
  void setValue() {
    final SpringUserSupplier hs = new SpringUserSupplier();
    final UUID uuid = UUID.randomUUID();
    hs.setDefaultValue(uuid.toString());
    assertEquals(uuid.toString(), hs.get());
  }

  @Test
  void setValueConstructor() {
    final UUID uuid = UUID.randomUUID();
    final SpringUserSupplier hs = new SpringUserSupplier(uuid.toString());
    assertEquals(uuid.toString(), hs.get());
  }

  @Test
  void getValueUser() {
    final SpringUserSupplier hs = new SpringUserSupplier();
    SecurityContextHolder.getContext().setAuthentication(new Authentication() {

      @Override
      public String getName() {
        return "User Test";
      }

      @Override
      public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        // TODO Auto-generated method stub

      }

      @Override
      public boolean isAuthenticated() {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public Object getPrincipal() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Object getDetails() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Object getCredentials() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
      }
    });
    assertEquals("NO_USER", hs.getDefaultValue());
  }

  @Test
  void getUser() {
    final SpringUserSupplier hs = new SpringUserSupplier();
    SecurityContextHolder.getContext().setAuthentication(new Authentication() {

      @Override
      public String getName() {
        return "User Test";
      }

      @Override
      public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        // TODO Auto-generated method stub

      }

      @Override
      public boolean isAuthenticated() {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public Object getPrincipal() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Object getDetails() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Object getCredentials() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
      }
    });
    assertEquals("User Test", hs.get());
  }

  // @Test
  // void testDefaultSupplier() {
  // final MockedStatic<ClazzUtil> cu = mockStatic(ClazzUtil.class);
  // cu.when(() -> ClazzUtil.isClassAvailable(any())).thenThrow(LinkageError.class);
  // assertThrows(LinkageError.class, () -> ClazzUtil.isClassAvailable(String.class));
  //
  // final SpringUserSupplier hs = new SpringUserSupplier();
  // assertEquals("NO_USER", hs.get());
  // }
}
