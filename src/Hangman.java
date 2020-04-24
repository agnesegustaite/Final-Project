
import java.util.Scanner; 
import java.util.Random;

public class Hangman { 
    public static void main(String[] args){ //the main class and the core
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String guesses[] = { "Albania", "Belize", "Cameroon", "Djibouti", 
        		"Kyrgyzstan", "Liberia", "Malawi", "Oman", "Paraguay", "Samoa", 
        		"Suriname", "Tuvalu", "Vanuatu", "Zambia"}; //the names of the countries that will be needed to be guessed
        
        
        boolean weArePlaying = true; //defining the variables
        while(weArePlaying){
            System.out.println("Welcome to Agnese's Hangman game!:) \n\tGuess the countries game.");  //introduction
    		System.out.println("In this game you must guess the names of some of the world's countries! Best of luck! :)");
    		System.out.println("        \uD83C\uDF0D"); //an emoji for more interesting look console :)
    		
            int randomNumber = random.nextInt(guesses.length); //random.nextInt(14);
            char randomWordToGuess[] = guesses[randomNumber].toCharArray(); //
            int ammountOfGuesses = randomWordToGuess.length; //total tries to guess the country 
            char playerGuess[] = new char[ammountOfGuesses]; // "* * * * * * * * * * * * * * " 14
            
            for(int i=0; i<playerGuess.length; i++){ // Assigning empty dashes at start "* * * * * * * * * * * * * *"
                playerGuess[i] =  '*';
            } 
            
            boolean wordIsGuessed = false;
            int tries = 0;
            
            while(!wordIsGuessed && tries != ammountOfGuesses){
                System.out.println("Current Guesses: ");
                print(playerGuess);
                System.out.printf("You have %d ammount of tries left!\n", ammountOfGuesses-tries);
                System.out.println("Please Enter a Letter: "); //for entering letters
                char input = scanner.nextLine().charAt(0);
                tries++;
                
                if(input == '*'){
                    wordIsGuessed = true;
                    weArePlaying = false;
                } else{
                    for(int i=0; i<randomWordToGuess.length; i++){
                        if(randomWordToGuess[i] == input){
                            playerGuess[i] = input;
                        } 
                    } 
                    
                    if(isTheWordGuessed(playerGuess)){
                        wordIsGuessed = true;
                        System.out.println("Congratulations!!! :)"); //Congratulating the player
                    }
                }
            } /* End of wordIsGuessed */
            if(!wordIsGuessed){
                System.out.println("I'm sorry. You ran out of guesses and lost this time. :("); //if the game is lost
              
            }
            
            System.out.println("Would you like to play again? (yes/no) "); //enabling the player to choose whether they would like to play again
            String choice = scanner.nextLine();
            if(choice.equals("no")){
                weArePlaying = false;
            }
            
        }//End of Playing
        
        System.out.println("Game is Over!");
    }
    
    public static void print(char array[]){
        for(int i=0; i<array.length; i++){ // Assign empty dashes at start "* * * * * * * * * * * * * *"
            System.out.print(array[i] + " ");
        } 
        System.out.println();
    }
    
    public static boolean isTheWordGuessed(char[] array){ 
        boolean condition = true;
        for(int i=0; i<array.length; i++){
            if(array[i] == '*'){
                condition = false;
            }
        }
        return condition;
    }
}//end of main