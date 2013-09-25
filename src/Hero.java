
public class Hero {
	 
	private String heroName;
	private int startHp;
	private int currentHp;
	
	public Hero(String name, int hp) {
	        heroName = name;
	        startHp = hp;
	        currentHp = hp;
	    }
	  
	    public String getName() {
	        return heroName;
	    }
	
	    public int getStartHp() {
	        return startHp;
	    }

	    public int getCurrentHp() {
	        return currentHp;
	    }
	        
	    public void addHp() {
	        if (currentHp < startHp) 
	        		currentHp++;
	    }
	
	    public void removeHp() {
	        if (currentHp > 0) 
	        		currentHp--;
	    }
	        

}
