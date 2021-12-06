
import java.util.ArrayList;


// Main class 

public class ZombieWar {
    
    private static final int MAX_CHARACTERS = 20;
    private static final ArrayList<Survivor> survivors = new ArrayList<>();
    private static final ArrayList<Zombie> zombies = new ArrayList<>();
    
    public static void main(String[] args) {
        
        // Generate random number of survivors and zombies
        int survivorCount = (int)(1 + Math.random() * MAX_CHARACTERS);
        int zombieCount = (int)(1 + Math.random() * MAX_CHARACTERS);

        // Initialize survivors and zombies to randomly assigned subclasses
        initialize(survivorCount, zombieCount);

        // Start the battle!
        attack();
    }
    
    /**
     * Fills ArrayLists survivors and zombies. Subclasses for each chosen randomly.
     * 
     * @param survivorCount - Integer for number of Survivors to create
     * @param zombieCount   - Integer for number of Zombies to create
     * 
     * Author: Tyler Irvin
     * Revisions (work, person)
     * -------------------------------------------------------------------------
     * Added stats block to avoid instanceof calls. Also reworked constructors to 
     * allow for number to be inserted in name. Added details to intro.
     * -Tyler Irvin
     */
    private static void initialize(int survivorCount, int zombieCount)
    {
        /* Counters for each type of survivor and zombie.
         * stats[0] represents survivors and stats[1] represents zombies. stats[][x] represents subclasses. 
         */ 
        int[][] stats = new int[2][];
        stats[0] = new int[]{0, 0, 0};
        stats[1] = new int[]{0, 0};
        
        // Cycle through survivors and randomly assign subclasses (child, teacher, soldier)
        for (int i = 0; i < survivorCount; i++)
        {
            int randomClass = (int)(Math.random() * 3);
            switch (randomClass)
            {
                case 0  -> 
                {
                    stats[0][0]++;
                    survivors.add(new Child(stats[0][0]));
                }
                case 1  ->
                {
                    stats[0][1]++;
                    survivors.add(new Teacher(stats[0][1]));
                }
                default ->
                {
                    stats[0][2]++;
                    survivors.add(new Soldier(stats[0][2]));
                }
            }
        }
        
        // Cycle through zombies and randomly assign subclasses (common infected, tank)
        for (int i = 0; i < zombieCount; i++)
        {
            int randomClass = (int)(Math.random() * 2);
            switch (randomClass)
            {
                case 0  ->
                {
                    stats[1][0]++;
                    zombies.add(new CommonInfected(stats[1][0]));
                }
                default ->
                {
                    stats[1][1]++;
                    zombies.add(new Tank(stats[1][1]));
                }
            }
        }
        
        // Display starting message with numbers of each, survivors and zombies
        System.out.print("We have " + survivors.size() + " survivors trying to make it to safety.");
        System.out.println(" (" + stats[0][0] + " children, " + stats[0][1] + " teachers, " + stats[0][2] + " soldiers)");
        System.out.print("But there are " + zombies.size() + " zombies waiting for them.");
        System.out.println(" (" + stats[1][0] + " common infected, " + stats[1][1] + " tanks)");
        
/*          // TESTING output
        System.out.println("\nSURVIVORS:\n");
        for (int i = 0; i < survivors.size(); i++)
        {
            System.out.println("Survivor name:   " + survivors.get(i).getName());
            System.out.println("Survivor attack: " + survivors.get(i).getAttack());
            System.out.println("Survivor health: " + survivors.get(i).getHealth() + "\n");
        }
        
        System.out.println("\nZOMBIES:\n");
        for (int i = 0; i < zombies.size(); i++)
        {
            System.out.println("Zombie name:   " + zombies.get(i).getName());
            System.out.println("Zombie attack: " + zombies.get(i).getAttack());
            System.out.println("Zombie health: " + zombies.get(i).getHealth() + "\n");            
        }
*/
    }

    /**
     * Cycles through the survivor vs zombie attack waves. Survivors attack first.
     * Displays number of suvivors left on finish.
     * 
     * Author: Sienna-Rae Johnson
     * Revisions (work, person):
     */
    private static void attack() {
        // Continue until one faction is depleted
        while(survivors.size() > 0 && zombies.size() > 0) 
        {
            // survivors attack first. Every survivor attacks every zombie
            for (int i = 0; i < survivors.size(); i++) 
            {
                for (int j = 0; j < zombies.size(); j++) 
                {
                    // One survivor attacks one zombie
                    survivors.get(i).attack(zombies.get(j));                    

                    // If zombie dies, remove it from list and decrement counter by one
                    if (zombies.get(j).isDead()) 
                    {
                        zombies.remove(j);
                        j--;
                    }
                } // end for(j)
            } // end for(i)

            // zombies attack next. Every zombie attacks every survivor
            for (int i = 0; i < zombies.size(); i++) 
            {
                for (int j = 0; j < survivors.size(); j++) 
                {
                    // One zombie attacks one survivor
                    zombies.get(i).attack(survivors.get(j));

                    // If survivor dies, remove it from list and decrement counter by one
                    if (survivors.get(j).isDead()) 
                    {
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
