/*
 *Student Name: Kayan Gemignani
 *Student ID: 3093627
 */

public class Healer extends GameCharacter {

    private int healCost;
    private int healAmount;

    /**
    * @param name
    * @param healCost
    * @param healAmount
     */
    public Healer(String name, double gold, int healCost, int healAmount) {
        super(name, 0);
        this.healCost = healCost;
        this.healAmount = healAmount;
    }

    /**
    * @return healCost
     */
    public int getHealCost() {
        return healCost; //############## RETURN ##############
    }

    /**
    * @return healAmount
     */
    public int getHealAmount() {
        return healAmount; //############## RETURN ##############
    }

    @Override
    /**
    * @return stats
     */
    public String getStats() {
        return (
            "Healer Stats:\n" +
            "\tName: " +
            getName() +
            "\n\tGold: " +
            getGold() +
            "\n\tHeal Cost: " +
            healCost +
            "\n\tHealing Amount: " +
            healAmount
        ); //############## RETURN ##############
    }
}
