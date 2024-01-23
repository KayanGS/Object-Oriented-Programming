public class Location {

    // variables
    private Double latitude, longitude;

    /**
     * @param latitude
     * @param longitude
     * Constructor
     */
    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @return latitude
     */
    public Double getLatitude() {
        return latitude; // ############## RETURN ################
    }

    /**
     * @return longitude
     */
    public Double getLongitude() {
        return longitude; // ############## RETURN ################
    }

    /**
     * @param latitude set latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @param longitude set longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
