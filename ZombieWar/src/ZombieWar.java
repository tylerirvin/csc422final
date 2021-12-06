
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
    }
}
