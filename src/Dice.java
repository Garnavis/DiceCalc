import java.util.Random;

public class Dice {

    private static Random roller = new Random();
    
    public static int roll(int dice, int sides) {
        int total = 0;
        int thisRoll;
        for ( int i = 0; i < dice; ++i ) {
            thisRoll = 1 + roller.nextInt(sides);
            if ( thisRoll < 1 ) thisRoll = 1;
            total += thisRoll;
        }
        return total;
    }
      
    public static int roll(int dice, int sides, int modifier) {
        int total = 0;
        int thisRoll;
        for ( int i = 0; i <= dice; ++i ) {
            thisRoll = 1 + roller.nextInt(sides) + modifier;
            if ( thisRoll < 1 ) thisRoll = 1;
            total += thisRoll;
        }
        return total;
    }
}