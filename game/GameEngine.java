package game;

public class GameEngine{
	
	

    public static void main(String[] args) {
        boolean isStart = GameMenu.callMenu();
        if (isStart){
            System.out.println("Game Started!");
            PlayerDatas.Player player = GameLoad.loadSavedGame();
			//while (true) {
				
			
				if (player.level == 1) {
					ChatBox.chat("Storyteller","You are almost at the end of your journey, as you are getting close to the village, you hear a woman screaming.You quickly turn to the direction of the sounds.","blue");
					ChatBox.chat("Woman", "AAAAAAAAAAAAA! Help me!", "blue");
					
					Enemies.Enemy goblin = new Enemies.Enemy();
					goblin.level = 1;
					goblin.init = 1;
					goblin.stamina = 5;
					goblin.basedmg = 10;
					goblin.name = "Dezső";
					GameFighting.fighting(player, goblin);
				}
			//}
			
			
        }
    }
}
