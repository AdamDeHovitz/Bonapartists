//class Brooks contain's Mr. Brook's abilities

public class Brooks extends Teacher{
    
    

    public Brooks(){
	_hitPts = 125;
	_strength = 100;
	_defense = 40;
	_attack = .4;
	_name = "Mr. Brooks";}

    public int suspenders(Character opponent){
	
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	damage *= 1.3;
	return damage;}
    
    
    public int attackSpecial(Character opponent){ 
	int damage;
	System.out.println(_name+" swings at you with his suspenders!");
	damage = suspenders(opponent);

	if ( damage < 0 )
	     damage = 0;
	 
	 opponent.lowerHP( damage );
	 
	return damage;}
}
	 