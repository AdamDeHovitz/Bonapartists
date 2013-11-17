/*=============================================
  Shahruz, houses his own special attack, and the method to call one of them 
  =============================================*/


public class Shahruz extends Student{
    
    Adam helper = new Adam();

    public Shahruz(){
	_hitPts = 100;
	_strength = 120;
	_defense = 40;
	_attack = .4;
	_name = "Shahruz";}
    
    
    
    public int askAdam(Character opponent){

	int damage = (int)( ( (_strength * _attack) + helper.laptop(this) - opponent.getDefense() ) * 0.75);
	damage *= 1.3;
	return damage;}
    
    public int gedit(Character opponent){
	
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	
	return damage;
    }
    public int attackSpecial(Character opponent){ 
	 int type = (int)(Math.random()*2);
	 int damage = 0;
	 if (type == 0){
	     System.out.println(_name+" gets help from his trusty Adam!\n"+
				"Adam pulls out his laptop for an additional "+helper.laptop(this)+" damage!");
	     damage = askAdam(opponent);}
	 else {
	     System.out.println(_name + " uses gedit instead of emacs!");
	     damage = gedit(opponent);}
	

	 if ( damage < 0 )
	     damage = 0;
	 
	 opponent.lowerHP( damage );

	 return damage;}

}