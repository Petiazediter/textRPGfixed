package game;
import java.util.Scanner;

public class GameMenu{
    public static boolean callMenu(){
        Scanner input = new Scanner(System.in);

        System.out.println("1) Start");
        System.out.println("2) Exit");
        
        while (true){
            int choose = input.nextInt();
            if ( choose == 1){
                return true;
            }else if(choose == 2){
                return false;
            }else{
                System.out.println(choose + " ~= " + "1");
                choose = input.nextInt();
            }
        }
    }
}
