public class Building {
    
    private Address address;

    /**
     * @param address
     * constructor
     */
    public Building(Address address) {
        this.address = address;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address; // ############## RETURN ################
    }

    /**
     * @param address set the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    


}
