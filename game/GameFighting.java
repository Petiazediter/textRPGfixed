package game;
import java.util.Scanner;

public class GameFighting {
	public static boolean fighting(PlayerDatas.Player player, Enemies.Enemy enemy) {
		int enemyHealth = enemy.stamina * 10; 
		int playerHealth = player.stamina * 5;
		System.out.println(enemy.name);
		System.out.println("Health: " +enemyHealth);
		System.out.println("Damage: " +enemy.basedmg);
		System.out.println("1) Attack");
		System.out.println("2) Use item");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		while (enemyHealth > 0 && playerHealth > 0) {	    	
			if (choose == 1) {
				enemyHealth -= player.basedmg;
				System.out.print("Remaining enemy health:");
				for (int i = 0; i < enemyHealth / 10; i++) {
				System.out.print(" ❤️ ");
			}
				playerHealth -= enemy.basedmg;
				System.out.print("\nRemaining health:");
				for (int i = 0; i < playerHealth / 10; i++) {
				System.out.print(" ❤️ ");
			}
				if (enemyHealth > 0 && playerHealth > 0) {
					System.out.println("\n1) Attack");
					System.out.println("2) Use item");				
					choose = input.nextInt();
				}	
			} else if (choose == 2) {
		 	       return false;
			} else {
				return true;
			}
		}
		System.out.println("\nBattle ended");
		return false;
	}
}
