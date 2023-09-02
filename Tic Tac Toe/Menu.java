/*The graphic user menu class
 *author: Philasande Ngubo
 *Date: 02-august-2023
 */
//This form contains the UI Menu
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu implements ActionListener{
 private JFrame frmMenu = new JFrame("Menu");
 private JButton btnVersus = new JButton("Two player");
 private JButton btnSingle = new JButton("Single player");
 private JButton btnAbout = new JButton("About");
 private ImageIcon icon;
 private static  int Player;
 private static int Difficulty;
 
 public Menu(){
  //try setting Icon
  try{
    icon = new ImageIcon(getClass().getResource("picc.png"));
    frmMenu.setIconImage(icon.getImage());
   }
  catch (Exception e){}
  
  
  //set Frame
  frmMenu.setSize(300,400);
  frmMenu.setLocationRelativeTo(null);
  frmMenu.setResizable(false);
  frmMenu.setVisible(true);
  frmMenu.setLayout(null);
  frmMenu.getContentPane().setBackground(new Color(192,192,192));
  frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  btnVersus.setBounds(50,30,200,70);
  btnSingle.setBounds(50,130,200,70);
  btnAbout.setBounds(50,230,200,70);
  
  Font buttons = new Font("SimSun",Font.BOLD,20);
  btnVersus.setFont(buttons);
  btnSingle.setFont(buttons);
  btnAbout.setFont(buttons);
  
  btnVersus.addActionListener(this);
  btnSingle.addActionListener(this);
  btnAbout.addActionListener(this);
  
  frmMenu.add(btnVersus);
  frmMenu.add(btnSingle);
  frmMenu.add(btnAbout);

 }
 
 public void actionPerformed(ActionEvent e){
  if (e.getSource()== btnVersus){
       Player = 0;
       new Play("Two Player Mode");
       frmMenu.setVisible(false); 
    }
    
  if (e.getSource()== btnSingle){
       Player = 1;
       String[] buttons = { "Easy", "Medium ", "Hard"};
        Difficulty = JOptionPane.showOptionDialog(null, "Select Difficulty", "Ngubo TTC",
        2, 0, null, buttons, buttons[2]);
        

        
       if (Difficulty > -1){
         new Play("Single Player Mode");
         frmMenu.setVisible(false);         
        }
    }
    
  if (e.getSource()== btnAbout){
      new About();
    }
    
   }
   
 static public int getPlayer(){
  return Player;
 }
 
 static public int getDifficulty(){
 return Difficulty;
 }

 }