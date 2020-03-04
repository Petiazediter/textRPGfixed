package game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Inventory{
	public static final String[] ALL_ITEMS = {"Stick"};

	public static class Item{
		int itemID;
		int stock;	
	}
	
	public static void main(String[] args){
		giveItem(1,1);
	}
	
	public static ArrayList<Item> getInventory(){
		ArrayList<Item> result = new ArrayList<Item>();
		String csvFile = (System.getProperty("user.dir") + "/inventory.save");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] savedata = line.split(cvsSplitBy);
                if (savedata.length == 2){
					Item item = new Item();
					item.itemID = Integer.parseInt(savedata[0]);
					item.stock = Integer.parseInt(savedata[1]);
					result.add(item);
				}
            }
        } catch (FileNotFoundException e) {
            result = createNewInventory();
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
        return result;
	}
	
	private static ArrayList<Item> createNewInventory(){
		ArrayList<Item> items = new ArrayList<Item>();
        File file = new File(System.getProperty("user.dir") + "/inventory.save");     
        try {
            FileWriter w = new FileWriter(file);
            w.close();   
        } catch (Exception e) {
                //TODO: handle exception
        }
        return items;		
	}
	
	public static void printItems(){
		ArrayList<Item> items = getInventory();
		for (Item item : items){
			System.out.println(item.itemID + " (" + Integer.toString(item.stock) + " db)");
		}
	}
	
	public static void giveItem(int itemID,int stock){
		//System.out.println("You got a new item (" + allItems[itemID-1] + ")");
		ChatBox.chat("Inventory","You got " + Integer.toString(stock) + " new " + ALL_ITEMS[itemID-1],"green");	
		
		boolean found = false;
		
		ArrayList<Item> items = getInventory();
		
		for (Item item : items){
			if (item.itemID == itemID){
				item.stock += stock;
				found = true;		
			}			
		}
		
		if (found == false){
			Item newItem = new Item();
			newItem.itemID = itemID;
			newItem.stock = stock;	
			items.add(newItem);
		}
		// SAVE	
		SaveInventory(items);	
	}
	
	public static void SaveInventory(ArrayList<Item> items){
        File file = new File(System.getProperty("user.dir") + "/inventory.save");     
        try {
            FileWriter w = new FileWriter(file);
            for (Item item : items){
            	w.write(Integer.toString(item.itemID) + "," + Integer.toString(item.stock) + "\n");
            }
            w.close();   
        } catch (Exception e) {
                //TODO: handle exception
        }
	}
	
	public static boolean hasItem(int itemID, int stock){
		ArrayList<Item> items = getInventory();
		for (Item item : items ){
			if (item.itemID == itemID){
				if (item.stock >= stock){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void takeItem(int itemID,int stock){
		if (hasItem(itemID,stock)){
			ArrayList<Item> items = getInventory();
			for (int i = 0; i < items.size(); i++){
				Item item = items.get(i);
				if (item.itemID == itemID){
					if (item.stock <= stock){
						items.remove(i);
					}else{
						item.stock -= 1;
					}
					break;
				}
			}
			SaveInventory(items);
		}
	}
}
