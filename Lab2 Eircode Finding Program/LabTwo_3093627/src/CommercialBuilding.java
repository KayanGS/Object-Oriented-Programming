public class CommercialBuilding extends Building {

	// variables
	private String commercialBuildingName, commercialBuildingDescription;
	private String OpeningHours, websiteURL;

	/**
	 * @param address
	 * @param commercialBuildingName
	 * @param commercialBuildingDescription
	 * @param OpeningHours
	 * @param websiteURL
	 * constructor 1 with all parameters
	 */
	public CommercialBuilding(
		Address address,
		String commercialBuildingName,
		String commercialBuildingDescription,
		String OpeningHours,
		String websiteURL) 
		{
		super(address);
		this.commercialBuildingName = commercialBuildingName;
		this.commercialBuildingDescription = commercialBuildingDescription;
		this.OpeningHours = OpeningHours;
		this.websiteURL = websiteURL;
	}

	/**
	 * @param address
	 * @param commercialBuildingName
	 * constructor 2 with description, opening hours and website url set to null
	 */
	public CommercialBuilding(Address address, String commercialBuildingName) {
		super(address);
		this.commercialBuildingName = commercialBuildingName;
		this.commercialBuildingDescription = null;
		this.OpeningHours = null;
		this.websiteURL = null;
	}

	/**
	 * @return commercial building name
	 */
	public String getCommercialBuildingName() {
		return commercialBuildingName; // ############## RETURN ################
	}

	/**
	 * @return commercial building description
	 */
	public String getCommercialBuildingDescription() {
		return commercialBuildingDescription; // ########## RETURN ############
	}

	 /**
	  * @return opening hours
	  */
	public String getOpeningHours() {
		return OpeningHours; // ############## RETURN ################
	}
	
	/**
	 * @return website url
	 */
	public String getWebsiteURL() {
		return websiteURL; // ############## RETURN ################
	}

	/**
	 * @param commercialBuildingName
	 */
	public void setCommercialBuildingName(String commercialBuildingName) {
		this.commercialBuildingName = commercialBuildingName;
	}

	/**
	 * @param commercialBuildingDescription
	 */
	public void setCommercialBuildingDescription(
			String commercialBuildingDescription) {
		this.commercialBuildingDescription = commercialBuildingDescription;
	}

	/**
	 * @param OpeningHours
	 */
	public void setOpeningHours(String OpeningHours) {
		this.OpeningHours = OpeningHours;
	}

	/**
	 * @param websiteURL
	 */
	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
	}

	/**
	 * @return all info
	 */
	public String getInfo() {
		return ("Commercial Building Name: " +
			commercialBuildingName +
			"\nCommercial Building Description: " +
			commercialBuildingDescription +
			"\nOpening Hours: " +
			OpeningHours +
			"\nWebsite URL: " +
			websiteURL);
	}
}
