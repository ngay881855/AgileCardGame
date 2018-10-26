
public class QACard {
	// Question for the card
	private String sQuestion;
	// Answer for the card
	private String sAnswer;

	/*
	public QACard() {
		this.sQuestion = "";
		this.sAnswer = "";
	}*/
	public QACard(String sQuestion, String sAnswer) {
		this.sQuestion = sQuestion;
		this.sAnswer = sAnswer;
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
	public boolean checkResult(QACard answerCard) {
		boolean result = false;
		
		if (this.sQuestion == answerCard.sQuestion && this.sAnswer == answerCard.sAnswer) {
			result = true;
		}
		return result;
	}
}
