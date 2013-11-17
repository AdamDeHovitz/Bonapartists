//class DW contain's Mr. D-W's abilities

public class DW extends Teacher{
    
    private String[] puns= {"'A dyslexic man walks into a bra'","'Time flies like an arrow. Fruit flies like a banana'",
			    "'What's pointless? A broken pencil. ((also life))'","'Every calendar's days are numbered'",
			    "'Two cannibals are eating a clown. One says to the other: ''Does this taste funny to you?'' '",
			    "'Two muffins are baking in an oven.  The first muffin says, 'wow, it's really getting hot in here.'\n\tThe second muffin says, 'Wow... a talking muffin !' '",
			    "'An invisible man marries an invisible woman. The kids were nothing to look at either.'",};

    public DW(){
	_hitPts = 125;
	_strength = 100;
	_defense = 40;
	_attack = .4;
	_name = "Mr. Dyrland-Weaver";}

    public int badPun(Character opponent){
	
	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	damage *= 1 + (Math.random());
	return damage;}
    
    
    public int attackSpecial(Character opponent){ 
	int damage;
	System.out.println(_name+" makes an extremely bad pun! Oy!\n" + puns[(int)(Math.random()*puns.length)]);
	damage = badPun(opponent);

	if ( damage < 0 )
	     damage = 0;
	 
	 opponent.lowerHP( damage );
	 
	return damage;}
}
	 