import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import movies.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the class Person.
 */
public class PersonTest {
  private Person lino;
  private Person talia;
  private Person maria;

  /**
   * Set up initial values.
   */
  @Before public void setUp() {
    lino = new Person("Lino", "Coria");
    talia = new Person("Talia", "Coria");
    maria = new Person("Maria", "Andrews");
  }

  /**
   * Test getFirstName() method.
   */
  @Test public void getFirstName() {
    assertEquals("Lino", lino.getFirstName());
    assertEquals("Talia", talia.getFirstName());
    assertEquals("Maria", maria.getFirstName());
  }

  /**
   * Test getLastName() method.
   */
  @Test public void getLastName() {
    assertEquals("Coria", lino.getLastName());
    assertEquals("Coria", talia.getLastName());
    assertEquals("Andrews", maria.getLastName());
  }

  /**
   * Test toString() method.
   */
  @Test public void testToString() {
    assertEquals("Lino Coria", lino.toString());
    assertEquals("Talia Coria", talia.toString());
    assertEquals("Maria Andrews", maria.toString());
  }

  /**
   * Test compareTo() method.
   */
  @Test public void compareTo() {
    assertTrue(lino.compareTo(talia) < 0);
    assertTrue(talia.compareTo(lino) > 0);
    assertEquals(0, maria.compareTo(new Person("Maria", "Andrews")));
    assertTrue(maria.compareTo(lino) < 0);
  }

  /**
   * Test equals() method.
   */
  @Test public void testEquals() {
    assertEquals(lino, new Person("Lino", "Coria"));
    assertEquals(talia, new Person("Talia", "Coria"));
    assertEquals(lino, lino);
    assertNotEquals(lino, talia);
    assertNotEquals(lino, null);
    assertNotEquals(lino, "Lino Coria");
  }

  /**
   * Test hashCode() method.
   */
  @Test public void testHashCode() {
    assertEquals(lino.hashCode(), new Person("Lino", "Coria").hashCode());
    assertNotEquals(lino.hashCode(), talia.hashCode());
  }
}
