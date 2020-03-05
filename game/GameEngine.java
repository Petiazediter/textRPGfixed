package game;

public class GameEngine{
	
	

    public static void main(String[] args) {
        boolean isStart = GameMenu.callMenu();
        if (isStart){
            System.out.println("Game Started!");
            PlayerDatas.Player player = GameLoad.loadSavedGame();
			//while (true) {
				
			
				if (player.level == 1) {

					ChatBox.chat("Storyteller","You are almost at the end of your journey, as you are getting close to the village, you hear a woman 							screaming.You quickly turn to the direction of the sounds.","blue");
					ChatBox.chat("Woman", "AAAAAAAAAAAAA! Help me!", "blue");
					
					Enemies.Enemy goblin = new Enemies.Enemy();
					goblin.level = 1;
					goblin.init = 1;
					goblin.stamina = 20;
					goblin.basedmg = 10;
					goblin.name = "Goblin";
					GameFighting.fighting(player, goblin);
					
				}
				
				if (player.level == 2) {
					ChatBox.chat("Storyteller", "The lady turns to you, still shocked", "blue");
					ChatBox.chat("Woman", "Thank you traveller, you saved my life, how can I ever repay you?", "blue");
					ChatBox.chat("Storyteller", "You are still confused, but you ask her for directions to town, to your luck she is also heading there", 							"blue");
					ChatBox.chat("Storyteller", "As you arrive you see the town in flames, it turns out the town is under attack, the lady next to you has 							vanished, you hear a close mumbling", "blue");

					Enemies.Enemy troll = new Enemies.Enemy();
					troll.level = 2;
					troll.init = 1;
					troll.stamina = 40;
					troll.basedmg = 8;
					troll.name = "Troll";
					GameFighting.fighting(player, troll);
				}
			//}
			
			
        }
    }
}
