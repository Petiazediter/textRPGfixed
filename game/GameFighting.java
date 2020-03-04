package game;
import java.util.Scanner;

public class GameFighting {
	public static boolean fighting(PlayerDatas.Player player, Enemies.Enemy enemy) {
		ChatBox.chat("Enemy", enemy.name, "red");
		Scanner input = new Scanner(System.in);
		
		int enemyHealth = enemy.stamina * 10; 
		int playerHealth = player.stamina * 10;
		int choose = 0;
		/*while (enemyHealth > 0 && playerHealth > 0) {
			try{	
				System.out.println("1) Attack");
				System.out.println("2) Use item");    
				choose = input.nextInt();
				if (choose == 1) {
					enemyHealth -= player.basedmg;
					System.out.println("Remaining enemy health:" + enemyHealth);
					playerHealth -= enemy.basedmg;
					System.out.println("Remaining health:" + playerHealth);
					choose = input.nextInt();
				} else if (choose == 2) {
			 	       return false;
				} else {
					return true;
				}
			} catch (Exception e){
			}
		}*/
		
		boolean battle = doBattle(player,enemy);
		System.out.println("Battle ended");
		return false;
	}
	
	public static boolean doBattle(PlayerDatas.Player player, Enemies.Enemy enemy){
		ChatBox.clearScreen();
		boolean result = false;
		Scanner input = new Scanner(System.in);
		try{
			ChatBox.type("1) Attack\n2) Use item");
			int choose = input.nextInt();
			if (choose == 1) {
				System.out.println(Integer.toString(enemy.stamina));
				int attack = player.basedmg;
				enemy.stamina -= attack;
				player.stamina -= enemy.basedmg;
			} else if (choose == 2) {
				ChatBox.type("1) Health Potion");
				int potionChoice = input.nextInt();
				if (potionChoice == 1) {
					boolean hasItem = Inventory.hasItem(2, 1);
					if (hasItem) {
						Inventory.takeItem(2, 1);
						ChatBox.chat("Inventory", "You used a Health Potion.", "green");
						player.stamina += 10;
					} else {
						ChatBox.chat("Inventory", "You don't have any Health Potions left.", "red");
					}
				}
			}
			if (enemy.stamina > 0 && player.stamina >0){
				result = doBattle(player,enemy);
			} else {
				result = true;
			}
		} catch (Exception e){
			result = doBattle(player,enemy);
		}
		return result;
	}
}
