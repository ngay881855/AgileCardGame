import java.util.*;
public class GameDriver {

	
	public static void main(String args[]) {
		
		
		String selection;
		displayOptions();
		selection = userInput();
		
		
		
		if(selection.equals("rules")) 
		{
			displayRules();
		}
		else if(selection.equals("start")) 
		{
			System.out.println("HERE WE GOOOOOO!");
			Team teamOne = new Team(1);
			Team teamTwo = new Team(2);
			
			teamOne.setTeamName();
			System.out.println("I like your name team " + teamOne.getTeamName());	
			teamTwo.setTeamName();
			System.out.println("oof team" + teamTwo.getTeamName() + " team one had the better name");
		}
		else 
		{
			System.out.println("AHHHHH none of those words were right bleh");	
		}	
		
	}
	
	
	public static void displayOptions() {
		System.out.println("Hello and welcome to the agile card game");
		System.out.println("__________________________________________");
		System.out.println("If you would like to hear the rules of the game please type in rules below");
		System.out.println("If you would like to start the game please type in start below!!");
	}
	
	public static void displayRules() {
		System.out.println("rules rules rules....");
	}
	public static String userInput(){
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.next();
		answer = answer.trim();	
		return answer;
		
	}

	public Integer getPoints(){
		return 0;
	}

	public void displayScore(){

	}
}
