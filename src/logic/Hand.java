package logic;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {
	String name;

	public Hand(String name) {
		this.name = name;
	}

	public int getSum() {
		int sum = 0;
		for (int i = 0; i < this.size(); i++) {
			sum += this.get(i).getValue();
		}
		return sum;
	}
	
	@Override
	public String toString(){
		String retval = name + "'s Cards: ";
		for(int i = 0; i < this.size(); i++){
			retval += ("[" + this.get(i) + "] ");
		}
		return retval;
	}
	
	public boolean isBlackjack(){
		return(this.size() == 2 && this.getSum() == 21);
	}
	
	public boolean hasAce(){
		for(int i = 0; i < this.size(); i++){
			if(this.get(i).isAce())
				return true;
		}
		return false;
	}

}
