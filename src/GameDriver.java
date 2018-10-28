import java.util.*;
public class GameDriver {

	
	public static void main(String args[]) {
		
		
		String selection;
		Game game = new Game();
		game.displayGreetings();
		selection = userInput();
		String tName;

		
		while(!selection.equals("quit")) {
			if(selection.equals("rules")) {
				game.displayRules();
				System.out.println();
			}
			else if(selection.equals("")) {
				System.out.println("Invalid entry........");
				System.out.println();
			}
			else if(selection.equals("start")) {
				System.out.println();
				game.setupTeams();
				game.createQACards();
				//System.out.println();
				tName = game.init();
				game.playGame(tName);
				game.findoutWinner();
				System.out.println("Game is over now!!!!!!!!!!!!!!!!!");
				break;
			}
			else 
			{
				System.out.println("AHHHHH none of those words were right bleh");	
				System.out.println();
			}	
			//System.out.println();
			selection = userInput();
		}
	

		
	}
	
	public static String userInput(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("User Input: ");
		System.out.print("");
		String answer = scanner.nextLine();
		answer = answer.trim();
		answer = answer.toLowerCase();	//to change it to lowercase
		return answer;
		
	}

	public Integer getPoints(){
		return 0;
	}

	public void displayScore(){

	}
}
