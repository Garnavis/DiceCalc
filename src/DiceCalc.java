import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The main class of DiceCalc.  Contains code for displaying the calculator
 * and buttons.
 */

public class DiceCalc {
    
    static JTextField lcd = new JTextField();
    static DiceCalcListener listener = new DiceCalcListener();
    static JFrame frame;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    public static void addComponentsToPane(Container pane) {
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        Dimension buttonDim = new Dimension(50, 30);
        
        lcd.setPreferredSize(new Dimension(200, 30));
        lcd.setHorizontalAlignment(JTextField.TRAILING);
        lcd.setEditable(false);
        lcd.setFont(new Font("SansSerif", Font.PLAIN, 16));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        pane.add(lcd, c);
        
        button = new JButton("7");
        button.setActionCommand("7");
        button.setMnemonic(KeyEvent.VK_7);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button, c);
        
        button = new JButton("8");
        button.setActionCommand("8");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 1;
        pane.add(button, c);
        
        button = new JButton("9");
        button.setActionCommand("9");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 2;
        pane.add(button, c);
        
        button = new JButton("-");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 3;
        pane.add(button, c);
        
        button = new JButton("4");
        button.setActionCommand("4");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 0;
        c.gridy = 2;
        pane.add(button, c);
        
        button = new JButton("5");
        button.setActionCommand("5");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 1;
        pane.add(button, c);
        
        button = new JButton("6");
        button.setActionCommand("6");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 2;
        pane.add(button, c);
        
        button = new JButton("+");
        button.setActionCommand("+");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 3;
        pane.add(button, c);
        
        button = new JButton("1");
        button.setActionCommand("1");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 0;
        c.gridy = 3;
        pane.add(button, c);
        
        button = new JButton("2");
        button.setActionCommand("2");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 1;
        pane.add(button, c);
        
        button = new JButton("3");
        button.setActionCommand("3");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 2;
        pane.add(button, c);
        
        button = new JButton("d");
        button.setActionCommand("d");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 3;
        pane.add(button, c);
        
        button = new JButton("clr");
        button.setActionCommand("clr");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 0;
        c.gridy = 4;
        pane.add(button, c);
        
        button = new JButton("0");
        button.setActionCommand("0");
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 1;
        pane.add(button, c);
        
        button = new JButton("roll");
        button.setActionCommand("roll");
        button.setPreferredSize(new Dimension(100, 30));
        button.addActionListener(listener);
        c.gridx = 2;
        c.gridwidth = 2;
        pane.add(button, c);
    }
    
    private static void createAndShowGUI() {
        frame = new JFrame("Dice Calc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}