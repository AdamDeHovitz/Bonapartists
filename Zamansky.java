//class Zamansky with his abilities

public class Zamansky extends Teacher{
    
    public Zamansky(){
	_hitPts = 120;
	_strength = 120;
	_defense = 35;
	_attack = .45;
	_name = "Mr. Zamansky";}

    public int minions(Character opponent){
	
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	damage *= 1.3;
	return damage;}
    
    
    public int attackSpecial(Character opponent){ 
	int damage;
	System.out.println(_name+" calls upon his CS Minions!");
	damage = minions(opponent);

	if ( damage < 0 )
	     damage = 0;
	 
	 opponent.lowerHP( damage );
	 
	return damage;}
}
	 