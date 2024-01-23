/* 
*Student Name: Kayan Gemignani
*Student ID: 3093627
*/ 

public interface Battle {
	//return exp
	int getExp();
	//return atk
	int getAtk();
	//take attack away from health
	void takeDamage(int attack);
	//add the amount to exp
	void increaseExp(int amount);
	//add the amount to health
	void heal(int amount);
	//add the amount to gold
	void addGold(double gold);
	//remove the amount to health
	void loseGold(double gold);
}
