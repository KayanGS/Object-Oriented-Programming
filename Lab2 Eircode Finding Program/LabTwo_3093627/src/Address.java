public class Address extends Location {

    // variables
    private String eircode, streetName, cityOrTownName;

    /**
     * @param latitude
     * @param longitude
     * @param eircode
     * @param streetName
     * @param cityOrTownName
     * Constructor
     */
    public Address(
        double latitude,
        double longitude,
        String eircode,
        String streetName,
        String cityOrTownName) 
        {
        super(latitude, longitude);
        this.eircode = eircode;
        this.streetName = streetName;
        this.cityOrTownName = cityOrTownName;
    }

    /**
     * @return eircode
     */
    public String getEircode() {
        return eircode; // ############## RETURN ################
    }

    /**
     * @return city or town name
     */
    public String getCityOrTownName() {
        return cityOrTownName; // ############## RETURN ################
    }

    /**
     * @return street name
     */
    public String getStreetName() {
        return streetName; // ############## RETURN ################
    }

    /**
     * @param eircode set eircode
     */
    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    /**
     * @param streetName set street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @param cityOrTownName set city or town name
     */
    public void setCityOrTownName(String cityOrTownName) {
        this.cityOrTownName = cityOrTownName;
    }

    /**
     * @return full address
     */
    public String getFullAddress() {
        return eircode + ", " + streetName + ", " + cityOrTownName; // ############## RETURN ################
    }
}
