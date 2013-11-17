/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Teacher will be instantiated
    //the Student is instantiated at the beginning of each playthrough
    private Student pat;
    private Teacher smaug;

    private String choice;

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame() {

	String s;
	String name = "";
	s = "Welcome to Ye Olde RPG!\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }
	//Hero = new Adam();

	s = "\nChoose your Hero:\n";

	s += "\t1: Adam\n";
	s += "\t2: Benedict\n";
	s += "\t3: Shahruz\n";
	s += "Selection: ";
	System.out.print(s);

	try {
	    choice = in.readLine();
	}
	catch ( IOException e ){}
	
	//instantiate the player's character
	if (choice.equals("1")) {  pat = new Adam();}
	else if (choice.equals("2")) { }//IMPLEMENT A BEN
	else {  pat = new Shahruz();} 


    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
            Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn() {

	int i = 1;
	int d1, d2;

	int teacherChoice = (int) (Math.random() * 5);

	if (teacherChoice == 0) { smaug = new Brooks();}
	else if (teacherChoice == 1) { smaug = new Zamansky(); } 
	else if (teacherChoice == 2) { smaug = new Brooks(); } //Brown
	else if (teacherChoice == 3) { smaug = new DW(); } 
	else { smaug = new Konstantinovich(); }

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );

	else {
	    System.out.println( "\nLo, yonder monster approacheth!\nTis a "+smaug.getName()+"!" );

	    //smaug = new Brooks();

	    while( smaug.isAlive() && pat.isAlive() ) {

		System.out.println( "Your HP: "+pat.getHP() );
		System.out.println( smaug.getName()+"'s HP: "+smaug.getHP() );

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "Attack?" );
		    System.out.println( "\t1: Normal.\n\t2: SPECIAL! CHARGE!!!@#$@!#$@\n\t3: Whoa whoa time out. Heal!" );
		    //have not implemented heal method (as a non-abstract in Student)
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }
		d1 = 0;
		d2 = 0;
		if (Math.random()>=.5){
		    d2 = smaug.attackNormal( pat );}
		else {d2 = smaug.attackSpecial( pat );}
		

		if ( i == 1 ){
		    pat.normalize();
		    d1 = pat.attackNormal( smaug );
		    
		}
		else if (i == 2) {
		    pat.specialize();
		    d1 = pat.attackSpecial( smaug );
		}
		else if ( i == 3) {
		    //pat.heal() or whatever Ben's implementation is
		}

		System.out.println( pat.getName() + " dealt " + d1 +
				    " points of damage.");

		System.out.println( smaug.getName() + " hit back for " + d2 +
				    " points of damage.");

	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You caused "+smaug.getName()+" to retire early because of stress, but " +
				    "with his last breath he failed you. " +
				    "You will never make it out of Stuy." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "Huzzaah! You have passed "+smaug.getName()+"'s class!" );
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "The teachers have proved too much for you...You have dropped all "+
				    "your CS courses, but plan to self-study for the AP test...Good luck...");
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
	/*=============================================

	  =============================================*/

    }//end main

}//end class YoRPG




/*=============================================
  =============================================*/
