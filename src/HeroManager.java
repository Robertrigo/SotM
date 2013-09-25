


public class HeroManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numberOfHeroes = 3;
				
		// Populate hero list.
		
		final String [] heroList = {
				"Legacy", "The Wraith", "Haka"
		};
		
		final int [] hpList = {
				32, 26, 34
		};
		
		// Hero [] heroList = new Hero[numberOfHeroes];

		// Populate hero list.
//		heroList[0] = new Hero("Legacy",32); 
//		heroList[1] = new Hero("The Wraith",26);
//		heroList[2] = new Hero("Haka",34);
		
		for(int i=0; i<numberOfHeroes; i++){
		      System.out.println("Hero: " + heroList[i]);
       }
		
		CreateWindow ex = new CreateWindow();
        ex.setVisible(true); 
	
	}

}
