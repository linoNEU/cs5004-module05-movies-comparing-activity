package movies;

/**
 * This class represents a movie. The movie has a title, director, and year of release.
 */
public interface Movie extends Comparable<Movie> {
  /**
   * Get the title of the movie.
   *
   * @return the title of the movie
   */
  String getTitle();

  /**
   * Get the name of the director of the movie.
   *
   * @return the name of the director of the movie
   */
  Person getDirector();

  /**
   * Get the year of the movie.
   *
   * @return the year of the movie
   */
  int getYear();

  @Override String toString();

  @Override int compareTo(Movie o);

}
