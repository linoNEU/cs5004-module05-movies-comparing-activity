import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import movies.Movie;
import movies.MovieImpl;
import movies.Person;
import movies.SortMoviesByTitle;

/**
 * Read movies from a CSV file, convert them into Movie objects, and then add them to a LinkedList.
 */
public class Main {

  /**
   * The logger for this class. A logger is used to log messages to a log file.
   */
  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

  /**
   * Driver class. Read movies from a CSV file, convert them into Movie objects, and then add them
   * to a LinkedList. The list can be ordered by year, title, and director.
   *
   * @param args command line arguments (unused)
   */
  public static void main(String[] args) {
    // Movie info
    String filePath = "res/movies_data.csv";
    String movieString;
    boolean isFirstLine = true;

    // Create a LinkedList to store Movie objects.
    List<Movie> movieList = new LinkedList<>();

    // Read the CSV file line by line; skip the first line (header).
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      while ((movieString = br.readLine()) != null) {
        if (isFirstLine) {
          isFirstLine = false; // Skip the first line (header)
          continue;
        }
        // Turn Movie String into Movie object and add to the LinkedList in the right location.
        movieList.add(turnStringIntoMovie(movieString));
      }
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "Error reading file " + filePath, e);
    }

    // Print the list of movies in the order of the file.
    System.out.println("List of movies:");
    for (Movie movie : movieList) {
      System.out.println(movie.toString());
    }

    // Print the list of movies sorted by year, then title, and then director.
    // We're using the compareTo method from the Movie interface.
    System.out.println("\nList of movies sorted by year, then title, and then director:");
    movieList.stream().sorted().forEach(System.out::println);

    // Print the list of movies sorted by title.
    // We're using the SortMoviesByTitle class.
    System.out.println("\nList of movies sorted by title:");
    movieList.sort(new SortMoviesByTitle());
    movieList.forEach(System.out::println);

    // Print the list of movies sorted by director.
    // We're using the SortMoviesByDirector class.
    System.out.println("\nList of movies sorted by director:");
    // TODO: Sort the movieList by director

    // Print the list of movies made in 1994
    System.out.println("\nList of movies made in 1994:");
    movieList.stream().filter(movie -> movie.getYear() == 1994).forEach(System.out::println);

    // Print the movie titles
    System.out.println("\nList of movie titles:");
    movieList.stream().map(Movie::getTitle).forEach(System.out::println);

    // Print only movies whose title starts with "The" and sort by year.
    System.out.println("\nList of movies whose title starts with \"The\":");
    movieList.stream().filter(movie -> movie.getTitle().startsWith("The")).sorted()
        .forEach(System.out::println);

    // Print other queries here.
    // Example: Print the list of movies made by a specific director.
    // Example: Print the list of movies made before a specific year.
  }

  /**
   * Convert a line of text from the Movie CSV file into a Movie object.
   *
   * @param movieString a line of text from the Movie CSV file
   * @return a Movie object
   */
  private static Movie turnStringIntoMovie(String movieString) {
    // Movie info
    String[] movieInfoArray = movieString.split(",");

    // Director Info
    String[] directorInfoArray = movieInfoArray[1].split(" ");
    String firstName = directorInfoArray[0];
    StringBuilder lastName = new StringBuilder();
    for (int index = 1; index < directorInfoArray.length; index++) {
      if (index > 1) {
        lastName.append(" "); // For directors with more than one word in their last name
      }
      lastName.append(directorInfoArray[index]);
    }

    // Year Info
    int year = Integer.parseInt(movieInfoArray[2]);

    return new MovieImpl(movieInfoArray[0], new Person(firstName, lastName.toString()), year);
  }

}
