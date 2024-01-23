/*
 *Student Name: Kayan Gemignani
 *Student ID: 3093627
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {

	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	static final int MAX_GOLD = 100;

  	public static void main(String args[]) {
    	
		Scanner scanner = new Scanner(System.in);
    	System.out.println(ANSI_YELLOW + 
							"Welcome, Enter the players name" 
							+ ANSI_RESET);

   		String name = scanner.nextLine();
    	// Create a new player with the name entered by the user
		Player player = new Player(name);

    	System.out.println(ANSI_YELLOW + 
							"Try to get " + 
							MAX_GOLD + 
							" gold " + 
							player.getName());

   	 	// list of all characters a player can encounter
    	ArrayList<GameCharacter> encounters = new ArrayList<GameCharacter>();

    	// Create instances of enemies
    	Enemy enemy1 = new Enemy("Enemy1", 20, 10);
    	Enemy enemy2 = new Enemy("Enemy2", 5, 15);
    	// Add enemies to encounters list
    	encounters.add(enemy1);
    	encounters.add(enemy2);

    	// Create instances of bosses
    	Boss boss1 = new Boss("Boss1", 40, 50, 100);
    	Boss boss2 = new Boss("Boss2", 50, 60, 80);
    	// Add bosses to encounters list
    	encounters.add(boss1);
    	encounters.add(boss2);

    	// Create healer 
		Healer healer1 = new Healer("Healer", 50, 20, 30);
    	// Add healer to encounters list
		encounters.add(healer1);

    	Collections.shuffle(encounters);
    	
		while (player.getHealth() > 0 || player.getGold() < MAX_GOLD) {
      		
			for (GameCharacter character : encounters) {
        		
				if (player.getHealth() <= 0) {
          			break; // Exit if the player's health is zero or less
        		}

        		System.out.println(player.getStats());

        		System.out.println(ANSI_YELLOW + 
									"You have encountered " +
									ANSI_BLUE + 
									character.getName());

				// Check if the character is an enemy and not a boss
        		if (character instanceof Enemy 
									&& !(character instanceof Boss)) {
					
					// Cast the character to an enemy
					Enemy enemy = (Enemy) character;
          			System.out.println(ANSI_YELLOW + 
										"Enemy Attack: " + 
										ANSI_BLUE +
										enemy.getAtk());

          			System.out.println(ANSI_YELLOW +	
										"Do you want to battle this enemy? " + 
										"(yes/no)" +
										ANSI_RESET
										);
    	
					String choice = scanner.nextLine().toLowerCase();
					
					// Player chooses to battle the enemy
          			if (choice.equals("yes")) {
            			
						// Player battles the enemy
            			int playerAttack = player.getAtk();
            			int enemyAttack = enemy.getAtk();

            			// Compare attack powers
						//If player attack is greater than enemy attack
            			if (playerAttack > enemyAttack) {
              				// Player wins the battle
              				System.out.println(ANSI_GREEN + 
												"You defeated the enemy!");

		        	  		// Award experience and gold to the player
              				int experienceGained = enemy.getExp();
              				double goldGained = enemy.getGold();

              				player.increaseExp(experienceGained);
              				player.addGold(goldGained);

              				System.out.println(
								ANSI_GREEN +
                				"Gained " +
								ANSI_BLUE +	
                				experienceGained +
                				ANSI_GREEN +
								" experience and " +
                				ANSI_BLUE +
								goldGained +
                				ANSI_GREEN +
								" gold."
              				);

            			} else if (playerAttack < enemyAttack) {

              				// Enemy wins the battle
              				System.out.println(ANSI_RED +
												"You were defeated by the " + 
												"enemy!");

              				// Reduce player's health and gold
							// Damage taken equals the enemy's attack
              				int damageTaken = enemyAttack; 
              				double goldLost = 5; 

              				player.takeDamage(damageTaken);
              				player.loseGold(goldLost);

              				System.out.println(
								ANSI_RED +
                				"You lost " + 
								ANSI_BLUE +
								damageTaken + 
								ANSI_RED +
								" health and " + 
								ANSI_BLUE +		
								goldLost + 
								ANSI_RED +
								" gold."
              				);
            			}
          			}
        		}
				
				// Check if the character is a boss
				if (character instanceof Boss) {
          			// Cast the character to a boss
					Boss boss = (Boss) character;
          			
					// Check if the boss was already defeated
					if (!boss.isDefeated()) {
            		System.out.println(ANSI_YELLOW + 
										"Boss Health: " + 
										ANSI_BLUE +
										boss.getBossHealth());

            		System.out.println(ANSI_YELLOW + 
										"Boss Attack: " + 
										ANSI_BLUE +
										boss.getAtk());

            		System.out.println(ANSI_YELLOW + 
										"Boss Power: " + 
										ANSI_BLUE +
										boss.getBossPower());

            		System.out.println( ANSI_YELLOW + 
										"Do you want to battle this boss? " + 
										"(yes/no)" +
										ANSI_RESET
										);

            		String choice = scanner.nextLine().toLowerCase();

						if (choice.equals("yes")) {
							// Player chooses to battle the boss
							// Battle continues until either the player or the 
							// boss runs out of health
							while (player.getHealth() > 0 
									&& boss.getBossHealth() > 0) {
									
								// Player's turn
								int playerAttack = player.getAtk();
								// Reduce boss's health by the player's attack
								boss.setBossHealth(boss.getBossHealth() - 
													playerAttack);

								System.out.println(ANSI_YELLOW +
												"You attacked the boss for " + 
												ANSI_BLUE +
												playerAttack + 
												ANSI_YELLOW +
												" damage."
								);

								System.out.println(ANSI_YELLOW +
													"Boss Health: " + 
													ANSI_BLUE +
													boss.getBossHealth());

								if (boss.getBossHealth() <= 0) {
									System.out.println(ANSI_GREEN +
													"You defeated the boss!");
									
									// Award experience and gold to the player
									int experienceGained = boss.getExp();
									player.increaseExp(experienceGained);
									player.addGold(100);
									boss.setDefeated(true);
									break;
								// If boss is alive, boss attacks the player
								} else {
									// Boss's turn
									int bossAttack = boss.getAtk();
									player.takeDamage(bossAttack);
									System.out.println(ANSI_YELLOW +
										"The boss attacked you for " + 
										ANSI_BLUE +
										bossAttack +
										ANSI_YELLOW + 
										" damage."
									);

									// Boss uses their special power after the 
									// player's turn
									boss.useBossPower(player);

									// If player dies, exit the loop
									if (player.getHealth() <= 0 ) {
									
										System.out.println(ANSI_RED +	
											"You were defeated by the boss!");
									
										System.out.println(
											ANSI_RED +
											"You got " +
											ANSI_BLUE +
											player.getExp() +
											ANSI_RED +
											" experience and " +
											ANSI_BLUE +
											player.getGold() +
											ANSI_RED +
											" gold."
										);
									}
								}
							}
						}
          			}
					
				//Player encounters a healer	
				} else if (character instanceof Healer) {
          
					Healer healer = (Healer) character;

          			System.out.println(ANSI_GREEN +
            				"Do you want to get healing services from this " + 
							"healer? (yes/no)" +
							ANSI_RESET	
          			);
          
					String choice = scanner.nextLine().toLowerCase();
					
					// Player chooses to get healing services
          			if (choice.equals("yes")) {
						// Check the cost of healing services 
            			int cost = healer.getHealCost();
						
						// If the player has enough gold
            			if (player.getGold() >= cost) {
              				// Player receives healing services
							player.heal(healer.getHealAmount());
							// Player loses gold
              				player.loseGold(cost);

              				System.out.println(
								ANSI_GREEN +
                				"You received healing services and gained " +
                				ANSI_BLUE +
								healer.getHealAmount() +
                				ANSI_GREEN +
								" health."
              				);
            			} else {

              				System.out.println(
								ANSI_RED +
                				"You don't have enough gold to get healing " +
								"services."
              				);
            			}
          			}
        		}
				// When player collects 100 gold, they win the game 
				if (player.getGold() >= MAX_GOLD) {
					System.out.println(ANSI_GREEN +
            			"You've collected " +
						ANSI_BLUE + 
						MAX_GOLD +
						ANSI_GREEN + 
						" gold. You win!"
          			);
        		}
      		}
    	}

    	scanner.close();
    
		if (player.getHealth() <= 0) {
      		
			System.out.println(
				ANSI_RED +
				"You ran out of health. Game over!");
      		
			System.out.println(
				ANSI_RED +
        		"You got " +
        		ANSI_BLUE +
				player.getExp() +
        		ANSI_RED +
				" experience and " +
        		ANSI_BLUE +
				player.getGold() +
        		ANSI_RED +
				" gold."
      		);
    	}
 	}
}
