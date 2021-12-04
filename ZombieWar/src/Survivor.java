public class Survivor {

    private int health;
    private int attack;

    public Survivor(){

    }
    public Survivor(int health, int attack){
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

