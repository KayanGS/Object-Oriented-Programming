public class ResidentialBuilding extends Building{

    // variables
    private int buildingNumber;

    /**
     * @param buildingNumber
     * @param address
     * Constructor
     */
    public ResidentialBuilding(int buildingNumber, Address address) {
        super(address);
        this.buildingNumber = buildingNumber;
    }

    /**
     * @return building number
     */
    public int getBuildingNumber() {
        return buildingNumber; // ############## RETURN ################
    }

    /**
     * @param buildingNumber set building number
     */
    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
    
}
