public class Survivor {

    private int health;
    private int attack;
    private String name;
    private Weapon weapon;
    private final static int ARMED = 60;

    protected Survivor(int health, int attack, String name)
    {
        this.health = health;
        this.attack = attack;
        this.name = name;
        weapon = Weapon.getWeapon(ARMED);
    }
    
    
    public int getAttack()
    {
        return attack;
    }
    
    
    public int getHealth()
    {
        return health;
    }
    
    
    public Weapon getWeapon()
    {
        return weapon;
    }  // end getWeapon()
    
    
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
    
    
    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon;
    }  // end setWeapon(Weapon)
    
    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    

    public String attack(Zombie zombie)
    {
        String result = "";
        if (!zombie.isDead() && !this.isDead())
        {
            int attackValue = (weapon == null ? this.attack : this.attack + weapon.addAttack());
            zombie.setHealth(zombie.getHealth() - attackValue);
            if (zombie.isDead() && attackValue == this.attack)
            {
                result = "  " + this.name + " killed " + zombie.getName() + ".";
            }
            else if (zombie.isDead())
                result = "  " + this.name + " killed " + zombie.getName() + " with their " + weapon.getName() + ".";
        }
        
        return result;
    }
}