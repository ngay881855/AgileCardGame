package main.java.cardgame;
import java.util.*;
public class Team {
	
	private String teamName;
	private int num;
	private int score;
	private Scanner scanner;
	
	public Team(int num) {
		//this.teamName = teamName;
		this.num = num;
	};
	
	private String inputTeamName() {
		scanner = new Scanner(System.in);
		System.out.print("Alright team " + this.num + " enter your name here: ");
		String name = scanner.nextLine();
		return name;
		
	}
	public void setTeamName() {
		//System.out.println();
		this.teamName = inputTeamName().toUpperCase();
	}
	
	public String getTeamName() {
		return teamName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}
}
