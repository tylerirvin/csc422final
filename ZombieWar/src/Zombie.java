public class Zombie {

    private int health;
    private int attack;
    private String name;

    protected Zombie(int health, int attack, String name){
        this.health = health;
        this.attack = attack;
        this.name = name;
    }

    
    public int getAttack() {
        return attack;
    }

    
    public int getHealth() {
        return health;
    }
    
    
    public String getName()
    {
        return name;
    }

    
    public void setAttack(int attack) {
        this.attack = attack;
    }

    
    public void setHealth(int health) {
        this.health = health;
    }
    
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    
    public boolean isDead()
    {
        return health <= 0;
    }
    
    
    public String attack(Survivor survivor)
    {
        String result = "";
        if (!survivor.isDead() && !this.isDead())
        {
            survivor.setHealth(survivor.getHealth() - this.attack);
            if(survivor.isDead())
                result = "  " + this.name + " killed " + survivor.getName() + ".";
        }
        
        return result;
    }
}