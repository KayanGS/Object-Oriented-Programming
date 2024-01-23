/* 
*Student Name: Kayan Gemignani
*Student ID: 3093627
*/ 

public abstract class GameCharacter {

	private String name;
	private double gold;


	public GameCharacter(String name, double gold) {
		this.name = name;
		this.gold = gold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGold() {
		return gold;
	}
	public void setGold(double gold) {
		this.gold =  gold;
	}
	public abstract String getStats();

}