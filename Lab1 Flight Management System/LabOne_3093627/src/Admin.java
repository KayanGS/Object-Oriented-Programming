/*
 * Student Name: Kayan Gemignani
 * Student Number: 3093627
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Admin {

  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void main(String[] args) {
    // Two flights intances
    Flight flight1 = new Flight(1, "London", "Paris", "29/09/2023");
    Flight flight2 = new Flight(2, "Dublin", "Cairo", "05/12/2023");

    // List of passengers and reservations
    List<Passenger> passengersList = new ArrayList<Passenger>();
    List<Reservation> reservationsList = new ArrayList<Reservation>();

    // Five passengers
    Passenger passenger1 = new Passenger(
      "Kayan Gemignani",
      "EZ980399",
      "24/02/1999"
    );
    Passenger passenger2 = new Passenger(
      "Muhanned Ali",
      "AL294502",
      "13/07/1994"
    );
    Passenger passenger3 = new Passenger(
      "Ifeomalorita",
      "SA294502",
      "15/06/1998"
    );
    Passenger passenger4 = new Passenger(
      "Luana Virgina",
      "OP958307",
      "17/09/1996"
    );
    Passenger passenger5 = new Passenger("Ekaterina", "KC838364", "19/11/2000");
    // Extra passengers that were asked
    Passenger passenger6 = new Passenger(
      "Mileide Moraes",
      "NJ280681",
      "19/09/1979"
    );
    Passenger passenger7 = new Passenger("Aitor", "AT372938", "08/03/1997");
    Passenger passenger8 = new Passenger("Nadia", "MG372938", "18/09/2000");

    passengersList.add(passenger1);
    passengersList.add(passenger2);
    passengersList.add(passenger3);
    passengersList.add(passenger4);
    passengersList.add(passenger5);
    // Extra passengers that were asked
    passengersList.add(passenger6);
    passengersList.add(passenger7);
    passengersList.add(passenger8);

    // Reservations
    Reservation reservation1 = new Reservation(flight1, passenger1, "Seat1");
    Reservation reservation2 = new Reservation(flight1, passenger2, "Seat2");
    Reservation reservation3 = new Reservation(flight1, passenger3);
    Reservation reservation4 = new Reservation(flight1, passenger4);
    // Extra reservations that were asked
    Reservation reservation5 = new Reservation(flight2, passenger6, "Seat1");
    Reservation reservation6 = new Reservation(flight2, passenger7, "Seat2");
    Reservation reservation7 = new Reservation(flight2, passenger8, "Seat3");
    Reservation reservation8 = new Reservation(flight2, passenger1);
    Reservation reservation9 = new Reservation(flight2, passenger2);

    reservationsList.add(reservation1);
    reservationsList.add(reservation2);
    reservationsList.add(reservation3);
    reservationsList.add(reservation4);
    reservationsList.add(reservation5);
    reservationsList.add(reservation6);
    reservationsList.add(reservation7);
    reservationsList.add(reservation8);
    reservationsList.add(reservation9);

    boolean continueInTheMenu = true;
    Scanner scanner = new Scanner(System.in);
    //For clarity I create a switch where you can navegate between the options
    while (continueInTheMenu) {
      int choice = 0;
      boolean validInput = false;

      do {
        // Display options 
        System.out.println(ANSI_YELLOW + "Choose an option:");
        System.out.println(ANSI_YELLOW + "1. Print Flight Details");
        System.out.println(ANSI_YELLOW + "2. Make the seat assignment");
        System.out.println(
          ANSI_YELLOW + "3. Print Bookings for each passenger"
        );
        System.out.println(ANSI_YELLOW + "4. Exit");
        System.out.println(ANSI_YELLOW + "Enter the option number: ");

        // Loop while the input is not a valid integer
        try {
          choice = scanner.nextInt();
          validInput = true;
        } catch (java.util.InputMismatchException e) {
          scanner.nextLine(); 
          System.out.println("Invalid input. Please enter a numeric option.");
        }
      } while (!validInput);

      switch (choice) {
        
        case 1:
        // Option 1: Flight Details
        int flightChoice = 0;
        boolean validFlightChoice = false;

        do {
            // Display flight options to the user
            System.out.println("\nChoose a flight:");
            System.out.println("1. Flight 1");
            System.out.println("2. Flight 2");
            System.out.print("Enter the flight number: ");

            // Try to read input as an integer
            try {
                flightChoice = scanner.nextInt();
                validFlightChoice = flightChoice >= 1 && flightChoice <= 2;
            } catch (java.util.InputMismatchException e) {
                scanner.nextLine(); 
                System.out.println("Invalid input. Please enter a numeric option (1 or 2).");
            }
        } while (!validFlightChoice);

        // Perform the action based on the selected flight
        switch (flightChoice) {
            case 1:
                printFlightDetails(flight1, reservationsList);
                break;
            case 2:
                printFlightDetails(flight2, reservationsList);
                break;
        }
        break;
        case 2:
          // Assign seats to reservations that don't have one
          for (Reservation reservation : reservationsList) {
            // If the reservation doesn't have a seat assigned, call the method to assign
            // one
            if (reservation.getSeatNumber() == null) {
              assignSeat(reservation);
            }
          }
          break;
        case 3:
          // Call the method to print bookings for each passenger
          for (Passenger passenger : passengersList) {
            bookings(passenger, reservationsList);
          }
          break;
        case 4:
          continueInTheMenu = false;
        default:
          System.out.println(ANSI_YELLOW + "Invalid option");
      }
      // Close the scanner

    }
    scanner.close();
  }

  /*
   * @param reservation
   * This method assigns a seat to a reservation
   */
  public static void assignSeat(Reservation reservation) {
    Flight flight = reservation.getFlight();
    List<String> availableSeats = flight.getAvailableSeats();

    // Loop until a valid seat is selected
    while (true) {
      System.out.println(
        ANSI_YELLOW +
        "\nAvailable seats for Flight " +
        flight.getFlightNumber() +
        ":"
      );

      // Print available seats
      for (String seat : availableSeats) {
        System.out.print(ANSI_GREEN + seat + "\n");
      }

      Scanner scanner = new Scanner(System.in);
      System.out.print(
        ANSI_YELLOW +
        "Enter the seat number you would like to book for " +
        ANSI_BLUE +
        reservation.getPassenger().getPassengerName() + //Get passenger name
        ": "
      );

      String selectedSeatNumber = scanner.nextLine();

      if (availableSeats.contains(selectedSeatNumber)) {
        // Assign the seat to the reservation and remove it from the list of
        // available seats
        reservation.assignSeat(selectedSeatNumber);
        availableSeats.remove(selectedSeatNumber);
        System.out.println(
          ANSI_GREEN +
          "Seat " +
          selectedSeatNumber +
          " has been booked for " +
          reservation.getPassenger().getPassengerName() + //Get passenger name
          ".\n"
        );
        break;
      } else { //If inputed seat is not available
        System.out.println(
          ANSI_RED +
          "Seat " +
          selectedSeatNumber +
          " is not available for this flight.Please select another seat.\n"
        );
      }
      // Close the scanner if the seats has been assigned
      if (reservation.getSeatNumber() != null) {
        scanner.close();
      }
    }
  }

  /*
   * @param flight
   * @param reservations
   * This method prints the flight details and seat assignment table
   */

  public static void printFlightDetails(
    Flight flight,
    List<Reservation> reservationsList
  ) {
    System.out.println("\n" + flight.toString());

    // Create a table header
    System.out.println(ANSI_YELLOW + "\nSeat Assignment Table:");
    System.out.println("+-----------------+----------------------+");
    System.out.println("|    Seat Number  |   Passenger Name     |");
    System.out.println("+-----------------+----------------------+");

    // Create a set to keep track of assigned seats
    Set<String> assignedSeats = new HashSet<>();

    // Iterate through all reservations and display assigned seats with passenger
    // names
    for (Reservation reservation : reservationsList) {
      //Check if the reservation flight is the same as the flight being printed
      if (reservation.getFlight().equals(flight)) {
        //Declare variables for seat number and passenger name
        String seatNumber = reservation.getSeatNumber();
        String passengerName = reservation.getPassenger().getPassengerName();
        if (seatNumber != null) {
          // Assigned seats with passenger names
          assignedSeats.add(seatNumber);
          System.out.printf(
            ANSI_GREEN + ANSI_YELLOW + "| %20s | %20s |\n",
            ANSI_GREEN + seatNumber,
            passengerName
          );
        }
      }
    }

    // Iterate through all available seat numbers and print unassigned seats
    for (String seatNumber : flight.getAvailableSeats()) {
      if (!assignedSeats.contains(seatNumber)) {
        System.out.printf(
          ANSI_RED + ANSI_YELLOW + "| %20s | %20s |\n",
          ANSI_RED + seatNumber,
          "Unassigned"
        );
      }
    }

    // Close the table
    System.out.println(
      ANSI_YELLOW + "+-----------------+----------------------+"
    );
  }

  /*
   * @param passenger
   * @param reservations
   * This method prints the bookings for a given passenger
   */

  public static void bookings(
    Passenger passenger,
    List<Reservation> reservationsList
  ) {
    System.out.println(
      "Bookings for Passenger: " + ANSI_BLUE + passenger.getPassengerName()
    );
    System.out.println(
      ANSI_YELLOW + "+-----------------+----------------------+"
    );
    System.out.println("|     Flight      |    Assigned Seat     |");
    System.out.println("+-----------------+----------------------+");

    // Iterate through reservations to find bookings for the given passenger
    for (Reservation reservation : reservationsList) {
      Passenger passengerWithReservation = reservation.getPassenger();
      // Check if the reservation passenger is the same as the passenger being printed
      // Using passport ID as a unique identifier
      if (
        passengerWithReservation != null &&
        passengerWithReservation
          .getPassportID()
          .equals(passenger.getPassportID())
      ) {
        Flight flighWithReservations = reservation.getFlight();
        String seatNumber = reservation.getSeatNumber();
        int flightNumber = flighWithReservations.getFlightNumber();
        String flightDetails =
          ANSI_GREEN +
          " (" +
          flighWithReservations.getFlightOrigin() +
          " to " +
          flighWithReservations.getFlightDestination() +
          " on " +
          flighWithReservations.getFlightDate() +
          ")";
        System.out.printf(
          "| %15s | %20s |",
          "Flight " + flightNumber,
          seatNumber
        );
        System.out.println(
          ANSI_YELLOW + "\n+-----------------+----------------------+"
        );
        System.out.printf("| %35s |", "   " + flightDetails + "\t");
        System.out.println(
          ANSI_YELLOW + "\n+-----------------+----------------------+\n"
        );
      }
    }
  }
}
