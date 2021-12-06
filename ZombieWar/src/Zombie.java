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
    
    
    public void attack(Survivor survivor)
    {
        if (!survivor.isDead())
            survivor.setHealth(survivor.getHealth() - this.attack);
    }
}