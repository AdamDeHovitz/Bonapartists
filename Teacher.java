/*=============================================
  class Teacher -- houses the default teacher attacks
  =============================================*/

public abstract class Teacher extends Character {
    protected String _name;


    public String getName(){
	return _name;
    }
    
    public int attackNormal( Character opponent ) {
	 int type = (int)(Math.random()*2);
	 int damage = 0;
	 if (type == 0){
	     System.out.println(_name+" assigns a pop test! It's worth 95% of your grade!");
	     damage = givesTest(opponent);}
	 else {
	     System.out.println(_name + " forces students to use slow computers in class!");
	     damage = slowComputers(opponent);}
		 // int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	 //System.out.println( "\t\t**DIAG** damage: " + damage );

	 if ( damage < 0 )
	     damage = 0;
	 
	 opponent.lowerHP( damage );

	 return damage;}

    
    public int givesTest(Character opponent){
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	damage *= 1.3;
	return damage;
    }
    public int slowComputers(Character opponent){
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );

	return damage;
    }


    
    public String about(){
	return "A Teacher has large canines, glistening with saliza as it imagines crushing you between it's jaws";}


}//end class Monster
