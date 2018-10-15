import java.util.ArrayList;
import java.util.Scanner;

//import java.util.Random;

public class Game {
	private Team teamOne;
	private Team teamTwo;
	private Team teamOneScore;
	private Team teamTwoScore;
	private Scanner input;
	private ArrayList<Card> cardDeck;

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

	public void createCards(){
        Card one  = new Card("What is Net Present Value?", "The present value of an investment’s earning less the investment itself. ");
        Card two = new Card("What is a product backlog", "A prioritized list of “requirements” for a  project.");

        Card three = new Card("Responsibility of a Product Owner?", "The business value of the project");

        Card four = new Card("Responsibility of a ScrumMaster?", "Ensures that the team is functional and productive");

        Card five = new Card("Responsibility of a Project Team?", "Self-organizes to complete the work.");

        Card six = new Card("What is the goal of a Spike?", "Narrow the cone of uncertainty so that estimates of the implementation are feasible");

        Card seven = new Card("What is needed for a Definition of Done", "A prepared list of all activities (concrete) that must be completed");

        Card eight = new Card("What development model is described as “incremental and iterative”?", "Spiral Model");

        Card nine = new Card("What does Boehm’s Curve show?", "The cost of a change rises exponentially the later in the development lifecycle that the change is implemented. ");

        Card ten = new Card("Stories are often decomposed into what?", "Tasks");

        Card eleven = new Card("Each _____ should result in a potentially shippable product.", "Sprint  ");

        Card twelve = new Card("Which of the following are Scrum artifacts?", "Product backlog & Sprint backlog");

        Card thirteen = new Card("A _____________ can be used to show team progress for a sprint, for a release, and for the product delivery as a whole.", "burndown chart");

        Card fourteen = new Card("Who owns story point estimates and can change them if they discover new information?", "Scrum Master");

        Card fifteen = new Card(" What is Persona?", "A fictitious character who is a typical example of someone who plays one or more roles");

        Card sixteen = new Card("Which of the following represents the relative size of epics, stories, and tasks from biggest to smallest", "Epic > Story > Task");

        Card seventeen = new Card(" A process where research and development happen concurrently; the two feed off of one another", "Coevolution");

        Card eighteen = new Card("What is the relationship between epics, stories, tasks, and iterations?", "Epics require more than one iterations; stories require at most one iteration; tasks are completed in less than one iteration.");

        Card nineteen = new Card("Which of the following IS NOT an agile principle?", "The most efficient and effective method of conveying information to and within a development team is through electronic means such as email and shared wiki pages");

        Card twenty = new Card("Which of the following are examples of Agile frameworks.", "eXtreme Programming, Spiral, Scrum, Kanban");

        Card twentyone = new Card("A software development model characterized by gates where work in the next phase does not typically begin until prior phase is complete", "Waterfall Model");

        //populate card deck

        cardDeck.add(one);
        cardDeck.add(two);
        cardDeck.add(three);
        cardDeck.add(four);
        cardDeck.add(five);
        cardDeck.add(six);
        cardDeck.add(seven);
        cardDeck.add(eight);
        cardDeck.add(nine);
        cardDeck.add(ten);
        cardDeck.add(eleven);
        cardDeck.add(twelve);
        cardDeck.add(thirteen);
        cardDeck.add(fourteen);
        cardDeck.add(fifteen);
        cardDeck.add(sixteen);
        cardDeck.add(seventeen);
        cardDeck.add(eighteen);
        cardDeck.add(nineteen);
        cardDeck.add(twenty);
        cardDeck.add(twentyone);


    }
	
	
	
}
