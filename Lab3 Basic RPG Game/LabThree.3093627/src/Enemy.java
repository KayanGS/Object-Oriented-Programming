/*
 *Student Name: Kayan Gemignani
 *Student ID: 3093627
 */

public class Enemy extends GameCharacter implements Battle {

    private int atk;
    private int exp;

    /**
    * @param name
    * @param atk
    * @param exp
    */
    public Enemy(String name, int atk, int exp) {
        super(name, 10);
        this.atk = atk;
        this.exp = exp;
    }

    @Override
    /**
    * @return atk
    */
    public int getAtk() {
        return atk; //############## RETURN ##############
    }

    @Override
    /**
     * @return exp
     */
    public int getExp() {
        return exp; //############## RETURN ##############
    }

    @Override
    /**
     * @param attack
     */
    public void takeDamage(int attack) {}

    @Override
    /**
     * @param amount
     */
    public void increaseExp(int amount) {
        exp += amount;
    }

    @Override
    /**
     * @param amount
     */
    public void heal(int amount) {}

    @Override
    /**
     * @param gold
     */
    public void addGold(double gold) {}

    @Override
    /**
     * @param gold
     */
    public void loseGold(double gold) {}

    @Override
    public String getStats() {
        return (  
            "Enemy Stats:\n" +
            "\tName: " +
            getName() +
            "\n\tGold: " +
            getGold() +
            "\n\tAtk: " +
            atk +
            "\n\tExp: " +
            exp
        ); //############## RETURN ##############
    }
}
