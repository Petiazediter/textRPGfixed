package game;
import java.util.Scanner;

public class GameFighting {
	public static boolean fighting(PlayerDatas.Player player, Enemies.Enemy enemy) {
		System.out.println("1) Attack");
		System.out.println("2) Use item");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		int enemyHealth = enemy.stamina * 10; 
		int playerHealth = player.stamina * 10;
		while (enemyHealth > 0 && playerHealth > 0) {	    	
			if (choose == 1) {
				enemyHealth -= player.basedmg;
				System.out.println("Remaining enemy health:" + enemyHealth);
				playerHealth -= enemy.basedmg;
				System.out.println("Remaining health:" + playerHealth);
				System.out.println("1) Attack");
				System.out.println("2) Use item");
				choose = input.nextInt();
			} else if (choose == 2) {
		 	       return false;
			} else {
				return true;
			}
		}
		System.out.println("Battle ended");
		return false;
	}
}
