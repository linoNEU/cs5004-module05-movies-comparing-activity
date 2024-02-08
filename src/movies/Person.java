package movies;

import java.util.Objects;

/**
 * This class represents a person, the person has a first name and last name.
 */
public class Person implements Comparable<Person> {
  private final String firstName;
  private final String lastName;

  /**
   * Constructs a Person object and initializes it to the given first name and last name.
   *
   * @param firstName the first name of this person
   * @param lastName  the last name of this person
   */
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Get the first name of this person.
   *
   * @return the first name of this person
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Return the last name of this person.
   *
   * @return the last name of this person
   */
  public String getLastName() {
    return this.lastName;
  }

  @Override public String toString() {
    return this.getFirstName() + " " + this.getLastName();
  }

  @Override public int compareTo(Person o) {
    if (this.lastName.equalsIgnoreCase(o.lastName)) {
      return (this.firstName).compareToIgnoreCase(o.firstName);
    }
    return this.lastName.compareToIgnoreCase(o.lastName);
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return firstName.equals(person.firstName) && lastName.equals(person.lastName);
  }

  @Override public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}
