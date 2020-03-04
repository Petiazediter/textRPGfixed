package game;

import java.util.Scanner;

public class Shop {
	public static final int[][] shopItems = {{2, 50}, {1, 150}};
	
	public static void showStore() {
		int choose = 0;
		/*for (int[] table: shopItems) {
			int itemID = 0;
			int price = 1;
			System.out.print(Integer.toString(index)+" ");
			ChatBox.chat(Inventory.ALL_ITEMS[table[itemID]-1], Integer.toString(table[price])+" gold", "blue");
			index ++;
		}*/
		Scanner input = new Scanner(System.in);
		while (true) {
			ChatBox.chatFast("Controls", "W/S - movement | X - exit | E - buy", "blue");
			for (int i = 0; i < shopItems.length; i++) {
				if (choose == i) {
					System.out.print("->");
				} else {
				System.out.print("  ");
				}
				int itemID = 0;
				int price = 1;
				int[] table = shopItems[i];
				ChatBox.chatFast(Inventory.ALL_ITEMS[table[itemID]-1], Integer.toString(table[price])+" gold", "blue");
			}
			String key = input.nextLine();
			if ("x".equals(key)) {
				break;
			} else if ("s".equals(key)) {
				if (choose == 0) {
					choose = shopItems.length;
				} 
				choose--;
				System.out.println("c:"+Integer.toString(choose));
			} else if ("w".equals(key)) {
				choose++;
				if (choose == shopItems.length) {
					choose = 0;
				}
			} else if ("e".equals(key)) {
				buyItem(choose);
			}
			ChatBox.clearScreen();
		}
	}
	
	public static void buyItem(int index) {
		if (Inventory.hasItem(3, shopItems[index][1])) {
			ChatBox.chat("Store", "Succesful purchase.", "green");
			Inventory.giveItem(shopItems[index][0], 1);
			Inventory.takeItem(3, shopItems[index][1]);
		} else {
			ChatBox.chat("Store", "You don't have enough gold.", "red");
		}
	}
		
	
	public static void main(String[] args) {
		showStore();

	}
}


