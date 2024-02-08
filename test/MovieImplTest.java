import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import movies.Movie;
import movies.MovieImpl;
import movies.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Movie class.
 */
public class MovieImplTest {
  private Movie theApartment;
  private Movie laDolceVita;
  private Movie drStrangeLove;

  /**
   * Set up movies to use for our tests.
   */
  @Before public void setUp() {
    Person billyWilder = new Person("Billy", "Wilder");
    this.theApartment = new MovieImpl("The Apartment", billyWilder, 1960);
    Person federicoFellini = new Person("Federico", "Fellini");
    this.laDolceVita = new MovieImpl("La Dolce Vita", federicoFellini, 1960);
    Person stanleyKubrick = new Person("Stanley", "Kubrick");
    this.drStrangeLove = new MovieImpl("Dr. Strangelove", stanleyKubrick, 1964);
  }

  /**
   * Test the title of the movie.
   */
  @Test public void testTitle() {
    assertEquals("The Apartment", theApartment.getTitle());
    assertEquals("Dr. Strangelove", drStrangeLove.getTitle());
  }

  /**
   * Test the director of the movie.
   */
  @Test public void testDirector() {
    assertEquals("Billy Wilder", theApartment.getDirector().toString());
    assertEquals("Federico Fellini", laDolceVita.getDirector().toString());
  }

  /**
   * Test the year of the movie.
   */
  @Test public void testYear() {
    assertEquals(1960, theApartment.getYear());
    assertEquals(1960, laDolceVita.getYear());
  }

  /**
   * Test toString() method.
   */
  @Test public void testToString() {
    assertEquals("The Apartment (Billy Wilder, 1960)", this.theApartment.toString());
    assertEquals("La Dolce Vita (Federico Fellini, 1960)", this.laDolceVita.toString());
    assertEquals("Dr. Strangelove (Stanley Kubrick, 1964)", this.drStrangeLove.toString());
  }

  /**
   * Test compareTo() method.
   */
  @Test public void testCompareTo() {

    assertTrue(this.theApartment.compareTo(this.drStrangeLove) < 0);
    assertEquals(0, this.drStrangeLove.compareTo(
        new MovieImpl("Dr. Strangelove", new Person("Stanley", "Kubrick"), 1964)));
    assertTrue(this.theApartment.compareTo(this.laDolceVita) > 0);

    Person fakeFilmmaker = new Person("Mickey", "Mouse");
    Movie fakeMovie = new MovieImpl("The Apartment", fakeFilmmaker, 1960);
    assertTrue(this.theApartment.compareTo(fakeMovie) > 0);
  }

  /**
   * Test equals() method.
   */
  @Test public void testEquals() {
    assertEquals(this.theApartment,
        new MovieImpl("The Apartment", new Person("Billy", "Wilder"), 1960));
    assertEquals(this.drStrangeLove,
        new MovieImpl("Dr. Strangelove", new Person("Stanley", "Kubrick"), 1964));
    assertEquals(this.theApartment, this.theApartment);
    assertNotEquals(this.theApartment, this.drStrangeLove);
    assertNotEquals(null, this.theApartment);
    assertNotEquals("The Apartment (Billy Wilder, 1960)", this.theApartment);
  }

  /**
   * Test hashCode() method.
   */
  @Test public void testHashCode() {
    assertEquals(this.theApartment.hashCode(),
        new MovieImpl("The Apartment", new Person("Billy", "Wilder"), 1960).hashCode());
    assertEquals(this.drStrangeLove.hashCode(),
        new MovieImpl("Dr. Strangelove", new Person("Stanley", "Kubrick"), 1964).hashCode());
  }

}
