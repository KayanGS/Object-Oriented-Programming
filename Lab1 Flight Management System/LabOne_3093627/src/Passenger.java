/*
 * Student Name: Kayan Gemignani
 * Student Number: 3093627
 */

public class Passenger {

  private String passengerName, passportID, dateofBirth;

  public Passenger(
    String passengerName,
    String passportID,
    String dateofBirth
  ) {
    this.passengerName = passengerName;
    this.passportID = passportID;
    this.dateofBirth = dateofBirth;
  }

  // Getters
  public String getPassengerName() {
    return passengerName; // #################### RETURN ####################
  }

  public String getPassportID() {
    return passportID; // #################### RETURN ####################
  }

  public String getDateofBirth() {
    return dateofBirth; // #################### RETURN ####################
  }

  // Setters
  public void setPassengerName(String passengerName) {
    this.passengerName = passengerName;
  }

  public void setPassportID(String passportID) {
    this.passportID = passportID;
  }

  public void setDateofBirth(String dateofBirth) {
    this.dateofBirth = dateofBirth;
  }
}
