package movies;

import java.util.Comparator;

/**
 * This class implements the Comparator interface. It compares two movies by their titles.
 */
public class SortMoviesByTitle implements Comparator<Movie> {

  @Override public int compare(Movie o1, Movie o2) {
    return o1.getTitle().compareToIgnoreCase(o2.getTitle());
  }
}
