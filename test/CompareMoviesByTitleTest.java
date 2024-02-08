import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import movies.Movie;
import movies.MovieImpl;
import movies.Person;
import movies.CompareMoviesByTitle;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the CompareMoviesByTitle class.
 */
public class CompareMoviesByTitleTest {

  private Movie movie1;
  private Movie movie2;
  private Movie movie3;
  private CompareMoviesByTitle compareMoviesByTitle;

  /**
   * Set up movies to use for our tests.
   */
  @Before public void setUp() {
    movie1 = new MovieImpl("The Godfather", new Person("Francis", "Ford Coppola"), 1972);
    movie2 = new MovieImpl("Pulp Fiction", new Person("Quentin", "Tarantino"), 1994);
    movie3 = new MovieImpl("Fight Club", new Person("David", "Fincher"), 1999);
    compareMoviesByTitle = new CompareMoviesByTitle();
  }

  /**
   * Basic test for sorting movies by title.
   */
  @Test public void testSortMoviesByTitle() {
    List<Movie> movies = Arrays.asList(movie1, movie2, movie3);
    movies.sort(compareMoviesByTitle);

    assertEquals(movie3, movies.get(0));
    assertEquals(movie2, movies.get(1));
    assertEquals(movie1, movies.get(2));
  }

  /**
   * Test sorting movies with the same title.
   */
  @Test public void testSortMoviesWithSameTitle() {
    Movie movie4 = new MovieImpl("The Godfather", new Person("Martin", "Scorsese"), 1980);
    List<Movie> movies = Arrays.asList(movie1, movie4);
    movies.sort(compareMoviesByTitle);

    assertEquals(movie1, movies.get(0));
    assertEquals(movie4, movies.get(1));
  }

  /**
   * Test sorting movies with an empty list.
   */
  @Test public void testSortEmptyMoviesList() {
    List<Movie> movies = Arrays.asList();
    movies.sort(compareMoviesByTitle);

    assertEquals(0, movies.size());
  }
}