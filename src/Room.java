import java.util.ArrayList;

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
 * This class creates a room object that can hold a certain amount of Person object. There are
 * multiple methods to add/remove a Person object. The list can be printed to show who is in the
 * room.
 * 
 * @author Zach C
 *
 */
public class Room {
  private static ArrayList<String> names = new ArrayList<String>();

  private String name;
  private Person[] occupants;

  private int currentOccupancy;

  /**
   * Returns the current list of room names as an array of Strings
   * 
   * @return String[] roomNames - array of the room names
   */
  public static String[] getNames() {
    String[] roomNames = new String[20];
    for (int i = 0; i < names.size(); i++) {
      if (names.get(i) != null) {
        roomNames[i] = names.get(i);
      }
    }
    return roomNames;
  }

  // INSTANCE METHODS

  /**
   * A two-argument constructor, which initializes the instance variables for the object
   * if the room is created successfully, its name will be add to the Room.names ArrayList
   * 
   * @param name - name of the room
   * @param capacity - amount of people that can be stored (pre-covid)
   */
  public Room(String name, int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("ERROR: capacity must be above 0.");
    }
    for (int i = 0; i < names.size(); i++) {
      if (name.equals(names.get(i))) {
        throw new IllegalArgumentException("ERROR: Room name cannot be equal to previous room.");
      }
    }
    this.name = name;
    occupants = new Person[capacity];

    names.add(name);
  }

  // ACCESSOR METHODS

  /**
   * Method accesses the name of the Room object
   * 
   * @return name - name of the object
   */
  public String getName() {
    return name;
  }


  /**
   * Method accesses the currentOccupancy of the Room object
   * 
   * @return int currentOccupancy - int that stores how many people are in the room
   */
  public int getOccupancy() {
    return currentOccupancy;
  }


  /**
   * Method accesses the covidCapacity of the Room object
   * the method will return the amount of spaces that have a space inbetween them
   * 
   * @return int incrementy - amount of people that can fit given covid restrictions
   */
  public int getCOVIDCapacity() {
    int incrementy = 0;
    for (int i = 0; i < occupants.length; i++) {
      if (i % 2 == 0) {
        incrementy++;
      }
    }
    return incrementy;
  }


  /**
   * Method accesses the capacity of the Room object
   * 
   * @return int occupants.length - the length of the occupants array (max people in a room
   * without covid restrictions)
   */
  public int getCapacity() {
    return occupants.length;
  }


  /**
   * methods returns true if the occupants array contains a person that's passed in
   * and false otherwise.
   * 
   * @param p - Person object that is passed in
   * @return boolean true/false
   */
  public boolean contains(Person p) {
    if (p == null) {
      return false;
    }
    for (int i = 0; i < occupants.length; i++) {
      if (occupants[i] == p) {
        return true;
      }
    }
    return false;
  }

  // MUTATOR METHODS

/**
 * The method adds the Person object that is passed into the Room object's occupants array.
 * The method returns true and toggle's isWaiting boolean if the person was added to the room. 
 * False otherwise.
 * 
 * @param in - Person object that is passed in
 * @return boolean true/false 
 */
  public boolean checkIn(Person in) {
    if (currentOccupancy >= occupants.length / 2) {
      System.out.println("Room is full. Cannot add new person.");
      return false;
    }
    if (in == null) {
      throw new IllegalArgumentException("Person in checkIn is null.");
    }
    for (int i = 0; i < occupants.length; i++) {
      if (in.equals(occupants[i])) {
        throw new IllegalArgumentException("Person in checkIn is already in the room.");
      }
    }
    for (int i = 0; i < occupants.length; i++) {
      if (i % 2 == 0 && occupants[i] == null) {
        occupants[i] = in;
        in.toggleWaiting();
        currentOccupancy++;
        return true;
      }
    }

    return false;
  }

/**
 * The method removes the Person object that is passed into the Room object's occupants array.
 * The method returns true and toggle's isWaiting boolean if the person was removed from the room.
 * False otherwise. 
 * 
 * @param out - Person object that is passed in
 * @return boolean true/false
 */
  public boolean checkOut(Person out) {
    if (out == null) {
      throw new IllegalArgumentException("Person in checkOut is null.");
    }
    for (int i = 0; i < occupants.length; i++) {
      if (out.equals(occupants[i])) {
        out.toggleWaiting();
        currentOccupancy--;
        occupants[i] = null;
        return true;
      }
    }
    return false;
  }

  /**
   * This method visualizes an array and returns a string of the visualization.
   * 
   * @return String returny - full string of a visualized array
   */
  public String toString() {
    String returny = name + "\n===\n";
    for (int i = 0; i < occupants.length; i++) {
      if (occupants[i] != null) {
        returny = returny + occupants[i].getName() + "\n";
      } else {
        returny = returny + "-\n";
      }
    }
    return returny;

  }
}
