import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {

    // ANSI color codes for the console output
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    // List of buildings
    private static List<Building> buildingsList = new ArrayList<>();

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create Address objects and Building objects
        Address address1 = new Address(
            53.354734,
            -6.442182,
            "K78E3F9",
            "116, Esker Park",
            "Lucan");
        Building residential1 = new ResidentialBuilding(1, address1);

        Address address2 = new Address(
            53.285004,
            -6.349249,
            "D24KW58",
            "26, Homelawn Drive",
            "Tallaght");
        Building residential2 = new ResidentialBuilding(2, address2);

        Address address3 = new Address(
            53.372889,
            -6.360927,
            "D15W9DH",
            "17, Hawthorn Lawn",
            "Dublin");
        Building residential3 = new ResidentialBuilding(3, address3);

        Address address4 = new Address(
            53.349804,
            -6.260310,
            "D01X4X0",
            "O'Connell Street Upper",
            "Dublin");
        CommercialBuilding commercial1 = new CommercialBuilding(
            address4,
            "The Spire");
        commercial1.setCommercialBuildingDescription(
            ANSI_YELLOW +
            "The Spire of Dublin, alternatively titled the Monument of Light" +
            "is a large, stainless steel, pin-like monument 120 metres in " +
            "height, located on the site of the former Nelson's Pillar on" +
            "O'Connell Street in Dublin, Ireland.");
        commercial1.setOpeningHours(ANSI_BLUE + "24/7");
        commercial1.setWebsiteURL(ANSI_BLUE + "https://www.thespire.ie/");

        Address address5 = new Address(
            53.348779,
            -6.260087,
            "D01T1W6",
            "Spencer Dock",
            "North Wall");
        CommercialBuilding commercial2 = new CommercialBuilding(
            address5,
            "The Convention Centre Dublin");
        commercial2.setCommercialBuildingDescription(
            ANSI_BLUE +
            "The Convention Centre Dublin (Irish: Ionad Comhdhála Bhaile " +
            "Átha Cliath) is a convention centre in the Dublin Docklands, " +
            "Ireland. The Convention centre overlooks the River Liffey at " +
            "Spencer Dock. It was designed by Irish-born American architect " +
            "Kevin Roche.");
        commercial2.setOpeningHours(
            ANSI_BLUE + 
            "08:30 - 17:30 Monday to Friday");
        commercial2.setWebsiteURL(ANSI_BLUE + "https://www.theccd.ie/");

        Address address6 = new Address(
            53.335860,
            -6.227950,
            "D04K5F9",
            "Lansdowne Road",
            "Ballsbridge");

        CommercialBuilding commercial3 = new CommercialBuilding(
            address6,
            "The Aviva Stadium");

        commercial3.setCommercialBuildingDescription(
            ANSI_BLUE +
            "The Aviva Stadium is a sports stadium located in Dublin, " +
            "Ireland, with a capacity for 51,700 spectators (all seated). It " +
            "is built on the site of the former Lansdowne Road stadium, " +
            "which was demolished in 2007, and replacing it as home to its " +
            "chief tenants: the Irish rugby union team and the Republic of " +
            "Ireland football team. The decision to redevelop the stadium " +
            "came after plans for both Stadium Ireland and Eircom Park fell " +
            "through. Aviva Group Ireland signed a 10-year deal for the " +
            "naming rights in 2009.");
        commercial3.setOpeningHours(ANSI_BLUE + "10:30 - 16:00 Monday to Sunday");
        commercial3.setWebsiteURL(ANSI_BLUE + "https://www.avivastadium.ie/");

        buildingsList.add(residential1);
        buildingsList.add(residential2);
        buildingsList.add(residential3);
        buildingsList.add(commercial1);
        buildingsList.add(commercial2);
        buildingsList.add(commercial3);

        // boolean for the switch menu
        boolean continueInTheMenu = true;
        Scanner scanner = new Scanner(System.in);

        while (continueInTheMenu) {
            // variables
            int choice = 0;
            boolean validInput = false;

            do {
                // Display options
                System.out.println(ANSI_YELLOW + "Choose an option:");

                System.out.println(
                    ANSI_YELLOW + "1. Find a Building by it's Eircode: ");

                System.out.println(
                    ANSI_YELLOW + "2. Get a Building Eircode by coordinates: ");

                System.out.println(
                    ANSI_YELLOW + "3. Get distance between two buildings: ");

                System.out.println(ANSI_YELLOW + "4. Quit");

                System.out.println(
                    ANSI_YELLOW + 
                    "Enter the option number: " +
                    ANSI_GREEN);

                // Loop while the input is not a valid integer
                try {
                    choice = scanner.nextInt();
                    validInput = true;
                } catch (java.util.InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println(
                        "Invalid input. Please enter a numeric option.");
                }
            } while (!validInput);

            switch (choice) {
                // case number 1 to find a building by it's Eircode
                // Use K78E3F9 to test a residential building or D01T1W6 to test 
                // a commercial
                case 1:
                    //check if the input eircode is correct
                    boolean validEircode = false;

                    while (!validEircode) {
                        System.out.println(
                            ANSI_YELLOW + 
                            "\nEnter the Eircode: " +
                            ANSI_GREEN);

                        // building
                        String eircode = scanner.next();
                        // Find a building with the provided Eircode
                        Building foundBuilding = findBuildingByEircode(eircode);

                        if (foundBuilding != null) {
                            // if the building is a residential building
                            if (foundBuilding instanceof ResidentialBuilding) {
                                // cast the building to a residential building
                                ResidentialBuilding foundResidential = 
                                    (ResidentialBuilding) foundBuilding;
                                
                                System.out.println(
                                    ANSI_YELLOW +
                                    "\nLocation: " +
                                    ANSI_BLUE +
                                    foundBuilding
                                    .getAddress().getFullAddress());
                                        
                                System.out.println(
                                    ANSI_YELLOW +
                                    "Building Number: " +
                                    ANSI_BLUE +
                                    foundResidential.getBuildingNumber() +
                                    "\n");
                            }
                            // if the building is a commercial building
                            else if (
                                foundBuilding instanceof CommercialBuilding) {
                                
                                // cast the building to a commercial building
                                CommercialBuilding foundCommercial = 
                                    (CommercialBuilding) foundBuilding;
                               
                                System.out.println(
                                    ANSI_YELLOW +
                                    "\nLocation: " +
                                    ANSI_BLUE +
                                    foundBuilding
                                    .getAddress().getFullAddress());

                                System.out.println(
                                    ANSI_YELLOW +
                                    "Description: " +
                                    ANSI_BLUE +
                                    foundCommercial
                                    .getCommercialBuildingDescription() +
                                    "\n");


                                System.out.println(
                                    ANSI_YELLOW +
                                    "\nOpening Hours: " +
                                    ANSI_BLUE +
                                    foundCommercial.getOpeningHours() +
                                    "\n");

                                System.out.println(
                                    ANSI_YELLOW +
                                    "\nWebsite URL: " +
                                    ANSI_BLUE +
                                    foundCommercial.getWebsiteURL() +
                                    "\n");
                            }

                            // Eircode is valid, exit the loop
                            validEircode = true; 

                        } else {
                            System.out.println(
                                ANSI_RED +
                                "Eircode not found. Please check the Eircode " +
                                "you entered.");
                        }
                    }

                    break; // ################### BREAK ####################

                case 2:

                    // coordinates to test: 53.372889, -6.360927
                    // variables
                    boolean validCoordinates = false;
                    double userLatitude, userLongitude;
                    //loop until valid latitude and longitude coordinates
                    while (!validCoordinates) {
                        // Loop until the user enters a valid latitude
                        while (true) {
                            
                            System.out.print(
                                ANSI_YELLOW + 
                                "\nEnter latitude: " +
                                ANSI_GREEN);

                            // Check if the input is a double
                            if (scanner.hasNextDouble()) {
                                userLatitude = scanner.nextDouble();
                                // Check if the latitude is between -90 and 90
                                if (userLatitude >= -90 && userLatitude <= 90) {
                                    // Valid latitude entered
                                    break; // ############# BREAK #############

                                } else {
                                    System.out.println(
                                        ANSI_RED +
                                        "Invalid latitude. Please enter a " +
                                        "value between -90 and 90.");
                                }

                            } else {
                                System.out.println(
                                    ANSI_RED +
                                    "Invalid input. Please enter a valid " +
                                    "numeric value for latitude.");

                                scanner.next();
                            }
                        }

                        // Loop for longitude
                        while (true) {

                            System.out.print(
                                ANSI_YELLOW + 
                                "Enter longitude: " +
                                ANSI_GREEN);

                            if (scanner.hasNextDouble()) {
                                userLongitude = scanner.nextDouble();

                                if (userLongitude >= -180 
                                    && userLongitude <= 180) {
                                    // Valid longitude entered
                                    break;

                                } else {
                                    System.out.println(
                                        ANSI_RED +
                                        "Invalid longitude. Please enter a " +
                                        "value between -180 and 180.");
                                }

                            } else {
                                System.out.println(
                                    ANSI_RED +
                                    "Invalid input. Please enter a valid " +
                                    "numeric value for longitude." +
                                    ANSI_GREEN);
                                scanner.next();
                            }
                        }

                        // Find a building with the provided coordinates
                        Building foundBuildingByCoordinates = 
                            findBuildingByCoordinates(
                                                    userLatitude,
                                                    userLongitude);

                                                    
                        if (foundBuildingByCoordinates != null) {

                            System.out.println(
                                    ANSI_YELLOW +
                                        "Eircode for the given coordinates: " +
                                        ANSI_BLUE +
                                        foundBuildingByCoordinates
                                        .getAddress().getEircode() +
                                        "\n");
                
                            // Coordinates are valid, exit the loop
                            validCoordinates = true; 

                        } else {
                            System.out.println(
                                ANSI_RED +
                                "No building found with the provided " +
                                "coordinates. Please check the coordinates " +
                                "you entered.");
                        }
                    }

                    break; // ############### BREAK ################

                //case 3 check distance between 2 eircodes  
                // eircodes to test: K78E3F9 and D01T1W6
                case 3:
                    // variables
                    boolean validEircodes = false;
                    double userLatitude1, userLongitude1;
                    double userLatitude2, userLongitude2;
                    //consumes the scanner
                    scanner.nextLine();
                    while (!validEircodes) {
                        // Get the first Eircode
                        System.out.print(
                            ANSI_YELLOW 
                            + "\nEnter the first Eircode: " + 
                            ANSI_GREEN);
                            String inputEircode1 = scanner.nextLine();
                        
                        // Find the address with the provided Eircode calling 
                        // the getAddressByEircode method

                        Address inputAddress1 = 
                                            getAddressByEircode(inputEircode1);

                        // If address is found, get the latitude and longitude
                        if (inputAddress1 != null) {

                            userLatitude1 = inputAddress1.getLatitude();
                            userLongitude1 = inputAddress1.getLongitude();

                        } else {
                            System.out.println(
                                ANSI_RED +
                                "Eircode 1 not found. Please check the " +
                                "Eircode you entered.");
                            // Continue to ask for both Eircodes again
                            continue; 
                        }
                        

                        // Get the second Eircode
                        System.out.print(
                            ANSI_YELLOW + 
                            "Enter the second Eircode: " +
                            ANSI_GREEN);

                        String inputEircode2 = scanner.nextLine();
                        // Find the address with the provided Eircode
                        Address inputAddress2 = 
                                            getAddressByEircode(inputEircode2);

                        // If address is found, get the latitude and longitude
                        if (inputAddress2 != null) {
    
                            userLatitude2 = inputAddress2.getLatitude();
                            userLongitude2 = inputAddress2.getLongitude();

                        } else {
                            System.out.println(
                                ANSI_RED +
                                "Eircode 2 not found. Please check the " +
                                "Eircode you entered.");
                            // Continue to ask for both Eircodes again
                            continue; 
                        }

                        // Calculate the distance between the two locations 
                        // calling the getDistance method
                        double distance = getDistance(
                                                    userLatitude1,
                                                    userLongitude1,
                                                    userLatitude2,
                                                    userLongitude2);

                        DecimalFormat df = 
                                        new DecimalFormat("#####.##");

                        System.out.println(
                            ANSI_YELLOW +
                            "\nDistance between the two locations: " +
                            ANSI_BLUE +
                            df.format(distance) +
                            ANSI_YELLOW +
                            " kilometers\n");
                        // Eircodes are valid, exit the loop
                        validEircodes = true; 
                    }
                break; // ############### BREAK ################
                case 4:
                     // Quit the program
                    continueInTheMenu = false;
                    System.out.println(
                        ANSI_YELLOW +
                        "\nThank you for using the program. Goodbye!");
                    break; // ############### BREAK ################

            }
        }
        //closes scanner
        scanner.close();
    }

    /**
     * @param latitude1
     * @param longitude1
     * @param latitude2
     * @param longitude2
     * @return distance between two locations
     */
    
    private static double getDistance(
            double latitude1,
            double longitude1,
            double latitude2,
            double longitude2) {

        // Radius of the Earth in kilometers
        final int earthRadiusKM = 6371;

        // convert the coordinates to radians
        double latitudeInRadians1 = Math.toRadians(latitude1);
        double longitudeInRadians1 = Math.toRadians(longitude1);
        double latitudeInRadians2 = Math.toRadians(latitude2);
        double longitudeInRadians2 = Math.toRadians(longitude2);

        // Calculate the distance between the two locations
        double latitudeDistance = latitudeInRadians2 - latitudeInRadians1;
        double longitudeDistance = longitudeInRadians2 - longitudeInRadians1;

        // Haversine formula reference:
        // https://www.movable-type.co.uk/scripts/latlong.html
        double halfAngularDistance = Math.sin(latitudeDistance / 2) *
            Math.sin(latitudeDistance / 2) +
            Math.cos(latitudeInRadians1) *
            Math.cos(latitudeInRadians2) *
            Math.sin(longitudeDistance / 2) *
            Math.sin(longitudeDistance / 2);

        double angularDistance = 2 *
                Math.atan2(
                    Math.sqrt(halfAngularDistance),
                    Math.sqrt(1 - halfAngularDistance));

        return earthRadiusKM * angularDistance; // ########## RETURN ###########
    }

    /**
     * @param eircode
     * @return building with the provided Eircode
     *         eircode to test: K78E3F9
     */
    private static Building findBuildingByEircode(String eircode) {
        Building foundBuilding = null;
        // Loop through the buildings list
        for (Building building : buildingsList) {
            // If the building Eircode is equal to the provided Eircode, assign
            // the building to the foundBuilding variable and break the loop
            if (building.getAddress().getEircode().equals(eircode)) {
                foundBuilding = building;
                break; // ############## BREAK ################
            }
        }
        return foundBuilding; // ############## RETURN ################
    }

    /**
     * @param latitude
     * @param longitude
     * @return building with the provided coordinates
     *         coordinates to test: 53.372889, -6.360927
     */
    private static Building findBuildingByCoordinates(
            double latitude,
            double longitude) {
        Building foundBuilding = null;
        // Loop through the buildings list
        for (Building building : buildingsList) {
            // If the building latitude and longitude are equal to the provided
            // assign the building to the foundBuilding variable and break the
            // loop
            if (building.getAddress().getLatitude() == latitude &&
                    building.getAddress().getLongitude() == longitude) {
                foundBuilding = building;
                break; // ############## BREAK ################
            }
        }
        return foundBuilding; // ############## RETURN ################
    }

    /**
     * @param eircode
     * @return address with the provided Eircode
     *         eircodes to test: K78E3F9 and D01T1W6
     */
    private static Address getAddressByEircode(String eircode) {
        Address foundBuilding = null;
        // Loop through the buildings list
        for (Building building : buildingsList) {
            // If the building Eircode is equal to the provided Eircode, return
            // the building address
            if (building.getAddress().getEircode().equals(eircode)) {
                foundBuilding = building.getAddress();
                break; // ############## BREAK ################
            }
        }
        return foundBuilding; // ############## RETURN ################
    }
}
