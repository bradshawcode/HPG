/*Name: Michael Bradshaw
  Date: October 26, 2020
  File Name: Game.java
  Description: Holds the game class that runs the Harry Potter Game!
*/

//Gets the scanner library:
import java.util.Scanner;

//Class Name: Game
//Description: Holds the methods and varables that run the Harry Potter Game:
public class Game{

    //All VARABLES ARE PRIVATE MEANING CAN NOT BE ACCESSED OUTSIDE OF THE GAME CLASS AND ARE STATIC MEANING THEY CAN BE USED WITHOUT GETTING A INSTANCE OF THIS CLASS!

    //These two varables hold the rolls of player1 and player2 roll:
    private static int player1Roll = 0;
    private static int player2Roll = 0;

    //lists: 
    //                  Objects
    //private static List<Player> i = new ArrayList();
   // private static List<Integer> i = new ArrayList();

    //This boolean varable holds which player1 is attacker, if true player1 is attacker, if false player2 is attacker:
    private static boolean currentPlayer = true;

    //Gets new instances of the player class for the two players:
    private static Player player1 = new Player();
    private static Player player2 = new Player();

    //This method prints a space:
    public static void blankLine(){
        System.out.println(" ");
    }

    //This method prints out a method:
    public static void printMenu(){
        //Calls the blankline method to print a space:
        blankLine();
        //Lists
        // i.add(5);
        // System.out.println(i.size());
        // System.out.println(i);
        // i.add(6);
        // System.out.println(i.size());
        // System.out.println(i);

        //Prints the following:
        System.out.println("Hello and welcome to the Harry Potter game, in this game you will see a battle of two players!");
        //Calls the blankline method to print a space:
        blankLine();
        //Prints the following, the \ \ are escape characters when adding the "'s:
        System.out.println("Please enter \"s\" to start the game simulation!");

        //Calls the blankline method to print a space:
        blankLine();

        //Prints the following, the \ \ are escape characters when adding the "'s:
        System.out.println("Please enter \"q\" to quit the program.");

        //Calls the blankline method to print a space:
        blankLine();
    }

    //This method manages which player is defending or attacking and it calls all the player methods to reduce health when allowed:
    public static void managePlayers(){
        //Gets the roll of each player:
        player1Roll = player1.roll();
        player2Roll = player2.roll();
        //Prints the names of each player and prints the roll as a string:
        System.out.println("Player " + player1.getName() + " rolls a " + Integer.toString(player1Roll));
        //Calls the method that prints a space
        blankLine();
        //Prints the names of each player and prints the roll as a string:
        System.out.println("Player " + player2.getName() + " rolls a " + Integer.toString(player2Roll));
        //Calls the method that prints a space
        blankLine();

        //If the currentPlayer is true meaning player 1 than do attacker as p1 and defender as p2:
        if (currentPlayer){
            //Prints the following:
            System.out.println("Player " + player1.getName() + " attacks with " + player1.getOSpell(player1Roll) + "!");
            //Calls the method that prints a space
            blankLine();
            //Prints the following:
            System.out.println("Player " + player2.getName() + " defends with " + player2.getDSpell(player2Roll) + "!");
            //Calls the method that prints a space
            blankLine();
            player2.set_Health_DefensePlayer(player1Roll, player2Roll);
            player1.set_Health_OffensePlayer(player1Roll, player2Roll);
            currentPlayer = false;
        }
        else{
            //Prints the following:
            System.out.println("Player " + player2.getName() + " attacks with " + player2.getOSpell(player2Roll) + "!");
            //Calls the method that prints a space
            blankLine();
            //Prints the following:
            System.out.println("Player " + player1.getName() + " defends with " + player1.getDSpell(player1Roll) + "!");
            //Calls the method that prints a space
            blankLine();
            player2.set_Health_OffensePlayer(player1Roll, player2Roll);
            player1.set_Health_DefensePlayer(player1Roll, player2Roll);
            currentPlayer = true;
        }
    }
    //This method prints out a update for the health of each player:
    public static void printHealthUpdate(){
        //Calls the method that prints a space
        blankLine();
        //Prints the current health of each player to the console:
        System.out.println("Current healths of Players: ");
        //Calls the method that prints a space
        blankLine();
        System.out.println("Player " + player1.getName() + " your health is " + Integer.toString(player1.getHealth()));
        //Calls the method that prints a space
        blankLine();
        System.out.println("Player " + player2.getName() + " your health is " + Integer.toString(player2.getHealth()));
        //Calls the method that prints a space
        blankLine();
    }

    //The method that runs the program:
    public static void main(String[] args){
        //This boolean varable holds the game loop:
        boolean gameLoop = false;

        //This boolean varable holds the program loop:
        boolean programLoop = true;

        //This varable holds the userinput:
        String userInput;

        //Gets a new instance of the scanner class:
        Scanner input = new Scanner(System.in);

        //Calls the menu method:
        printMenu();

        while(programLoop){

            //Prints the following:
            System.out.print("Please enter here: ");

            //Gets a string input from the user.
            userInput = input.nextLine();
            //Changes the userinput to all lowercases:
            userInput = userInput.toLowerCase();

            //Checks if the userinputs equals the required input to start the program:
            if (userInput.equals("s")){

                //Sets the gameLoop boolean to true:
                gameLoop = true;

                //Calls the blankLine method that prints a space:
                blankLine();
            }
            //Checks if the userinputs equals the required input to quit the program:
            else if (userInput.equals("q")){

                //Calls the blankLine method that prints a space:
                blankLine();

                //Prints the following:
                System.out.println("Goodbye, have a good day!");

                //Sets the program loop to false:
                programLoop = false;

                //Closes the input instance:
                input.close();
            }
            // if no values are accepted it runs the prints the statements below:
            else{

                //Calls the blankLine method that prints a space:
                blankLine();

                //Prints the following if the user does not enter the right option:
                System.out.println("Please enter from the options above!");

                //Calls the blankLine method that prints a space:
                blankLine();
            }

            //Checks if the gameLoop boolean is true, if so it runs the following:
            if (gameLoop){
                //Prints the following:
                System.out.println("Please enter the names of the two players below!");
                //Calls the method that prints a space
                blankLine();
                //Gets the name of each player:
                System.out.print("Enter player 1's name here: ");
                player1.setName(input.nextLine());
                System.out.print("Enter player 2's name here: ");
                player2.setName(input.nextLine());
                //Calls the method that prints a space
                blankLine();
            }
            //This while loop will run if the boolean gameLoop is true:
            while (gameLoop) {

                //Calls the method that manages the game and players:
                managePlayers();

                //Calls the method that prints out the health update:
                printHealthUpdate();

                if (player1.getHealth() <= 0){
                    //Prints the following:
                    System.out.println("Player " + player1.getName() + " has died, player " + player2.getName() + " wins!");
                    gameLoop = false;

                    //Resets the healths:
                    player1.setHealth(50);
                    player2.setHealth(50);

                    //Calls the menu method:
                    printMenu();
                }
                else if (player2.getHealth() <= 0){
                    //Prints the following:
                    System.out.println("Player " + player2.getName() + " has died, player " + player1.getName() + " wins!");
                    gameLoop = false;

                    //Resets the healths:
                    player1.setHealth(50);
                    player2.setHealth(50);

                    //Calls the menu method:
                    printMenu();
                }
            }
        }
    }
}