import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//import java.util.Random;

public class Game {
	private Team teamOne;
	private Team teamTwo;
	private Scanner input;
	private ArrayList <QACard> cardDeck;
	private ArrayList <QACard> displayedCardDeck = new ArrayList<QACard>();
	
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
		System.out.println();
		
		
	}

	public String init() {
		// TODO Auto-generated method stub
		CoinToss coin = new CoinToss();
		String tName;

		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("Let me flip a coin to decide which team should go first!!!");
		System.out.println();
		
		if(coin.flip().equals("Heads")) {
			//teamOne will start the game
			tName = teamOne.getTeamName();
		}
		else {
			//teamTwo will start the game
			tName = teamTwo.getTeamName();
		}
		System.out.println("Coin decided "+tName+" to be the first.......");
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("<<<<<<<<<<Let me initiate the game>>>>>>>>>>");
		System.out.println();
		//displayQA();
		return tName;
	}

	public int random() {
		Random rand = new Random();
		int randomNum = rand.nextInt((21 - 1) + 1) + 1;
		if(randomNum+10 >21) {
			randomNum = randomNum-10;
		}
		return randomNum;
	}
	public void playGame(String tName) {

		displayAnswerCard();

		for(int i=1; i<11; i++) {
			displayQuestion(i);

			if(tName.equals(teamOne.getTeamName())) {
				System.out.println("----------------|"+teamOne.getTeamName()+" score is " + teamOne.getScore()+"|----------------");
				System.out.println(teamOne.getTeamName()+", please enter which card # do you want to use: ");
				teamCardInput(tName);
				tName = teamTwo.getTeamName();
				System.out.println();
				System.out.println("----------------|"+teamTwo.getTeamName()+" score is " + teamTwo.getScore()+"|----------------");
				System.out.println(teamTwo.getTeamName()+", please enter which card # do you want to use: ");
				teamCardInput(tName);
				tName = teamOne.getTeamName();
			}
			else {
				System.out.println("----------------|"+teamTwo.getTeamName()+" score is " + teamTwo.getScore()+"|----------------");
				System.out.println(teamTwo.getTeamName()+", please enter which card # do you want to use: ");
				teamCardInput(tName);
				System.out.println();
				tName = teamOne.getTeamName();
				System.out.println("----------------|"+teamOne.getTeamName()+" score is " + teamOne.getScore()+"|----------------");
				System.out.println(teamOne.getTeamName()+", please enter which card # do you want to use: ");
				teamCardInput(tName);
				tName = teamTwo.getTeamName();
			}
			System.out.println();
		}
		
	}

	public void findoutWinner() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println();
		System.out.println("******************************************************************");
		System.out.println(teamOne.getTeamName()+" scored "+teamOne.getScore());
		System.out.println(teamTwo.getTeamName()+" scored "+teamTwo.getScore());
		System.out.println("******************************************************************");
		System.out.println();
		if(teamOne.getScore()>teamTwo.getScore()) {
			System.out.println("That's why the winner is "+teamOne.getTeamName());
		}
		else if(teamTwo.getScore()>teamOne.getScore()) {
			System.out.println("That's why the winner is "+teamTwo.getTeamName());
			
		}
		else {
			System.out.println("Both teams score is same. That's why match is tied.");
		}
		
	}

	private boolean checkDisplayedCardDeck(QACard tempCard) {
		QACard dispCard;
		boolean check=true;
		int cardDeckSize = displayedCardDeck.size();
		//System.out.println("CardDeck Size "+cardDeckSize);

		if(cardDeckSize != 0) {
			for(int i=0; i<cardDeckSize; i++) {
				dispCard = displayedCardDeck.get(i);
				if(!tempCard.getsQuestion().equals(dispCard.getsQuestion())) {
					check = false;
				}
				else {
					check = true;
					break;
				}
			}
		}
		
		return check;
	}

	private void displayQuestion(int qNum) {
		// TODO Auto-generated method stub
		int randomNum = random();
		QACard tempCard1 = cardDeck.get(randomNum);
		
		boolean check = checkDisplayedCardDeck(tempCard1);
		if(qNum == 1 || check == false) {
			System.out.println("Question "+ qNum+"?");
			System.out.println(tempCard1.getsQuestion());
			displayedCardDeck.add(tempCard1);
		}
		else if(check == true) {
			displayQuestion(qNum);
		}
		
	}

	private void displayAnswerCard() {
		// TODO Auto-generated method stub
		System.out.println("..........................................Answer Cards..........................................");
		QACard tempCard;
		int counter =0;
		for(int i=0; i<cardDeck.size(); i++) {
			tempCard = cardDeck.get(i);
			counter =i+1;
			System.out.println(counter+". "+tempCard.getsAnswer());
		}
		System.out.println();
		
	}

	private void teamCardInput(String tName) {
		input = new Scanner(System.in);
		String teamInput = input.nextLine();
		teamInput = teamInput.toLowerCase();
		int cardNum=0;
		
		if(teamInput.matches("[0-9]+")) {
			cardNum = Integer.parseInt(teamInput);
			if(cardNum<0 || cardNum>21) {
				System.out.println("~~~~~~~~~~~~~~~~Incorrect Input~~~~~~~~~~~~~~~~");
				System.out.println(tName+" please re-enter card # that you think is best answer for given question.");
				teamCardInput(tName);
			}
			else {
				evaluateTeamInput(tName,cardNum);
			}
			
		}
		else if(teamInput.equals("show answer cards")) {
			displayAnswerCard();
		}
		else {
			System.out.println("~~~~~~~~~~~~~~~~Incorrect Input~~~~~~~~~~~~~~~~");
			System.out.println(tName+" please re-enter card # that you think is best answer for given question.");
			teamCardInput(tName);
		}
	}

	public void evaluateTeamInput(String tName, int cardNum) {
		QACard tempCardDeck = cardDeck.get(cardNum-1);
		int lastElement = displayedCardDeck.size()-1;
		QACard dispCardDeck = displayedCardDeck.get(lastElement);
		
		if(tempCardDeck.getsAnswer().equals(dispCardDeck.getsAnswer())) {
			System.out.println(tName+", your answer is correct.");
			if(tName.equals(teamOne.getTeamName())) {
				teamOne.setScore(5);
			}
			else {
				teamTwo.setScore(5);
			}
		}
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
				"\n4. There will be total of 21 questions. Each team will need to answer 10 question each."+
				"\n5. Team that answers most questions correctly will win the game."+ 
				"\n6. To see answer card during a game, please just type & enter \"show answer cards\".");
		System.out.println("******************************************GAME RULES & INSTRUCTIONS***********************************************");
		//System.out.println();
		
	}

	public void createQACards() {
		// TODO Auto-generated method stub
		
        QACard one  = new QACard("What is Net Present Value?", "The present value of an investment’s earning less the investment itself. ");
        QACard two = new QACard("What is a product backlog", "A prioritized list of “requirements” for a  project.");
        QACard three = new QACard("Responsibility of a Product Owner?", "The business value of the project");
        QACard four = new QACard("Responsibility of a ScrumMaster?", "Ensures that the team is functional and productive");
        QACard five = new QACard("Responsibility of a Project Team?", "Self-organizes to complete the work.");
        QACard six = new QACard("What is the goal of a Spike?", "Narrow the cone of uncertainty so that estimates of the implementation are feasible");
        QACard seven = new QACard("What is needed for a Definition of Done", "A prepared list of all activities (concrete) that must be completed");
        QACard eight = new QACard("What development model is described as “incremental and iterative”?", "Spiral Model");
        QACard nine = new QACard("What does Boehm’s Curve show?", "The cost of a change rises exponentially the later in the development lifecycle that the change is implemented. ");
        QACard ten = new QACard("Stories are often decomposed into what?", "Tasks");
        QACard eleven = new QACard("Each _____ should result in a potentially shippable product.", "Sprint  ");
        QACard twelve = new QACard("Which of the following are Scrum artifacts?", "Product backlog & Sprint backlog");
        QACard thirteen = new QACard("A _____________ can be used to show team progress for a sprint, for a release, and for the product delivery as a whole.", "burndown chart");
        QACard fourteen = new QACard("Who owns story point estimates and can change them if they discover new information?", "Scrum Master");
        QACard fifteen = new QACard(" What is Persona?", "A fictitious character who is a typical example of someone who plays one or more roles");
        QACard sixteen = new QACard("Which of the following represents the relative size of epics, stories, and tasks from biggest to smallest", "Epic > Story > Task");
        QACard seventeen = new QACard(" A process where research and development happen concurrently; the two feed off of one another", "Coevolution");
        QACard eighteen = new QACard("What is the relationship between epics, stories, tasks, and iterations?", "Epics require more than one iterations; stories require at most one iteration; tasks are completed in less than one iteration.");
        QACard nineteen = new QACard("Which of the following IS NOT an agile principle?", "The most efficient and effective method of conveying information to and within a development team is through electronic means such as email and shared wiki pages");
        QACard twenty = new QACard("Which of the following are examples of Agile frameworks.", "eXtreme Programming, Spiral, Scrum, Kanban");
        QACard twentyone = new QACard("A software development model characterized by gates where work in the next phase does not typically begin until prior phase is complete", "Waterfall Model");

        //populate card deck
        cardDeck = new ArrayList<QACard>();
        
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
