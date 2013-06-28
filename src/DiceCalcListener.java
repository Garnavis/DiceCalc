import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.InterruptedException;

public class DiceCalcListener implements ActionListener {
    private static boolean writingDie = false;
    private static boolean displayingResult = false;
    private static int result;
    private static String expression;
    
    /* Display a message if the dice formula is invalid. */
    private static void nope() {
        final String temp = DiceCalc.lcd.getText();
        DiceCalc.lcd.setText("nope");
        final JTextField lcd = DiceCalc.lcd;
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                } catch ( InterruptedException ie ) {
                DiceCalc.lcd.setText("ERROR");
                ie.printStackTrace();
                } finally {
                    lcd.setText(temp);
                }
            }
        }).start();
        
    }
    public void actionPerformed(ActionEvent e) {
        if ( "roll".equals(e.getActionCommand()) ) {
            if ( DiceCalc.lcd.getText().endsWith("d") ||
                 DiceCalc.lcd.getText().endsWith("+") ||
                 DiceCalc.lcd.getText().endsWith("-") ||
                 DiceCalc.lcd.getText().isEmpty() ) {
                nope();
                return;
            }
            if ( displayingResult ) {
                /* If the result is already being displayed, 
                   re-roll the expression from memory. */
                result = Dice.parse(expression, "", 0);
                DiceCalc.lcd.setText(Integer.toString(result));
                return;
            }
            expression = DiceCalc.lcd.getText();
            writingDie = false;
            displayingResult = true;
            result = Dice.parse(DiceCalc.lcd.getText(), "", 0);
            DiceCalc.lcd.setText(Integer.toString(result));
            return;
        } else if ( "clr".equals(e.getActionCommand()) ) {
            writingDie = false;
            displayingResult = false;
            DiceCalc.lcd.setText("");
            return;
        } else if ( "d".equals(e.getActionCommand()) ) {
            if ( DiceCalc.lcd.getText().endsWith("d") ||
                 DiceCalc.lcd.getText().endsWith("+") ||
                 DiceCalc.lcd.getText().endsWith("-") ||
                 DiceCalc.lcd.getText().isEmpty() ||
                 displayingResult ||
                 writingDie ) {
                nope();
                return;
            }
            DiceCalc.lcd.setText(DiceCalc.lcd.getText() + 'd');
            writingDie = true;
            return;
        } else if ( "+".equals(e.getActionCommand()) ||
                    "-".equals(e.getActionCommand()) ||
                    "0".equals(e.getActionCommand())) {
            if ( DiceCalc.lcd.getText().endsWith("d") ||
                 DiceCalc.lcd.getText().endsWith("+") ||
                 DiceCalc.lcd.getText().endsWith("-") ||
                 DiceCalc.lcd.getText().isEmpty() ||
                 displayingResult ) {
                nope();
                return;
            } else {
                writingDie = false;
                DiceCalc.lcd.setText(DiceCalc.lcd.getText() + e.getActionCommand());
                return;
            }
        } else { // doesn't meet any other condition, so it must be a digit
            // clear the screen if a result is being displayed
            if ( displayingResult ) DiceCalc.lcd.setText("");
            writingDie = false;
            displayingResult = false;
            DiceCalc.lcd.setText(DiceCalc.lcd.getText() + e.getActionCommand());
            return;
        }
    }
}