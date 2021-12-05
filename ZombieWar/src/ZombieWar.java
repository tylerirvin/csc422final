// Main class 

public class ZombieWar {

    public static void main(String[] args) {

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
