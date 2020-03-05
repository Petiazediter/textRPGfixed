package game;
import java.util.Scanner;

public class GameFighting {
	public static boolean fighting(PlayerDatas.Player player, Enemies.Enemy enemy) {
		
		Scanner input = new Scanner(System.in);
		
		int enemyHealth = enemy.stamina * 10; 
		int playerHealth = player.stamina * 10;
		int choose = 0;
		
		boolean battle = doBattle(player,enemy);
		System.out.println("Battle ended");
		if (player.stamina > 0) {
			return true;
		} else {
			return false; 
		}
	}
	
	public static boolean doBattle(PlayerDatas.Player player, Enemies.Enemy enemy){
		Scanner input = new Scanner(System.in);
		System.out.println("Press ENTER to continue!");
		input.nextLine();
		ChatBox.clearScreen();
		boolean result = false;
		
		try{
			ChatBox.chat("Enemy", enemy.name, "red");
			System.out.println(player.name + "'s health: " + Integer.toString(player.stamina));
			System.out.println(enemy.name + "'s health: " + Integer.toString(enemy.stamina));
			System.out.println("1) Attack\n2) Use item");
			int choose = input.nextInt();
			if (choose == 1) {
				

				
				int weaponID = Inventory.getWeapon();
				int attack = player.basedmg;
				if (weaponID > 0){
					attack += Inventory.getWeaponStrength(weaponID);
				}
				
				enemy.stamina -= attack;
				ChatBox.chatFast("Fight", "You dealt " + Integer.toString(attack) + " dmg to " + enemy.name + ".(" + Integer.toString(enemy.stamina + attack) + " -> " + enemy.stamina + ")","green");
				player.stamina -= enemy.basedmg;
				ChatBox.chatFast("Fight", enemy.name +" dealt " + Integer.toString(enemy.basedmg) + " dmg to you. (" + Integer.toString(player.stamina + enemy.basedmg) + " -> " + player.stamina + ")","red");
			} else if (choose == 2) {
				System.out.println("0) List my items\n1) Health Potion");
				int potionChoice = input.nextInt();
				if (potionChoice == 0) {
					Inventory.printItems();
				} else if (potionChoice == 1) {
					boolean hasItem = Inventory.hasItem(2, 1);
					if (hasItem) {
						Inventory.takeItem(2, 1);
						ChatBox.chat("Inventory", "You used a Health Potion.", "green");
						ChatBox.chat("Health", Integer.toString(player.stamina)+"->"+Integer.toString(player.stamina+10), "blue");
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
