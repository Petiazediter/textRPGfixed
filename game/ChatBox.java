package game;

public class ChatBox{

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static void chat(String colored, String text, String color){
		if (color == "green"){
			System.out.println(ANSI_GREEN + "[" + colored + "]:" + ANSI_RESET + " " + text);
		}else if (color == "red"){
			System.out.println(ANSI_RED + "[" + colored + "]:" + ANSI_RESET + " " + text);
		}else if (color == "blue"){
			System.out.println(ANSI_BLUE + "[" + colored + "]:" + ANSI_RESET + " " + text);
		}else{
			System.out.println("[" + colored + "]: " + text);
		}
	}
}
