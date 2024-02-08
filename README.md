# Movie Database Project

We will continue working with a simple movie database implemented in Java. This project reads movie data from a CSV file, converts them into `Movie` objects, and then adds them to a `LinkedList`. The list can be ordered by year, title, and director.

## Getting Started

To get started with this project, clone the repository and open it in IntelliJ IDEA 2023.3.1 or any other IDE that supports Java.

## Prerequisites

You need to have Java installed on your machine to run this project.

## Project Structure

The project is structured as follows:

- `src/movies/Movie.java`: This is an interface that represents a movie.
- `src/movies/MovieImpl.java`: This is a class that implements the `Movie` interface.
- `src/Main.java`: This is the main class that reads movies from a CSV file, converts them into `Movie` objects, and then adds them to a `LinkedList`.
- `test/MovieImplTest.java`: This is a JUnit test class for the `Movie` class.

## Tasks

There are several tasks labeled as TODO in the `Main.java` file. Your task is to implement these methods and operations. Here are the tasks:

1. Write the `equals()` and `hashcode()` methods for `MovieImpl`(see how these methods were written for `Person`).
2. Complete the `SortMoviesByDirector` class to sort the movies by director (see how `SortMoviesByTitle` is implemented).
3. Sort the `movieList` by director.
4. Write other queries. For example, print the list of movies made by a specific director or print the list of movies made before a specific year.

## Running the Tests

To run the tests, navigate to the `test` directory and run the `MovieImplTest.java` file.
