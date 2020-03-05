package game;

import java.util.Scanner;

public class GameEngine{
	
	

    public static void main(String[] args) {
        boolean isStart = GameMenu.callMenu();
        if (isStart){
            System.out.println("Game Started!");
            PlayerDatas.Player player = GameLoad.loadSavedGame();
            Enemies.Enemy enemy = new Enemies.Enemy();
			while (true) {
				ChatBox.clearScreen();
				ChatBox.type("You are at level " + Integer.toString(player.level) +".\n1) Continue story\n2) Store\n3) Save & Exit");
				Scanner input = new Scanner(System.in);
				String x = input.nextLine();
				if ("1".equals(x)) {
					boolean Fight = true;
					if (player.level == 1) {
						ChatBox.chat("Storyteller","You are almost at the end of your journey, as you are getting close to the village, you hear a woman screaming.You quickly turn to the direction of the sounds.","blue");
						ChatBox.chat("Woman", "AAAAAAAAAAAAA! Help me!", "blue");
						enemy.level = 1;
						enemy.init = 1;
						enemy.stamina = 12;
						enemy.basedmg = 2;
						enemy.name = "Goblin";
					} else if (player.level == 2) {
						ChatBox.chat("Storyteller", "The lady turns to you, still shocked.", "blue");
						ChatBox.chat("Woman", "Thank you traveller, you saved my life, how can I ever repay you?", "blue");
						ChatBox.chat("Storyteller", "You are still confused, but you ask her for directions to town, to your luck she is also heading there.", "blue");
						ChatBox.chat("Storyteller", "As you arrive you see the town in flames, it turns out the town is under attack, the lady next to you has vanished, you hear a close grunt.", "blue");
						enemy.level = 2;
						enemy.init = 1;
						enemy.stamina = 30;
						enemy.basedmg = 4;
						enemy.name = "Troll";
					} else {
						Fight = false;
					}
					if (Fight){
						boolean win = GameFighting.fighting(player, enemy);
						if (win) {
							if (player.level == 1 ) {
								Inventory.giveItem(3,50);
								Inventory.giveItem(2,1);
								Inventory.giveItem(1,1);
							}
							if (player.level == 2) {
								Inventory.giveItem(3, 70);
							}
							player.level++;
							player.stamina = 10;
							ChatBox.chat("Success", "You gained a level", "green");
							GameLoad.saveGame(player);
						} else {
							ChatBox.chat("Fail", "You died", "red");
						}
					}else{
						ChatBox.type("To be continued...");
					}
				} else if ("2".equals(x)) {
					Shop.showStore();
				} else if ("3".equals(x)) {
					GameLoad.saveGame(player);
					break;
				}
				ChatBox.type("Press ENTER to continue!");
				input.nextLine();
			}
    	}
  	}
}
