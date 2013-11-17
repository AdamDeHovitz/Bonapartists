//class Konstantinovich contain's Mr. Konstantinovich's abilities

public class Konstantinovich extends Teacher{
    
    private String[] lore= {"Lord of the Rings","Star Trek","Futurama","Star Wars","Legend of Zelda",};

    public Konstantinovich(){
	_hitPts = 125;
	_strength = 100;
	_defense = 40;
	_attack = .4;
	_name = "Mr. Konstantinovich";}

    public int reference(Character opponent){
	
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	damage *= 1 + (Math.random()/2);
	return damage;}
    
    
    public int attackSpecial(Character opponent){ 
	int damage;
	System.out.println(_name+" makes an obscure " + lore[(int)(Math.random()*5)]+ " reference!\n Ouch that one hurt!");
	damage = reference(opponent);

	if ( damage < 0 )
	     damage = 0;
	 
	 opponent.lowerHP( damage );
	 
	return damage;}
}
	 