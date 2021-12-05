// Main class 

public class ZombieWar {

    public static void main(String[] args) {
        Survivor survivor1 = new Soldier();
        System.out.println("Survivor class:  " + survivor1.getName());
        System.out.println("Survivor attack: " + survivor1.getAttack());
        System.out.println("Survivor health: " + survivor1.getHealth() + "\n");
        
        Zombie zombie1 = new Tank();
        System.out.println("Zombie class:  " + zombie1.getName());
        System.out.println("Zombie attack: " + zombie1.getAttack());
        System.out.println("Zombie health: " + zombie1.getHealth() + "\n");
        
        survivor1.attack(zombie1);
        System.out.println("Zombie class:  " + zombie1.getName());
        System.out.println("Zombie health: " + zombie1.getHealth() + "\n");
        
        int initialSurvivorNum = 17;
        int afterMathSurvivorNum = 6;
        int zombieNum = 8;

        SampleRun1(initialSurvivorNum, afterMathSurvivorNum, zombieNum);

    }

    private static void SampleRun1(int initialSurvivorNum, int afterMathSurvivorNum, int zombieNum) {

        String outcome = "We have " + initialSurvivorNum + " survivors trying to make it to safety.\nBut there are "
                + zombieNum + " zombies waiting for them.\nIt seems " + afterMathSurvivorNum
                + " have made it to safety.";
        System.out.print(outcome);
    }

}
