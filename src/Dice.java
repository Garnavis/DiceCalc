import java.util.Random;

/**
 * The Dice class contains two static methods for rolling dice.
 * It also includes a method for parsing a dice formula.
 */

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
    
    public static int parse(String expression, String numBuffer1, int location) {
        String numBuffer2 = "";
        if ( location >= expression.length() ) {
            return Integer.parseInt(numBuffer1);
        }
        if ( expression.charAt(location) == '+' ) {
            // add the buffer to the rest of the expression
            // dump the buffer in the process
            return Integer.parseInt(numBuffer1) + 
                   parse(expression, "", location + 1);
        }
        if ( expression.charAt(location) == '-' ) {
            // same as before, but with subtraction
            return Integer.parseInt(numBuffer2) - 
                   parse(expression, "", location + 1);
        }
        if ( expression.charAt(location) == 'd' ) {
            // read in the next number as the number of sides
            // up until a '+' or '-'
            ++location;
            while ( location < expression.length() &&
                    expression.charAt(location) != '+' &&
                    expression.charAt(location) != '-' ) {
                numBuffer2 += expression.charAt(location);
                ++location;
            }
            if ( location >= expression.length() ) {
                return roll(Integer.parseInt(numBuffer1), 
                       Integer.parseInt(numBuffer2));
            } else if ( expression.charAt(location) == '+' ) {
            // if it's a '+', roll the dice and add it to the rest
                return roll(Integer.parseInt(numBuffer1), 
                       Integer.parseInt(numBuffer2)) + 
                       parse(expression, "", location + 1);
            } else { // not a '+', must be a '-'
                return roll(Integer.parseInt(numBuffer1), 
                       Integer.parseInt(numBuffer2)) - 
                       parse(expression, "", location + 1);
            }
        }
        // doesn't meet any other condition, must be a digit
        // so add it to the numBuffer1 and then keep on checking
        return parse(expression, numBuffer1 + expression.charAt(location), location + 1);
    }
}