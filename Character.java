/*=============================================
  class Character -- superclass for combatants in Ye Olde RPG
  =============================================*/

public  abstract class Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    protected int _hitPts;
    protected int _strength;
    protected int _defense;
    protected double _attack;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Character() {
	_hitPts = 125;
	_strength = 100;
	_defense = 40;
	_attack = .4;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public int getDefense() { return _defense; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    /*=============================================
      boolean isAlive() -- tell whether I am alive
      post: returns boolean indicated alive or dead
      =============================================*/
    public boolean isAlive() {
	return _hitPts > 0;
    }


    /*=============================================
      int attack(Character) -- simulates attack on instance of class Monster
      pre:  Input not null
      post: Calculates damage to be inflicted, flooring at 0. 
            Calls opponent's lowerHP() method to inflict damage. 
	    Returns damage dealt.
      =============================================*/
    public abstract int attackSpecial(Character opponent);
    
    public int attackNormal( Character opponent ) {

	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	//System.out.println( "\t\t**DIAG** damage: " + damage );

	if ( damage < 0 )
	    damage = 0;

	opponent.lowerHP( damage );

	return damage;
    }//end attack


    /*=============================================
      void lowerHP(int) -- lowers life by input value
      pre:  Input >= 0
      post: Life instance var is lowered by input ammount.
      =============================================*/
    public void lowerHP( int damageInflicted ) {
	_hitPts = _hitPts - damageInflicted;
    }
    public abstract String about();

    public void specialize() {
	_attack = .75;
	_defense = 20;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .4;
	_defense = 40;
    }

}//end class Character
