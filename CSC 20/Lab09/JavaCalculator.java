/*Sam Lee
  10/31/17
  CSC 20
  Lab #9
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaCalculator implements ActionListener {
   static boolean Number = true;
   static JTextField text;  
   static double operand1 = 0, operand2 = 0;
   static char operator = 0;
   public static void main(String[] args) {
      
      JFrame frame = new JFrame("Sam Lee's Java Calculator");
      Container contentPane = frame.getContentPane();
      contentPane.setLayout(new GridLayout(0,1));
      ActionListener AL = new JavaCalculator() ;
   
      JLabel label = new JLabel("CSC 20 Calculator", JLabel.CENTER);
      frame.getContentPane().add(label);
      text = new JTextField("0", 100);
      text.setHorizontalAlignment(4);
      text.addActionListener(AL);
      JButton button;
      contentPane.add(text);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel panel1 = new JPanel(new GridLayout(1,4,2,2)); 
      panel1.add(button = new JButton ("7")); button.addActionListener(AL);
      panel1.add(button = new JButton ("8")); button.addActionListener(AL);
      panel1.add(button = new JButton ("9")); button.addActionListener(AL);
      panel1.add(button = new JButton ("/")); button.addActionListener(AL);
      contentPane.add(panel1);
      
      JPanel panel2 = new JPanel(new GridLayout(1,4,2,2)); 
      panel2.add(button = new JButton ("4")); button.addActionListener(AL);
      panel2.add(button = new JButton ("5")); button.addActionListener(AL);
      panel2.add(button = new JButton ("6")); button.addActionListener(AL);
      panel2.add(button = new JButton ("*")); button.addActionListener(AL);
      contentPane.add(panel2);
      
      JPanel panel3 = new JPanel(new GridLayout(1,4,2,2)); 
      panel3.add(button = new JButton ("1")); button.addActionListener(AL);
      panel3.add(button = new JButton ("2")); button.addActionListener(AL);
      panel3.add(button = new JButton ("3")); button.addActionListener(AL);
      panel3.add(button = new JButton ("-")); button.addActionListener(AL);
      contentPane.add(panel3);
      
      JPanel panel4 = new JPanel(new GridLayout(1,2,2,2)); 
      panel4.add(button = new JButton ("0")); button.addActionListener(AL);
      contentPane.add(panel4); 
      
      JPanel panel5 = new JPanel(new GridLayout(1,2,2,2));
      panel5.add(button = new JButton (".")); button.addActionListener(AL);
      panel5.add(button = new JButton ("+")); button.addActionListener(AL);
      panel4.add(panel5);
      
      JPanel panel6 = new JPanel(new GridLayout(1,1,2,2));
      panel6.add(button = new JButton ("=")); button.addActionListener(AL);
      contentPane.add(panel6);
      
      JPanel panel7 = new JPanel(new GridLayout(1,1));
      panel7.add(button = new JButton ("C")); button.addActionListener(AL);
      panel6.add(panel7);
      
      frame.pack();
      frame.setSize(400,400);
      frame.setVisible(true);
   }  
   public void actionPerformed(ActionEvent e) {
      char c = e.getActionCommand().charAt(0); 
      double res = 0;
      switch(c) {
         case '0':
         case '.':
         case '1':
         case '2':
         case '3':
         case '4':
         case '5':
         case '6':
         case '7':
         case '8':
         case '9': 
            if(Number) {
               text.setText("" + c);
               Number = false;
            }
            else text.setText(text.getText() + "" + c);
            return;
         case '+': operand1 = Double.parseDouble(text.getText());
            Number = true;
            operator = '+';
            return;
         case '-': operand1 = Double.parseDouble(text.getText());
            Number = true;
            operator = '-';
            return;
         case '/': operand1 = Double.parseDouble(text.getText());
            Number = true;
            operator = '/';
            return;
         case '*': operand1 = Double.parseDouble(text.getText());
            Number = true;
            operator = '*';
            return;
         case '=': operand2 = Double.parseDouble(text.getText());
            switch (operator) {
               case '/': res = operand1/operand2;
                  break;
               case '+': res = operand1+operand2;
                  break;
               case '*': res = operand1*operand2;
                  break;
               case '-': res = operand1-operand2;
                  break;
            
            }
            text.setText("" + res);
            Number = true;
            return;
         case 'C': text.setText("0");
            Number = true;
            return;  
          
      }
      
      return;
   }
}
