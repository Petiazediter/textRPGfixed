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

	public static class Item{
		int itemID;
		int stock;	
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
	
	public static void main(String[] args){
		giveItem(1,1);
	}
	
	public static void giveItem(int itemID,int stock){
		String[] allItems = getAllItems();
		System.out.println("You got a new item (" + allItems[itemID-1] + ")");
		
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
	
	private static void SaveInventory(){
	}
	
	private static String[] getAllItems(){
		String[] allItems = {"Stick", "Health Potion"};
		return allItems;
	}
}
