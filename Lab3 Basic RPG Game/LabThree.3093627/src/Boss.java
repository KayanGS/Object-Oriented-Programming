import java.util.Random;

public class Boss extends Enemy {

    private int bossHealth;
    private boolean defeated;
    private String bossPower;
    private static final String[] BOSS_POWERS = {
                                                "Fireball Attack",
                                                "Thunder Strike",
                                                "Ice Beam",
                                                "Earthquake",
                                                "Tornado",
    };

    /**
     * @param name
     * @param atk
     * @param exp
     * @param bossHealth
     */
    public Boss(String name, int atk, int exp, int bossHealth) {
        super(name, atk, exp);
        this.bossHealth = bossHealth;
        this.defeated = false;
        //boss power will be randomly selected from BOSS_POWERS
        Random random = new Random();
        int randomIndex = random.nextInt(BOSS_POWERS.length);
        bossPower = BOSS_POWERS[randomIndex];
    }

    /**
     * @return bossHealth
     */
    public int getBossHealth() {
        return bossHealth; //############## RETURN ##############
    }

    /**
     * @param bossHealth
     */
    public void setBossHealth(int bossHealth) {
        this.bossHealth = bossHealth;
    }

    /**
     * @return defeated
     */
    public boolean isDefeated() {
        return defeated; //############## RETURN ##############
    }

    /**
     * @param defeated
     */
    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    /**
     * @return bossPower
     */
    public String getBossPower() {
        return bossPower; //############## RETURN ##############
    }

    /**
     * @param bossPower
     */
    public void useBossPower(Player player) {
        //boss power will be randomly selected from BOSS_POWERS
        if (bossPower.equals("Fireball Attack")) {
        int damage = 20;
        player.takeDamage(damage);
        System.out.println(
            "The boss used Fireball Attack! You took " + damage + " damage."
        );
        
        } else if (bossPower.equals("Thunder Strike")) {
            int damage = 30;
            player.takeDamage(damage);
            System.out.println(
                "The boss used Thunder Strike! You took " + damage + " damage."
            );
        
        } else if (bossPower.equals("Ice Beam")) {
            int damage = 25;
            player.takeDamage(damage);
            System.out.println(
                    "The boss used Ice Beam! You took " + damage + " damage."
            );

        } else if (bossPower.equals("Earthquake")) {
            int damage = 35;
            player.takeDamage(damage);
            System.out.println(
                    "The boss used Earthquake! You took " + damage + " damage."
            );

        } else if (bossPower.equals("Tornado")) {
            int damage = 40;
            player.takeDamage(damage);
            System.out.println(
                    "The boss used Tornado! You took " + damage + " damage."
            );
        }
    }
}

