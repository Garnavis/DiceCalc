import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * For each component added to the container...
 * Create the component...
 * Set instance variables in the GridBagConstraints instance (c)...
 * pane.add(theComponent, c);
 *
 * Other possible die types:
 * Median: 2 3 3 4 4 5
 * Fudge: + + 0 0 - -
 * 
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
        // button.setMnemonic(KeyEvent.VK_8);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 1;
        pane.add(button, c);
        
        button = new JButton("9");
        button.setActionCommand("9");
        // button.setMnemonic(KeyEvent.VK_9);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 2;
        pane.add(button, c);
        
        button = new JButton("-");
        button.setActionCommand("-");
        // button.setMnemonic(KeyEvent.VK_MINUS);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 3;
        pane.add(button, c);
        
        button = new JButton("4");
        button.setActionCommand("4");
        // button.setMnemonic(KeyEvent.VK_4);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 0;
        c.gridy = 2;
        pane.add(button, c);
        
        button = new JButton("5");
        button.setActionCommand("5");
        // button.setMnemonic(KeyEvent.VK_5);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 1;
        pane.add(button, c);
        
        button = new JButton("6");
        button.setActionCommand("6");
        // button.setMnemonic(KeyEvent.VK_6);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 2;
        pane.add(button, c);
        
        button = new JButton("+");
        button.setActionCommand("+");
        // button.setMnemonic(KeyEvent.VK_PLUS);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 3;
        pane.add(button, c);
        
        button = new JButton("1");
        button.setActionCommand("1");
        // button.setMnemonic(KeyEvent.VK_1);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 0;
        c.gridy = 3;
        pane.add(button, c);
        
        button = new JButton("2");
        button.setActionCommand("2");
        // button.setMnemonic(KeyEvent.VK_2);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 1;
        pane.add(button, c);
        
        button = new JButton("3");
        button.setActionCommand("3");
        // button.setMnemonic(KeyEvent.VK_3);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 2;
        pane.add(button, c);
        
        button = new JButton("d");
        button.setActionCommand("d");
        // button.setMnemonic(KeyEvent.VK_D);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 3;
        pane.add(button, c);
        
        button = new JButton("clr");
        button.setActionCommand("clr");
        // button.setMnemonic(KeyEvent.VK_BACK_SPACE);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 0;
        c.gridy = 4;
        pane.add(button, c);
        
        button = new JButton("0");
        button.setActionCommand("0");
        // button.setMnemonic(KeyEvent.VK_0);
        button.setPreferredSize(buttonDim);
        button.addActionListener(listener);
        c.gridx = 1;
        pane.add(button, c);
        
        button = new JButton("roll");
        button.setActionCommand("roll");
        // button.setMnemonic(KeyEvent.VK_ENTER);
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