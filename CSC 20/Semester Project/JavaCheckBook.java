/*Sam Lee
  10/31/17
  CSC 20
  Semester Project
  Java Checkbook
*/

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;


public class JavaCheckBook implements ActionListener {
   //The global variables
   static String[] bankStrings = {"Deposit", "Automatic Deposit", "ATM Withdrawl", "Check", "Debit"};
   static JTable table, table1;
   static String create, accountname, input;
   static double initialbalance, depcred, paydeb,inibal, finbal;
   static CardLayout contentPaneLayout;
   static Container contentPane;
   static JTextField text, text1, text2,text3, text4, text5, text6, 
                     text7, text8, text9, text10; 
   static JFrame frame;
   static JLabel label, label1, label2, label3, label4, label5, 
                 label6, label7, label8, label9, label10, label11, label12, label13, 
                 label14, label15, label16, label17, label18, label19, label20, label21, 
                 label22, label23, label24, label25, label26, 
                 label27, label28, label29, label30, label31, label32, label33;
   static JPanel panel, panel1, panel2, panel3, panel4, panel5, panel6, 
                 panel7, panel8, panel9, panel10, panel11, panel12, panel13, panel14, 
                 panel15, panel16, panel17, panel18, panel19, panel20, panel21, panel22, 
                 panel23, panel24, panel25, panel26, panel27, panel28, panel29, panel30, panel31,
                 panel32, panel33;
   static JButton CreateANewAccountButton, LoadTransFromAFileButton, LoadButton, AddNewTransactionsButton, SearchTransactionsButton, 
                  SearchButton1, SortTransactionsButton, SortButton, ViewDeleteTransactionsButton, SaveTransToFileButton, 
                  ExitButton, CreateButton, CancelButton, CancelButton1, CancelButton2, 
                  TopMenuButton, TopMenuButton1, TopMenuButton2, TopMenuButton3, 
                  SaveNewTransactionButton, DeleteSelectedButton;
   static JScrollPane scrollPane, scrollPane1;
   static String[] columnName = {"Data", "Trans. Type", "Check No.", "Trans. Description", "Payment/Debit(+)", "Deposit/Credit(-)", "Balance"};
   static Transaction[] ta = new Transaction[100];
   static String[][] data1 = new String[100][100];  
   static int tnumber = 0;
   static double bal;
   static JComboBox <String> bankOptions;
   static FileOutputStream fileoutputstream;  
   static ObjectOutputStream objectoutputstream;   
   static ObjectInputStream objectinputstream;
   
   public static void main(String[] args) throws IOException {
   
      //The layout for the CheckBook
      frame = new JFrame("Checkbook");
      contentPane = frame.getContentPane();
      contentPane.setLayout(contentPaneLayout = new CardLayout());
      ActionListener AL = new JavaCheckBook();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Window 1
      panel1 = new JPanel(new BorderLayout());
      label = new JLabel("<html><font size = 5>Use Buttons Below To Manage Transactions</html>", JLabel.CENTER);
      panel1.add(label, BorderLayout.NORTH);
      
      panel2 = new JPanel(new FlowLayout());
      label1 = new JLabel("Account Name: ");
      panel2.add(label1);
      text = new JTextField(10);
      text.setEditable(false);
      panel2.add(text);
    
      label2 = new JLabel("Balance: ");
      panel2.add(label2);
      text1 = new JTextField(10);
      text1.setEditable(false);  
      panel2.add(text1);
      panel1.add(panel2, BorderLayout.CENTER);
     
        
      //The Buttons for the main window      
      panel3 = new JPanel(new GridLayout(2,2,4,4)); 
      panel3.add(CreateANewAccountButton = new JButton ("Create A New Account")); CreateANewAccountButton.addActionListener(AL);
      panel3.add(LoadTransFromAFileButton = new JButton ("Load Trans From A File")); LoadTransFromAFileButton.addActionListener(AL);
      panel3.add(AddNewTransactionsButton = new JButton ("Add New Transactions")); AddNewTransactionsButton.addActionListener(AL);
      panel3.add(SearchTransactionsButton = new JButton ("Search Transactions")); SearchTransactionsButton.addActionListener(AL);
      panel3.add(SortTransactionsButton = new JButton ("Sort Transactions")); SortTransactionsButton.addActionListener(AL);
      panel3.add(ViewDeleteTransactionsButton = new JButton ("View/Delete Transactions")); ViewDeleteTransactionsButton.addActionListener(AL);
      panel3.add(SaveTransToFileButton = new JButton ("Save Trans To File")); SaveTransToFileButton.addActionListener(AL);
      panel3.add(ExitButton = new JButton ("Exit")); ExitButton.addActionListener(AL);
      panel1.add(panel3, BorderLayout.SOUTH);
      contentPane.add("Card 1", panel1);
      contentPaneLayout.show(contentPane, "Card 1");
         
      //Window #2
      panel4 = new JPanel(new BorderLayout());
      label3 = new JLabel("<html><font size = 5>Create A New Account</html>", JLabel.CENTER);
      panel4.add(label3, BorderLayout.NORTH);
      
      panel5 = new JPanel(new GridLayout(0,1));
      panel6 = new JPanel(new FlowLayout());
      label4 = new JLabel("Account Name: ");
      panel6.add(label4);
      text2 = new JTextField("", 10);
      panel6.add(text2);
      panel5.add(panel6);
      
      panel7 = new JPanel(new FlowLayout());
      label5 = new JLabel("Initial Balance: ");
      panel7.add(label5);
      text3 = new JTextField("", 10);
      panel7.add(text3);
      panel5.add(panel7);
      
      panel4.add(panel5, BorderLayout.CENTER);
          
      panel8 = new JPanel(new FlowLayout());
      panel8.add(CreateButton = new JButton ("Create")); CreateButton.addActionListener(AL);
      panel8.add(CancelButton = new JButton ("Cancel")); CancelButton.addActionListener(AL);
      panel4.add(panel8, BorderLayout.SOUTH);
      contentPane.add("Card 2", panel4);
      
      //Window #3
      panel8 = new JPanel(new BorderLayout());
      label6 = new JLabel("<html><font size = 5>Load Transactions To File</html>", JLabel.CENTER);
      panel8.add(label6, BorderLayout.NORTH);
      
      panel9 = new JPanel(new GridLayout(0,1));
      panel9.add(new JLabel(""));
      panel10 = new JPanel(new FlowLayout());
      label10 = new JLabel("Account Name: ");
      panel10.add(label10);
      text4 = new JTextField("", 10);
      panel10.add(text4);
      panel9.add(panel10);
      panel8.add(panel9, BorderLayout.CENTER);
      panel9.add(new JLabel(""));
         
      panel11 = new JPanel(new FlowLayout());
      panel11.add(LoadButton = new JButton ("Load")); LoadButton.addActionListener(AL);
      panel11.add(CancelButton2 = new JButton ("Cancel")); CancelButton2.addActionListener(AL);
      panel8.add(panel11, BorderLayout.SOUTH);
      contentPane.add("Card 3", panel8);
      
      //Window 6
      panel12 = new JPanel(new GridLayout(0,1));
      label11 = new JLabel("<html><font size = 5>Sort Transactions</html>", JLabel.CENTER);
      panel12.add(label11);
            
      JRadioButton TypeRadioButton = new JRadioButton("By Type"); 
      JRadioButton DateRadioButton = new JRadioButton("By Date");
               
      ButtonGroup group = new ButtonGroup();
      group.add(TypeRadioButton);
      group.add(DateRadioButton);
      
      JPanel panel15 = new JPanel(new FlowLayout());      
      panel15.add(TypeRadioButton);
      panel15.add(DateRadioButton);
      
      panel12.add(panel15);
      panel12.add(new JLabel(""));
      panel12.add(new JLabel(""));
      panel12.add(new JLabel(""));
    
      panel16 = new JPanel(new FlowLayout());
      panel16.add(SortButton = new JButton ("Sort")); SortButton.addActionListener(AL);
      panel16.add(TopMenuButton = new JButton ("Top Menu")); TopMenuButton.addActionListener(AL);
      panel12.add(panel16);
      contentPane.add("Card 5", panel12);
      
      //Window #4
      panel23 = new JPanel(new BorderLayout());
      panel18 = new JPanel(new GridLayout(0,2));
      label12 = new JLabel("Date", JLabel.RIGHT);
      panel18.add(label12);
      text5 = new JTextField("", 25);
      panel18.add(text5);
      panel23.add(panel18, BorderLayout.EAST);
      
      label13 = new JLabel("Trans. Type", JLabel.RIGHT);
      panel18.add(label13); 
      bankOptions = new JComboBox <String> (bankStrings);       
      panel18.add(bankOptions);
      
      label14 = new JLabel("Check No.", JLabel.RIGHT);
      panel18.add(label14);
      text6 = new JTextField("", 25);
      panel18.add(text6);
      
      label21 = new JLabel("Trans. Description", JLabel.RIGHT);
      panel18.add(label21);
      text10 = new JTextField("", 25);
      panel18.add(text10);
      
      label15 = new JLabel("Payment/Debit(-)", JLabel.RIGHT);
      panel18.add(label15);
      text7 = new JTextField("", 25);
      panel18.add(text7);
      
      label16 = new JLabel("Deposit/Credit(+)", JLabel.RIGHT);
      panel18.add(label16);
      text8 = new JTextField("", 25);
      panel18.add(text8);
        
      panel17 = new JPanel(new FlowLayout());
      panel17.add(SaveNewTransactionButton = new JButton ("Save New Transaction"));SaveNewTransactionButton.addActionListener(AL);
      panel17.add(TopMenuButton1 = new JButton ("Top Menu"));TopMenuButton1.addActionListener(AL);
   
      panel23.add(panel17, BorderLayout.SOUTH);
      contentPane.add("Card 4", panel23);
            
      //Window #5
      panel24 = new JPanel(new BorderLayout());
      label18 = new JLabel("Search Transactions By Transaction Date/Type/Check No./Description", JLabel.CENTER);
      panel24.add(label18, BorderLayout.NORTH);
      
      scrollPane = new JScrollPane();
      String[][] data = new String[0][0];
      table = new JTable(data,columnName); 
      JScrollPane tmp = new JScrollPane(table); 
      scrollPane.setViewport(tmp.getViewport());
      panel24.add(scrollPane, BorderLayout.CENTER); 
      
      panel27 = new JPanel(new GridLayout(0,1));
      panel26 = new JPanel(new FlowLayout());
      label19 = new JLabel("Search tloadring: ");
      panel26.add(label19);
      text9 = new JTextField("", 20);
      panel26.add(text9);
      panel27.add(panel26);
         
      panel25 = new JPanel(new FlowLayout());
      panel25.add(SearchButton1 = new JButton ("Search")); SearchButton1.addActionListener(AL);
      panel25.add(TopMenuButton2 = new JButton ("Top Menu")); TopMenuButton2.addActionListener(AL);
      panel27.add(panel25);
      panel24.add(panel27, BorderLayout.SOUTH);
      contentPane.add("Card 6", panel24);
        
      //Window #7
      panel29 = new JPanel(new BorderLayout());
      label20 = new JLabel("Transactions Currently In The Checkbook", JLabel.CENTER);
      panel29.add(label20, BorderLayout.NORTH);
      
      scrollPane1 = new JScrollPane();
      String[][] data1 = new String[0][0];
      table1 = new JTable(data1,columnName); 
      JScrollPane tmp1 = new JScrollPane(table1); 
      scrollPane1.setViewport(tmp1.getViewport());
      panel29.add(scrollPane1, BorderLayout.CENTER); 
      
      panel30 = new JPanel(new FlowLayout());
      panel30.add(DeleteSelectedButton = new JButton ("DeleteSelected")); DeleteSelectedButton.addActionListener(AL);
      panel30.add(TopMenuButton3 = new JButton ("Top Menu")); TopMenuButton3.addActionListener(AL);
      panel29.add(panel30, BorderLayout.SOUTH);
      contentPane.add("Card 7", panel29);
         
      //The end part of the JFrame
      frame.pack();
      frame.setSize(640,240);
      frame.setVisible(true);
   
   }
   
   public void actionPerformed(ActionEvent e) {
      Object click = e.getSource();
      
      if(click == CreateANewAccountButton) {
         contentPaneLayout.show(contentPane, "Card 2");
         return;
      }
      
      if(click == CreateButton) {
         input = text2.getText();
         text.setText(input);
         initialbalance = Double.parseDouble(text3.getText());
         text1.setText("" + initialbalance);
         Transaction t1 = new Transaction();
         t1.transactiontype = 0;
         t1.transactiondescription = "initialbalance";
         t1.amount = initialbalance;
         ta[0] = t1;
         tnumber = 1;
         contentPaneLayout.show(contentPane, "Card 1");
         return;
      }
      
      if(click == LoadTransFromAFileButton) {
         contentPaneLayout.show(contentPane, "Card 3");
         return;
      }
      
      if(click == LoadButton) {
         Transaction tload;
         try {
            tnumber = 0;
            bal = 0;
            
            objectinputstream = new ObjectInputStream(new FileInputStream("input"));
            while (true) {
               tload = (Transaction)objectinputstream.readObject();
               ta[tnumber] = tload;
               if(tload.transactiontype <= 1) {
                  bal += tload.amount;
               }
               else {
                  bal -= tload.amount;
               }
               tnumber++;
            }
         } catch(EOFException e1){
         } catch(Exception e2)
         { e2.printStackTrace();
         }
         text.setText(text4.getText());
         text1.setText("" + bal);
         return;
      }
      
      if(click == AddNewTransactionsButton) {
         contentPaneLayout.show(contentPane, "Card 4");    
         return;
      }
      
      if(click == SaveNewTransactionButton) {
          
         Transaction t = new Transaction();
         t.date = text5.getText();
         text5.setText("");
         t.transactiontype = bankOptions.getSelectedIndex();
         t.transactiondescription = text10.getText();
         if(t.transactiontype == 3) {
            t.checknumber = (int) Double.parseDouble(text6.getText());
         }
         if(t.transactiontype <= 1) { 
            t.amount = Double.parseDouble(text8.getText());
         } 
         else {
            t.amount = Double.parseDouble(text7.getText());
         } 
         ta[tnumber++] = t;
         text8.setText("");
         text7.setText("");
         text6.setText("");
         text10.setText("");
               
         return;
      }
      
      if(click == SortTransactionsButton) {
         contentPaneLayout.show(contentPane, "Card 5");      
         return;
      }
      
      if(click == SearchTransactionsButton) {
         contentPaneLayout.show(contentPane, "Card 6");      
         return;
      }
      
      if(click == ViewDeleteTransactionsButton) {
         data1 = new String[tnumber][7];
         for (int i = 0; i < tnumber; i++) {
            data1[i][0] = ta[i].date + "";
            data1[i][1] = bankStrings[ta[i].transactiontype];
            data1[i][2] = ta[i].checknumber + "";
            data1[i][3] = ta[i].transactiondescription + "";
            
            if(ta[i].transactiontype <= 1) {
               data1[i][4] = "";
               data1[i][5] = "" + ta[i].amount;
            
            }
            else {
               data1[i][5] = "";
               data1[i][4] = "" + ta[i].amount;
            } 
         
            data1[i][6] = ta[i].amount + "";
         }
     
         table1 = new JTable(data1, columnName);
         JScrollPane tmp1 = new JScrollPane(table1);
         scrollPane1.setViewport(tmp1.getViewport());
         contentPaneLayout.show(contentPane, "Card 7");      
         return;
      }
      
      if(click == DeleteSelectedButton) {
         int del = table1.getSelectedRow();
         for (int k = del; k < tnumber - 1; ++k) {
            ta[k] = ta[k+1];
         }
         
         tnumber--;
         data1 = new String[tnumber][7];
         for (int i = 0; i < tnumber; i++) {
            data1[i][0] = ta[i].date + "";
            data1[i][1] = ta[i].transactiontype + "";
            data1[i][2] = ta[i].checknumber + "";
            data1[i][3] = ta[i].transactiondescription + "";
            data1[i][4] = ta[i].paymentdebit + "";
            data1[i][5] = ta[i].depositcredit + "";
            data1[i][6] = ta[i].amount + "";
         }
         table1 = new JTable(data1, columnName);
         JScrollPane tmp1 = new JScrollPane(table1);
         scrollPane1.setViewport(tmp1.getViewport());
         contentPaneLayout.show(contentPane, "Card 7");      
         return;
      }
      
      if(click == SaveTransToFileButton) {
         try {	FileOutputStream fileoutputstream = new FileOutputStream (text.getText(), false);
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(fileoutputstream);
            for (int q = 0; q < tnumber; q++) {
               objectoutputstream.writeObject(ta[q]);
            }
            objectoutputstream.close();
         } catch(FileNotFoundException e1){ System.out.println(e1.toString());
         } catch(IOException e1){ e1.printStackTrace();}
         return;
      }
      
      if(click == CancelButton) {
         contentPaneLayout.show(contentPane, "Card 1");      
         return;
      }
      
      if(click == CancelButton1) {
         contentPaneLayout.show(contentPane, "Card 1");      
         return;
      }
   
      if(click == CancelButton2) {
         contentPaneLayout.show(contentPane, "Card 1");      
         return;
      }
      
      if(click == TopMenuButton) { 
         contentPaneLayout.show(contentPane, "Card 1");      
         return;
      }
      
      if(click == TopMenuButton1) { 
         contentPaneLayout.show(contentPane, "Card 1");      
         return;
      }
   
      if(click == TopMenuButton2) { 
         contentPaneLayout.show(contentPane, "Card 1");      
         return;
      }
   
      if(click == TopMenuButton3) { 
         contentPaneLayout.show(contentPane, "Card 1");      
         return;
      }
      
      if(click.equals(ExitButton)) {
         System.exit(0);
      }           
      return;
   }
}
class Transaction implements Serializable {String date; int checknumber; 
   int transactiontype; String transactiondescription; 
   int paymentdebit; int depositcredit; double amount;}