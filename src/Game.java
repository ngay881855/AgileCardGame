import java.util.Scanner;

//import java.util.Random;

public class Game {
	private Team teamOne;
	private Team teamTwo;
	private Team teamOneScore;
	private Team teamTwoScore;
	private Scanner input;

	public void setupTeams() {
		// set up team names
		System.out.println("HERE WE GOOOOOO!");
		this.teamOne = new Team(1);
		this.teamTwo = new Team(2);
		
		teamOne.setTeamName();
		System.out.println("Team 1: You have choosen \"" + teamOne.getTeamName() +"\" as your team name");	
		System.out.println();
		teamTwo.setTeamName();
		
		if(teamOne.getTeamName().equals(teamTwo.getTeamName())) {
			System.out.println("Error: I cannot name both teams same. Team 1 already chosen "+teamTwo.getTeamName()+". "
					+ "\nPlease re-enter your team name.");
			teamTwo.setTeamName();
		}
		System.out.println("Team 2: You have choosen \"" + teamTwo.getTeamName() +"\" as your team name");	
		System.out.println();

		if(teamOne.getTeamName().hashCode()<teamTwo.getTeamName().hashCode()) {
			System.out.println(teamOne.getTeamName()+" sounds much better than "+teamTwo.getTeamName()+".");
		}
		else {
			System.out.println(teamTwo.getTeamName()+" sounds much better than "+teamOne.getTeamName()+".");
		}
		
	}

	public void gameStart() {
		CoinToss coin = new CoinToss();

		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("Let me flip a coin to decide which team should go first!!!");
		System.out.println();
		
		if(coin.flip().equals("Heads")) {
			//teamOne will start the game
			System.out.println("Coin decided "+teamOne.getTeamName()+" to be the first.......");
			System.out.println("------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("<<<<<<<<<<Let me initiate the game>>>>>>>>>>");
			System.out.println();
			System.out.println("----------------|"+teamOne.getTeamName()+" score is " + teamOne.getScore()+"|----------------");
			System.out.println(teamOne.getTeamName()+", please enter which card do you want to use: ");
			teamCardInput();
		}
		else {
			//teamTwo will start the game
			System.out.println("Coin decided "+teamTwo.getTeamName()+" to be the first.......");
			System.out.println("------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("<<<<<<<<<<Let me initiate the game>>>>>>>>>>");
			System.out.println();
			System.out.println("----------------|"+teamTwo.getTeamName()+" score is " + teamTwo.getScore()+"|----------------");
			System.out.println(teamTwo.getTeamName()+", please enter which card do you want to use: ");
			teamCardInput();
		}
		
		
	}
	
	private void teamCardInput() {
		input = new Scanner(System.in);
		String cardNumber = input.nextLine();
		
		int cardNum = Integer.parseInt(cardNumber);
	
		
	}

	public static void gameScore() {
		
	}
	

	public void displayGreetings() {
		System.out.printf("%75s%n","WELCOME TO THE AGILE CARD MATCHING GAME");
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("* This game requires two teams to play. "
				+ "\n* Each team will be given 10 answer cards. "
				+ "\n* Each team will need to answer 10 questions using given cards."
				+ "\n* Each question is worth 5 points."
				+ "\n* Team with most points will win the game.");
		System.out.println();
		System.out.println("> For rules and instructions of the game, please type in \"rules\" below!!");
		System.out.println("> To start the game, please type in \"start\" below!!");
		System.out.println("> To quit the game, please type in \"quit\" below!!");
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		//System.out.println();
		
	}
	
	public void displayRules() {
		System.out.println();
		System.out.println("******************************************GAME RULES & INSTRUCTIONS***********************************************");
		System.out.println("1. Game will start once \"start\" is entered by user."+
				"\n2. Once game starts, game will randomly pick a team and display a very first question."+
				"\n3. After first team inputs a matching card to the question, game will check its validity and display result as \"right or wrong\" and display a very first question to other team."+
				"\n4. There will be total of 20 questions. Each team will need to answer 10 question each."+
				"\n5. Team that answers most questions correctly will win the game.");
		System.out.println("******************************************GAME RULES & INSTRUCTIONS***********************************************");
		//System.out.println();
		
	}

	
	
	
}
