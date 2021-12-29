/*Name: Michael Bradshaw
  Date: October 26, 2020
  File Name: Player.java
  Description: Holds the class that the player instance will use to play the harry potter game.
*/

//Takes in the random library:
import java.util.Random;

//Class Name: Player
//Description: Holds the class that the player instance uses during the Harry Potter game:
public class Player
{
  //Instance varables:
  
  //Gets a instance of the random class
  private Random r = new Random();
  //This varable holds the name of the player:
  private String name;
  //This varable holds the health of the player and sets it to 50:
  private int health = 50;

  //This varable holds the list of spells that can be used for offensive plays:
  private String [] offensive_spells = new String[]{"Confundo", "Locomotor Mortis", "Stupefy", "Expelliarmus", "Incendio", "Petrificus Totalus"};
  //This varable holds the list of spells that can be used for defenisive plays:
  private  String [] defensive_spells = new String[]{"Finite Incantum", "Episkey", "Protego", "Expecto Patronum"};
  
  //This method print the health reduction:
  public void printHealthReduction(int amountDecreased){
    //Prints the health reduction and calls the blankLine method from the game class to print a space after:
    System.out.println("Player " + this.getName() + " health decreased by " + amountDecreased); //You can put a string and a varable together thats a integer together.
  }
  //This method sets the health from the input:
  public void setHealth(int value){
    this.health = value;
  }
  //This method returns the health of the player:
  public int getHealth(){
    //Check if the health of the player is less than or equal to zero if it is it returns 0:
    if (this.health <= 0){
      return 0;
    }
    //If not it just returns the health:
    else{
      return health;
    }
  }
  //This method sets the name of the player:
  public void setName(String name){
    this.name = name;
  }
  //This method returns the name of the player:
  public String getName(){
    return name;
  } 

  //This method when call gets a random integer between 1 and 6 and returns a number plus that random number:
  public int roll()
  {
    //Returns a random integer between 1 and 6 and adds one:
    return (r.nextInt(6)+1);
  }
  //This method when called will get a spell for the number in the roll from the player:
  public String getOSpell(int playerRoll)
  {
    //Returns the offensive spell at the playerRoll - 1 for the index of the list:
    return offensive_spells[playerRoll-1];
  }
  //This method when called will get a spell for the number in the roll from the player:
  public String getDSpell(int playerRoll){
    if (playerRoll < 3){
      //Returns the string no spell if the player rolls a value less than 3
      return "no spell";
    }
    else{
      //Returns the defensive spell at the playerRoll - 3 for the rolls after 3
      return defensive_spells[playerRoll-3];
    }
  }
  //This method takes in the two players rolls and does damage to the offensePlayer:
  public void set_Health_OffensePlayer(int playerRoll, int opponentRoll){
    //This runs if the opponent gets a spell that deflects all of the player spells:
    if (opponentRoll == 5){
      if (playerRoll == 1){
        //Reduces health by offense player health by 8
        this.health -= 8;
        printHealthReduction(8);
      }
      else if (playerRoll == 2){
        //Reduces health by offense player health by 9
        this.health -= 9;
        printHealthReduction(9);
      }
      else if (playerRoll == 3){
        //Reduces health by offense player health by 10
        this.health -= 10;
        printHealthReduction(10);
      }
      else if (playerRoll == 5 || playerRoll == 6){
        //Reduces health by offense player health by 12
        this.health -= 12;
        printHealthReduction(12);
      }
    }
  }
  //This method takes in the two players rolls and does damage to the defensePlayer, and prints out the damage done:
  public void set_Health_DefensePlayer(int playerRoll, int opponentRoll){
    if (opponentRoll < 3){ //Good!
      if(playerRoll == 1){
        //The health of the defender is reduced by 8:
        this.health -= 8;
        printHealthReduction(8);
      }
      else if(playerRoll == 2 || playerRoll == 4){
        //The health of the defender is reduced by 9:
        this.health -= 9;
        printHealthReduction(9);
      }
      else if(playerRoll == 3){
        //The health of the defender is reduced by 10:
        this.health -= 10;
        printHealthReduction(10);
      }
      //Runs this if playerRoll is 4 or more:
      else{
        //The health of the defender is reduced by 12:
        this.health -= 12;
        printHealthReduction(12);
      }
    }
    //Defends any spell roll 3 and under:
    else if (playerRoll <= 3 && opponentRoll == 3){
      //Calls the game class and the method blankLine to print a space:
      Game.blankLine();
      //Prints the following:
      System.out.println("Spell was defended!");
      //Calls the game class and the method blankLine to print a space:
      Game.blankLine();
    }
    //Defences for attack spells > than 3 and for opponent Roll of 3:
    else if (playerRoll > 3){ 
      if (opponentRoll == 3){
        if (playerRoll == 4){
          //The health of the defender is reduced by 9:
          this.health -= 9;
          printHealthReduction(9);
        }
        else if (playerRoll == 5 || playerRoll == 6){
          //The health of the defender is reduced by 12:
          this.health -= 12;
          printHealthReduction(12);
        }
      } 
      else if (opponentRoll == 4){
        if(playerRoll == 1){
          //The health of the defender is reduced by 3:
          this.health -= 3;
          printHealthReduction(3);
        }
        else if(playerRoll == 2){
          //The health of the defender is reduced by 4:
          this.health -= 4;
          printHealthReduction(4);
        }
        else if(playerRoll == 3){
          //The health of the defender is reduced by 5:
          this.health -= 5;
          printHealthReduction(5);
        }
        else if (playerRoll == 4){
          //The health of the defender is reduced by 9:
          this.health -= 9;
          printHealthReduction(9);
        }
        else if (playerRoll == 5 || playerRoll == 6){
          //The health of the defender is reduced by 7:
          this.health -= 7;
          printHealthReduction(7);
        }
      }
      else if (opponentRoll == 5){
        if (playerRoll == 4){
          //The health of the defender is reduced by 9:
          this.health -= 9;
          printHealthReduction(9);
        }
        else{
          //Calls the game class and the method blankLine to print a space:
          Game.blankLine();
          //Prints the following:
          System.out.println("Spell was deflected back to attacker!");
        }
      }
      else if (opponentRoll == 6){
        if (playerRoll == 4){
          //The health of the defender is reduced by 9:
          this.health -= 9;
          printHealthReduction(9);
        }
        else if (playerRoll == 5 || playerRoll == 6){
          //Calls the game class and the method blankLine to print a space:
          Game.blankLine();
          //Prints the following:
          System.out.println("The Spell was defended!");
        }
      }
    }
  }
}