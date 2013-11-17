/*=============================================
 Adam, houses his own special attack, and the method to call one of them 
  =============================================*/


public class Adam extends Student{
    


    public Adam(){
	_hitPts = 130;
	_strength = 90;
	_defense = 40;
	_attack = .4;
	_name = "Adam";}
    
    
    
    public int laptop(Character opponent){
	
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	damage *= 1.3;
	return damage;}
    
    public int dehoHypo(Character opponent){
	
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	
	return damage;
    }
    public int attackSpecial(Character opponent){ 
	 int type = (int)(Math.random()*2);
	 int damage = 0;
	 if (type == 0){
	     System.out.println(_name+" pulls out his own laptop to use!");
	     damage = laptop(opponent);}
	 else {
	     System.out.println(_name + " develops the DeHovitz hypothesis!");
	     damage = dehoHypo(opponent);}
	

	 if ( damage < 0 )
	     damage = 0;
	 
	 opponent.lowerHP( damage );

	 return damage;}

}