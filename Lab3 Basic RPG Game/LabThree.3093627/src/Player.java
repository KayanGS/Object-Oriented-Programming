/*
 *Student Name: Kayan Gemignani
 *Student ID: 3093627
 */

public class Player extends GameCharacter implements Battle {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private int health;
    private int exp;
    private int atk;

    /**
     * @param name
     */    
    public Player(String name) {
        //Player starts with 100 health, 0 gold, 0 exp, and 10 atk 
        super(name, 0);
        health = 100;
        exp = 0;
        //atk will be based on exp level
        atk = 10 + (exp / 5);
    }

    /**
     * @return health
     */    
    public int getHealth() {
        return health; //############## RETURN ##############
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
     * @param damage
     */
    public void takeDamage(int damage) {
        //updates player health after damage
        health -= damage;
    }

    @Override
    /**
     * @param amount
     */
    public void increaseExp(int amount) {
        //updates player exp and atk after battle
        exp += amount;
        //updates player atk based on exp level
        atk = 10 + (exp / 5);
    }

    @Override
    /**
     * @param amount
     */
    public void heal(int amount) {
        //updates player health after healing
        health += amount;
        //health cannot exceed 100
        if (health > 100) {
            health = 100;
        }
    }

    @Override
    /**
     * @param gold
     */
    public void addGold(double gold) {
        //updates player gold after battle
        setGold(getGold() + gold);
    }

    @Override
    /**
     * @param gold
     */
    public void loseGold(double gold) {
        //updates player gold after healing
        setGold(getGold() - gold);
    }

    @Override
    /**
     * @return stats
     */
    public String getStats() {
        return (
            "Name: " +
            ANSI_BLUE +
            getName() +
            ANSI_YELLOW +
            "\nStats:  Gold " +
            ANSI_BLUE +
            getGold() +
            ANSI_YELLOW +
            "\n\tHealth:" +
            ANSI_BLUE +
            health +
            ANSI_YELLOW +
            "\n\tAtk:" +
            ANSI_BLUE +
            atk +
            ANSI_YELLOW +
            "\n\tExp:" +
            ANSI_BLUE +
            exp
        ); //############## RETURN ##############
    }
}
