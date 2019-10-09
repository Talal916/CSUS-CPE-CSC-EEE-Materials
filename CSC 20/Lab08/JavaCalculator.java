/*Sam Lee
  10/31/17
  CSC 20
  Lab #8
*/

import javax.swing.*;
import java.awt.*;

public class JavaCalculator {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Sam Lee's Java Calculator");
      Container contentPane = frame.getContentPane();
      contentPane.setLayout(new GridLayout(0,1));
      JLabel label = new JLabel("CSC 20 Calculator", JLabel.CENTER);
      frame.getContentPane().add(label);
      JTextField text = new JTextField("0", 100);
      text.setHorizontalAlignment(4);
      contentPane.add(text);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel panel1 = new JPanel(new GridLayout(1,4,2,2)); 
      panel1.add(new JButton ("7"));
      panel1.add(new JButton ("8"));
      panel1.add(new JButton ("9"));
      panel1.add(new JButton ("/"));
      contentPane.add(panel1);
      
      JPanel panel2 = new JPanel(new GridLayout(1,4,2,2)); 
      panel2.add(new JButton ("4"));
      panel2.add(new JButton ("5"));
      panel2.add(new JButton ("6"));
      panel2.add(new JButton ("*"));
      contentPane.add(panel2);
      
      JPanel panel3 = new JPanel(new GridLayout(1,4,2,2)); 
      panel3.add(new JButton ("1"));
      panel3.add(new JButton ("2"));
      panel3.add(new JButton ("3"));
      panel3.add(new JButton ("-"));
      contentPane.add(panel3);
      
      JPanel panel4 = new JPanel(new GridLayout(1,2,2,2)); 
      panel4.add(new JButton ("0"));
      contentPane.add(panel4); 
      
      JPanel panel5 = new JPanel(new GridLayout(1,2,2,2));
      panel5.add(new JButton ("."));
      panel5.add(new JButton ("+"));
      panel4.add(panel5);
      
      JPanel panel6 = new JPanel(new GridLayout(1,1,2,2));
      panel6.add(new JButton ("="));
      contentPane.add(panel6);
      
      JPanel panel7 = new JPanel(new GridLayout(1,1));
      panel7.add(new JButton ("C"));
      panel6.add(panel7);
      
      frame.pack();
      frame.setSize(400,400);
      frame.setVisible(true);
   }  
}
