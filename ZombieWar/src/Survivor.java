public class Survivor {

    private int health;
    private int attack;
    private String name;

    protected Survivor(int health, int attack, String name)
    {
        this.health = health;
        this.attack = attack;
        this.name = name;
    }
    
    
    public int getAttack()
    {
        return attack;
    }
    
    
    public int getHealth()
    {
        return health;
    }
    
    
    public boolean isDead()
    {
        return health <= 0;
    }
    
    
    public void setAttack(int attack)
    {
        this.attack = attack;
    }
    
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }
}