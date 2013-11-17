/*=============================================
  Student, houses the default attacks that will be used if individuals choose not to specialize
  =============================================*/

public abstract class Student extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    protected String _name;
   
    public String getName(){
	return _name;
    }
    
    public int attackNormal( Character opponent ) {
	 int type = (int)(Math.random()*2);
	 int damage = 0;
	 if (type == 0){
	     System.out.println(_name+" asks annoying question!");
	     damage = askQuestion(opponent);}
	 else {
	     System.out.println(_name + " does his homework using code found online!");
	     damage = doHW(opponent);}
		 // int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	 //System.out.println( "\t\t**DIAG** damage: " + damage );

	 if ( damage < 0 )
	     damage = 0;
	 
	 opponent.lowerHP( damage );

	 return damage;}

    
    public int askQuestion(Character opponent){
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	return damage;
    }
    public int doHW(Character opponent){
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	damage *= 1.3;
	return damage;
    }


    public String about(){
	return "The Student is a persistant fellow, working against great odds in the hope of one day not being a Student";}
    
    //prepare a Warrior for a special attack
    /*public void specialize() {
	_attack = .75;
	_defense = 20;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .4;
	_defense = 40;
	}*/

}//end class Warrior
