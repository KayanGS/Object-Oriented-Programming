/*
 * Student Name: Kayan Gemignani
 * Student Number: 3093627
 */

import java.util.ArrayList;
import java.util.List;

public class Flight {

  private int flightNumber;
  private String flightOrigin, flightDestination, flightDate;
  private List<String> availableSeats, bookedSeats;

  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_GREEN = "\u001B[32m";

  public Flight(
    int flightNumber,
    String flightOrigin,
    String flightDestination,
    String flightdate
  ) {
    this.flightNumber = flightNumber;
    this.flightOrigin = flightOrigin;
    this.flightDestination = flightDestination;
    this.flightDate = flightdate;
    // ArrayList to store the available seats
    this.availableSeats = new ArrayList<String>();
    // ArrayList to store the booked seats
    this.bookedSeats = new ArrayList<>();
    // Method to initialize the seats
    initializeSeats();
  }

  private void initializeSeats() {
    // Loop between 1 and 10 to add the seats to the availableSeats ArrayList
    for (int seatNumber = 1; seatNumber <= 10; seatNumber++) {
      availableSeats.add("Seat" + seatNumber);
    }
  }

  public boolean bookSeat(String seat) {
    boolean seatBooked = false;
    if (availableSeats.contains(seat)) {
      // Will remove the seat from the availableSeats ArrayList and add it to the
      // bookedSeats ArrayList
      availableSeats.remove(seat);
      bookedSeats.add(seat);
      seatBooked = true;
    }
    return seatBooked; // #################### RETURN ####################
  }

  // Getters
  public int getFlightNumber() {
    return flightNumber; // #################### RETURN ####################
  }

  public String getFlightOrigin() {
    return flightOrigin; // #################### RETURN ####################
  }

  public String getFlightDestination() {
    return flightDestination; // ################### RETURN ###################
  }

  public String getFlightDate() {
    return flightDate;  // #################### RETURN ####################
  }

  public List<String> getAvailableSeats() {
    return availableSeats;  // #################### RETURN ####################
  }

  public List<String> getBookedSeats() {
    return bookedSeats; // #################### RETURN ####################
  }

  // Setters
  public void setFlightNumber(int flightNumber) {
    this.flightNumber = flightNumber;
  }

  public void setFlightOrigin(String flightOrigin) {
    this.flightOrigin = flightOrigin;
  }

  public void setFlightDestination(String flightDestination) {
    this.flightDestination = flightDestination;
  }

  public void setFlightDate(String flightDate) {
    this.flightDate = flightDate;
  }

  public void setAvailableSeats(List<String> availableSeats) {
    this.availableSeats = availableSeats;
  }

  public String toString() {
    return (
      ANSI_YELLOW +
      "Flight Details:\n" +
      "Flight Number: " +
      ANSI_GREEN +
      flightNumber +
      "\n" +
      ANSI_YELLOW +
      "Flight Origin: " +
      ANSI_GREEN +
      flightOrigin +
      "\n" +
      ANSI_YELLOW +
      "Flight Destination: " +
      ANSI_GREEN +
      flightDestination +
      "\n" +
      ANSI_YELLOW +
      "Flight Date: " +
      ANSI_GREEN +
      flightDate +
      "\n" +
      ANSI_YELLOW +
      "Available Seats: " +
      ANSI_GREEN +
      availableSeats +
      "\n"
    );
  }
}
