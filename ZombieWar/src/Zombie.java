public class Zombie {

    private int health;
    private int attack;

    public Zombie(){

    }

    public Zombie(int health, int attack){
        this.health = health;
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
