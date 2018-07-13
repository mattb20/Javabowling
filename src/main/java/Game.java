public class Game {
	
	int score = 0;
	boolean strike = false;
	int bonus_rolls = 0;
	int roll_counter = 1;
	int lastScore = 0;
	boolean spare = false;
    public void roll(int pins) throws RuntimeException {
    	if ((pins <= 10) && (pins >= 0)) {
    		handleScore(pins);
    		if (pins == 10) {
        		strike = true;
        		bonus_rolls = 0;
        	}
    		if (bonus_rolls >= 2) {
    			strike = false;
    		}
    		
        	if (roll_counter == 2) {
        		roll_counter = 1;
        		if(lastScore + pins == 10) {
        			spare = true;
        		} 
        	} else {
        		spare = false;
        	}
         	lastScore = pins;
        	roll_counter += 1;
        	
        	
    	}
    	else {
    		throw new RuntimeException();
    	}
    }
    public boolean strike() {
    	return strike;
    }
    /**
     * score at end of the game
     * @return
     */
    
    public int score() {
        return score;
    }
    private void doubleScore(int pins) {
    	score += 2 * pins;
    	bonus_rolls += 1;
    }
    private void handleScore(int pins) {
    	if (strike || spare){
    		doubleScore(pins);
    	} else {
    		score +=  pins;
    	}
    }
}
