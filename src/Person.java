//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Self Checkout Kiosk
// Course: CS 300 Spring 2021
//
// Author: Zachary Collins
// Email: ztcollins@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: -
// Online Sources: -
//
///////////////////////////////////////////////////////////////////////////////
/**
 * Class is for creating a Person object and allowing variables to be called / changed.
 * 
 * @author Zach C
 *
 */
public class Person {
  private String name;
  private boolean isWaiting;

  /**
   * Constructor that initializes the instance variables for the object
   * 
   * @param name - name of the Person object
   */
  public Person(String name) {
    this.name = name;
    isWaiting = true;
  }

  /**
   * Accesses the name String of a person object
   * 
   * @return String name
   */
  public String getName() {
    return name;
  }

  /**
   * Accesses the boolean if the person object is waiting
   * 
   * @return boolean isWaiting
   */
  public boolean isWaiting() {
    return isWaiting;
  }

  /**
   * Void method that toggles boolean isWaiting to true if it is false and vice versa
   * 
   */
  public void toggleWaiting() {
    if (isWaiting == false) {
      isWaiting = true;
    } else if (isWaiting == true) {
      isWaiting = false;
    }
  }


  /**
   * method in the document (do not change)
   * overrides the equals method and makes it so that an object is equal if it has the same name
   * 
   */
  public boolean equals(Object o) {
    if (o instanceof Person) {
      return this.name.equals(((Person) o).name);
    }
    return false;
  }
}
