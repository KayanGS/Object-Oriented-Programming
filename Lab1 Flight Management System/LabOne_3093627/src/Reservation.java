/*
 * Student Name: Kayan Gemignani
 * Student Number: 3093627
 */

public class Reservation {

  private Flight flight;
  private Passenger passenger;
  private String seatNumber;

  //First Constructor for reservations without a seat number
  public Reservation(Flight flight, Passenger passenger) {
    this.flight = flight;
    this.passenger = passenger;
    this.seatNumber = null;
  }

  //Second Constructor for reservations with a seat number
  public Reservation(Flight flight, Passenger passenger, String seatNumber) {
    this.flight = flight;
    this.passenger = passenger;
    this.seatNumber = seatNumber;
    //Remove the seat number from the available seats and add it to the booked seats
    flight.bookSeat(seatNumber);
  }

  // Getters
  public Flight getFlight() {
    return flight; // #################### RETURN ####################
  }

  public Passenger getPassenger() {
    return passenger; // #################### RETURN ####################
  }

  public String getSeatNumber() {
    return seatNumber; // #################### RETURN ####################
  }

  public void assignSeat(String seatNumber) {
    if (flight.getAvailableSeats().contains(seatNumber)) {
      this.seatNumber = seatNumber;
    } else {
      System.out.println(
        "Warning: Seat " + seatNumber + " is not available for this flight."
      );
    }
  }
}
