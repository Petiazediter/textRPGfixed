package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class GameLoad{
    public static PlayerDatas.Player loadSavedGame(){
        PlayerDatas.Player s = new PlayerDatas.Player();
        String csvFile = (System.getProperty("user.dir") + "/gamesave.save");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] savedata = line.split(cvsSplitBy);
                s.level = Integer.parseInt(savedata[0]);
                s.name = savedata[1];
                s.stamina = Integer.parseInt(savedata[2]);
                s.cast = savedata[3];
		s.basedmg = Integer.parseInt(savedata[4]);
            }

        } catch (FileNotFoundException e) {
            s = createNewSave();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return s;
    }

    public static PlayerDatas.Player createNewSave(){
        PlayerDatas.Player s = new PlayerDatas.Player();
        s.level = 1;
        s.stamina = 10;
	s.basedmg = 10;
        
        Scanner input = new Scanner(System.in);
        System.out.println("What's your character's name?");
        s.name = input.nextLine();

        s.cast = "Mage";

        saveGame(s);

        return s;
    }

    public static void saveGame(PlayerDatas.Player player){
        String save = Integer.toString(player.level) +","+ player.name+","+ Integer.toString(player.stamina)+","+ player.cast+","+ player.basedmg;
        File file = new File(System.getProperty("user.dir") + "/gamesave.save");
        try {
            FileWriter w = new FileWriter(file);
            w.write(save);
            w.close();   
        } catch (Exception e) {
                //TODO: handle exception
        }
    }
}
