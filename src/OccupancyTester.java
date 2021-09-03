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
 * This class tests the methods in previous classes through calling them and comparing
 * them to predetermined outputs.
 * 
 * @author Zach C
 *
 */
public class OccupancyTester {

  public static void main(String[] args) {
    // testPerson()
    if (testPerson() == false) {
      System.out.println("testPerson() failed.");
    } else {
      System.out.println("testPerson() passed.");
    }

    // testRoomConstructor()
    if (testRoomConstructor() == false) {
      System.out.println("testRoomConstructor() failed.");
    } else {
      System.out.println("testRoomConstructor() passed.");
    }

    // testRoomAccessors()
    if (testRoomAccessors() == false) {
      System.out.println("testRoomAccessors() failed.");
    } else {
      System.out.println("testRoomAccessors() passed.");
    }

    // testRoomCheckIn()
    if (testRoomCheckIn() == false) {
      System.out.println("testRoomCheckIn() failed.");
    } else {
      System.out.println("testRoomCheckIn() passed.");
    }

    // testRoomCheckOut()
    if (testRoomCheckOut() == false) {
      System.out.println("testRoomCheckOut() failed.");
    } else {
      System.out.println("testRoomCheckOut() passed.");
    }

    // testRoomToString()
    if (testRoomToString() == false) {
      System.out.println("testRoomToString() failed.");
    } else {
      System.out.println("testRoomToString() passed.");
    }

  }

  // TESTERS

  /**
   * Method returns true if test passes and false otherwise
   * 
   * @return boolean true/false
   */
  public static boolean testPerson() {
    int fail = 0;
    Person jake = new Person("jake");
    Person zach = new Person("zach");

    // test 1
    String jakeName = jake.getName();
    String zachName = zach.getName();
    String jakeExpected = "jake";
    String zachExpected = "zach";

    if (jakeName != jakeExpected) {
      System.out.println(
          "ERROR: jakeName is not equal. Expected: " + jakeExpected + ". Actual: " + jakeName);
      fail = 1;
    }
    if (zachName != zachExpected) {
      System.out.println(
          "ERROR: zachName is not equal. Expected: " + zachExpected + ". Actual: " + zachName);
      fail = 1;
    }

    // test 2
    boolean zachExpectedBool = true;
    boolean jakeExpectedBool = false;
    zach.toggleWaiting();
    zach.toggleWaiting();
    jake.toggleWaiting();
    boolean zachWaiting = zach.isWaiting();
    boolean jakeWaiting = jake.isWaiting();

    if (zachWaiting != zachExpectedBool) {
      System.out.println("ERROR: zachWaiting is not equal. Expected: " + zachExpectedBool
          + ". Actual: " + zachWaiting);
      fail = 1;
    }
    if (jakeWaiting != jakeExpectedBool) {
      System.out.println("ERROR: jakeWaiting is not equal. Expected: " + jakeExpectedBool
          + ". Actual: " + jakeWaiting);
      fail = 1;
    }

    // test 3
    Person jake2 = new Person("jake");
    // jake.toggleWaiting(); (the boolean doesnt matter)
    if (!jake.equals(jake2)) {
      System.out.println("ERROR: Person objects with same name should be equal.");
      fail = 1;
    }
    if (jake.equals(zach)) {
      System.out.println("ERROR: Person objects with different names shouldnt be equal.");
      fail = 1;
    }

    if (fail == 1) {
      return false;
    } else {
      return true;
    }
  }


  /**
   * Method returns true if test passes and false otherwise
   * 
   * @return boolean true/false
   */
  public static boolean testRoomConstructor() {
    int fail = 0;
    Room room3 = new Room("room3", 1);

    try {
      Room room4 = new Room("room3", 24);
      fail = 1;
    } catch (IllegalArgumentException e) {
      System.out.println("testRoomConstructor(): rooms cannot be equal.");
    }

    if (fail == 1) {
      return false;
    } else {
      return true;
    }

  }


  /**
   * Method returns true if test passes and false otherwise
   * 
   * @return boolean true/false
   */
  public static boolean testRoomAccessors() {
    int fail = 0;

    Room room1 = new Room("room1", 99);
    Room room2 = new Room("room2", 2);

    // test 1
    String room1Name = "room1";
    String room2Name = "room2";

    if (room1Name != room1.getName()) {
      System.out
          .println("ERROR: room1 name not equal to expected room1. Actual: " + room1.getName());
      fail = 1;
    }
    if (room2Name != room2.getName()) {
      System.out
          .println("ERROR: room2 name not equal to expected room2. Actual: " + room2.getName());
      fail = 1;
    }

    // test 2 (covid capacity is the same divided by 2)
    int room1Capacity = 99;
    int room2Capacity = 2;

    if (room1Capacity != room1.getCapacity()) {
      System.out.println(
          "ERROR: room1 Capacity not equal to expected room1. Actual: " + room1.getCapacity());
      fail = 1;
    }
    if (room2Capacity != room2.getCapacity()) {
      System.out.println(
          "ERROR: room2 Capacity not equal to expected room2. Actual: " + room2.getCapacity());
      fail = 1;
    }

    if (fail == 1) {
      return false;
    } else {
      return true;
    }
  }


  /**
   * Method returns true if test passes and false otherwise
   * 
   * @return boolean true/false
   */
  public static boolean testRoomCheckIn() {
    int fail = 0;

    Room room10 = new Room("room10", 10);
    Person zach = new Person("zach");
    Person grace = new Person("grace");
    Person jake = new Person("jake");
    Person dog = new Person("dog");
    Person cat = new Person("cat");
    Person bird = new Person("bird");
    Person notCovid = new Person("notCovid");
    room10.checkIn(zach);
    room10.checkIn(grace);
    room10.checkIn(jake);
    room10.checkIn(dog);
    room10.checkIn(cat);
    room10.checkIn(bird);
    room10.checkIn(notCovid);

    if (room10.getOccupancy() != 5) {
      System.out.println("ERROR: capacity is full and should only have 5 or less!");
      fail = 1;
    }

    if (zach.isWaiting() != false) {
      System.out.println("ERROR: isWaiting boolean should be changed upon check in!");
      fail = 1;
    }



    if (fail == 1) {
      return false;
    } else {
      return true;
    }
  }


  /**
   * Method returns true if test passes and false otherwise
   * 
   * @return boolean true/false
   */
  public static boolean testRoomCheckOut() {
    int fail = 0;

    Room room10 = new Room("room11", 10);
    Person zach = new Person("zach");
    Person grace = new Person("grace");
    Person jake = new Person("jake");
    Person dog = new Person("dog");
    Person cat = new Person("cat");
    Person bird = new Person("bird");
    Person notCovid = new Person("notCovid");
    room10.checkIn(zach);
    room10.checkIn(grace);
    room10.checkIn(jake);
    room10.checkIn(dog);
    room10.checkIn(cat);
    room10.checkIn(bird);
    room10.checkIn(notCovid);
    room10.checkOut(zach);

    if (room10.getOccupancy() != 4) {
      System.out.println("ERROR: there should only be 4 occupants!");
      fail = 1;
    }

    if (zach.isWaiting() == false) {
      System.out.println("ERROR: isWaiting boolean should be changed upon check out!");
      fail = 1;
    }

    if (fail == 1) {
      return false;
    } else {
      return true;
    }
  }


  /**
   * Method returns true if test passes and false otherwise
   * 
   * @return boolean true/false
   */
  public static boolean testRoomToString() {
    int fail = 0;
    Room room6 = new Room("room6", 6);
    Person zach = new Person("zach");
    room6.checkIn(zach);
    Person jake = new Person("jake");
    room6.checkIn(jake);
    // System.out.println(room6.toString());
    String expected = "room6\n===\nzach\n-\njake\n-\n-\n-\n";
    if (!room6.toString().equals(expected)) {
      System.out.println("ERROR: toString() method failure. Expected: \n" + expected + "Actual: \n"
          + room6.toString());
      fail = 1;
    }

    if (fail == 1) {
      return false;
    } else {
      return true;
    }
  }

}
