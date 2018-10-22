
public class Card {
	// Question for the card
	private String sQuestion;
	// Answer for the card
	private String sAnswer;
	//Add Number attribute
	private int num;


	public Card() {
		this.sQuestion = "";
		this.sAnswer = "";
	}

	public Card(String sQuestion, String sAnswer, int num ) {
		this.sQuestion = sQuestion;
		this.sAnswer = sAnswer;
		this.num = num;
	}

	public int getNumber(){
		return num;
	}
	
	public String getsQuestion() {
		return sQuestion;
	}
		
	public void setsQuestion(String sQuestion) {
		this.sQuestion = sQuestion;
	}
	public String getsAnswer() {
		return sAnswer;
	}
	public void setsAnswer(String sAnswer) {
		this.sAnswer = sAnswer;
	}
	
	// The idea is to compare the question card with the user selected card,
	// if both the question and answer are match, then the answer is correct
	// Return value: True == Correct || False == Incorrect
	public boolean checkResult(Card answerCard) {
		boolean result = false;
		
		if (this.sQuestion == answerCard.sQuestion && this.sAnswer == answerCard.sAnswer) {
			result = true;
		}
		return result;
	}
}
