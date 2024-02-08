import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import movies.Movie;
import movies.MovieImpl;
import movies.Person;
import movies.CompareMoviesByDirector;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the CompareMoviesByDirector class.
 */
public class CompareMoviesByDirectorTest {

  private Movie movie1;
  private Movie movie2;
  private Movie movie3;
  private CompareMoviesByDirector compareMoviesByDirector;

  /**
   * Set up movies to use for our tests.
   */
  @Before public void setUp() {
    movie1 = new MovieImpl("The Godfather", new Person("Francis", "Ford Coppola"), 1972);
    movie2 = new MovieImpl("Pulp Fiction", new Person("Quentin", "Tarantino"), 1994);
    movie3 = new MovieImpl("Fight Club", new Person("David", "Fincher"), 1999);
    compareMoviesByDirector = new CompareMoviesByDirector();
  }

  /**
   * Basic test for sorting movies by director.
   */
  @Test public void testSortMoviesByDirector() {
    List<Movie> movies = Arrays.asList(movie1, movie2, movie3);
    movies.sort(compareMoviesByDirector);

    assertEquals(movie3, movies.get(0));
    assertEquals(movie1, movies.get(1));
    assertEquals(movie2, movies.get(2));
  }

  /**
   * Test sorting movies with the same director.
   */
  @Test public void testSortMoviesWithSameDirector() {
    Movie movie4 = new MovieImpl("Reservoir Dogs", new Person("Quentin", "Tarantino"), 1992);
    List<Movie> movies = Arrays.asList(movie2, movie4);
    movies.sort(compareMoviesByDirector);

    assertEquals(movie2, movies.get(0));
    assertEquals(movie4, movies.get(1));
  }

  /**
   * Test sorting movies with an empty list.
   */
  @Test public void testSortEmptyMoviesList() {
    List<Movie> movies = Arrays.asList();
    movies.sort(compareMoviesByDirector);

    assertEquals(0, movies.size());
  }
}