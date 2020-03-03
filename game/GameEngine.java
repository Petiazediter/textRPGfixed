package game;

public class GameEngine{
    public static void main(String[] args) {
        boolean isStart = GameMenu.callMenu();
        if (isStart){
            System.out.println("Game Started!");
            PlayerDatas.Player player = GameLoad.loadSavedGame();
            
            
			
			
			//while (true) {
				if (player.level == 1) {
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
