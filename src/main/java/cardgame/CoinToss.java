package main.java.cardgame;
import java.util.Random;

public class CoinToss {

	private enum Coin{Heads, Tails};

	private int result;
	Coin coinFlip;
	Random randomNum = new Random();

	public String flip(){
	    result = randomNum.nextInt(2);
	    if(result == 0){
	        coinFlip = Coin.Heads;
	        //System.out.println("You flipped Heads!");
	        return "Heads";
	    }else{
	        coinFlip = Coin.Tails;
	        //System.out.println("You flipped Tails!");
	        return "Tails";
	    }
	  }
	
}
