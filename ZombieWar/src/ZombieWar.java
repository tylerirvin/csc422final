
import java.util.ArrayList;


// Main class 

public class ZombieWar {
    
    private static final int MAX_CHARACTERS = 20;
    private static final ArrayList<Survivor> survivors = new ArrayList<>();
    private static final ArrayList<Zombie> zombies = new ArrayList<>();
    
    public static void main(String[] args) {
        
        int survivorCount = (int)(1 + Math.random() * MAX_CHARACTERS);
        int zombieCount = (int)(1 + Math.random() * MAX_CHARACTERS);
        initialize(survivorCount, zombieCount);

/*        int initialSurvivorNum = 17;
        int afterMathSurvivorNum = 6;
        int zombieNum = 8;
        
        SampleRun1(initialSurvivorNum, afterMathSurvivorNum, zombieNum);
*/
        attack();
    }

/*    private static void SampleRun1(int initialSurvivorNum, int afterMathSurvivorNum, int zombieNum) {

        String outcome = "We have " + initialSurvivorNum + " survivors trying to make it to safety.\nBut there are "
                + zombieNum + " zombies waiting for them.\nIt seems " + afterMathSurvivorNum
                + " have made it to safety.";
        System.out.print(outcome);
    }
*/    
    
    /**
     * Fills ArrayLists survivors and zombies. Subclasses for each chosen randomly.
     * 
     * @param survivorCount - Integer for number of Survivors to create
     * @param zombieCount   - Integer for number of Zombies to create
     * 
     * Author: Tyler Irvin
     * Revisions (work, person):
     */
    private static void initialize(int survivorCount, int zombieCount)
    {
        for (int i = 0; i < survivorCount; i++)
        {
            int randomClass = (int)(Math.random() * 3);
            switch (randomClass)
            {
                case 0  -> 
                    {survivors.add(new Child());}
                case 1  ->
                    {survivors.add(new Teacher());}
                default ->
                    {survivors.add(new Soldier());}
            }
        }
        
        for (int i = 0; i < zombieCount; i++)
        {
            int randomClass = (int)(Math.random() * 2);
            switch (randomClass)
            {
                case 0  ->
                    {zombies.add(new CommonInfected());}
                default ->
                    {zombies.add(new Tank());}
            }
        }
        
        System.out.println("We have " + survivors.size() + " survivors trying to make it to safety.");
        System.out.println("But there are " + zombies.size() + " zombies waiting for them.");
        
/*          // TESTING output
        System.out.println("\nSURVIVORS:\n");
        for (int i = 0; i < survivors.size(); i++)
        {
            System.out.println("Survivor class:  " + survivors.get(i).getName());
            System.out.println("Survivor attack: " + survivors.get(i).getAttack());
            System.out.println("Survivor health: " + survivors.get(i).getHealth() + "\n");
        }
        
        System.out.println("\nZOMBIES:\n");
        for (int i = 0; i < zombies.size(); i++)
        {
            System.out.println("Zombie class:  " + zombies.get(i).getName());
            System.out.println("Zombie attack: " + zombies.get(i).getAttack());
            System.out.println("Zombie health: " + zombies.get(i).getHealth() + "\n");            
        }
*/
    } // end initialize()

    /**
     * Cycles through the survivor vs zombie attack waves. Survivors attack first.
     * 
     * Author: Sienna-Rae Johnson
     * Revisions (work, person):
     */
    private static void attack() {
        // Continue until one faction is depleted
        while(survivors.size() > 0 && zombies.size() > 0) {
            // survivors attack first. Every survivor attacks every zombie
            for (int i = 0; i < survivors.size(); i++) {
                for (int j = 0; j < zombies.size(); j++) {
                    // One survivor attacks one zombie
                    survivors.get(i).attack(zombies.get(j));

                    // If zombie dies, remove it from list and decrement counter by one
                    if (zombies.get(j).isDead()) {
                        zombies.remove(j);
                        j--;
                    }
                } // end for(j)
            } // end for(i)

            // zombies attack next. Every zombie attacks every survivor
            for (int i = 0; i < zombies.size(); i++) {
                for (int j = 0; j < survivors.size(); j++) {
                    // One zombie attacks onen survivor
                    zombies.get(i).attack(survivors.get(j));

                    // If survivor dies, remove it from list and decrement counter by one
                    if (survivors.get(j).isDead()) {
                        survivors.remove(j);
                        j--;
                    }
                } // end for(j)
            } // end for(i)
        } // end while()

        // Display number of living survivors
        if (survivors.size() < 1) 
            System.out.println("None of the survivors made it.");
        else 
            System.out.println("It seems " + survivors.size() + " have made it to safety.");
    } // end startBattle()

}
