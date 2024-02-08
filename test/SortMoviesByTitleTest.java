import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import movies.Movie;
import movies.MovieImpl;
import movies.Person;
import movies.SortMoviesByTitle;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the SortMoviesByTitle class.
 */
public class SortMoviesByTitleTest {

  private Movie movie1;
  private Movie movie2;
  private Movie movie3;
  private SortMoviesByTitle sortMoviesByTitle;

  /**
   * Set up movies to use for our tests.
   */
  @Before public void setUp() {
    movie1 = new MovieImpl("The Godfather", new Person("Francis", "Ford Coppola"), 1972);
    movie2 = new MovieImpl("Pulp Fiction", new Person("Quentin", "Tarantino"), 1994);
    movie3 = new MovieImpl("Fight Club", new Person("David", "Fincher"), 1999);
    sortMoviesByTitle = new SortMoviesByTitle();
  }

  /**
   * Basic test for sorting movies by title.
   */
  @Test public void testSortMoviesByTitle() {
    List<Movie> movies = Arrays.asList(movie1, movie2, movie3);
    movies.sort(sortMoviesByTitle);

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
    movies.sort(sortMoviesByTitle);

    assertEquals(movie1, movies.get(0));
    assertEquals(movie4, movies.get(1));
  }

  /**
   * Test sorting movies with an empty list.
   */
  @Test public void testSortEmptyMoviesList() {
    List<Movie> movies = Arrays.asList();
    movies.sort(sortMoviesByTitle);

    assertEquals(0, movies.size());
  }
}