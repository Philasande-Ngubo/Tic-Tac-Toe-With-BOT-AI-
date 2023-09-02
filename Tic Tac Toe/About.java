/* Author : Philasande Ngubo
 * Date :  23- August-2023
 *
 * About Frame Philasande
*/

import javax.swing.*;
import java.awt.*;
public class About
{
 private JFrame frmAbout = new JFrame("About");
 private JLabel lbl1 = new JLabel("Hi there, this program ");
 private JLabel lbl2 = new JLabel("was developed  by ");
 private JLabel lbl3= new JLabel("Philasande Ngubo");
 private JLabel lbl4 = new JLabel("bye."); 
 private Font font = new Font("Fenix",Font.BOLD,20);
 public About()
 {
  frmAbout.setVisible(true);
  frmAbout.setSize(450,450);
  frmAbout.setLocationRelativeTo(null);
  frmAbout.setResizable(false);
  frmAbout.setLayout(null);
   ImageIcon image;
   JLabel imageFrame;
   lbl1.setFont(font);
   lbl2.setFont(font);
   lbl3.setFont(font);
   lbl4.setFont(font);
  try
  {
   image = new ImageIcon(getClass().getResource("picc.png"));
   imageFrame = new JLabel(image);
   frmAbout.setIconImage(image.getImage());
   frmAbout.add(imageFrame);
   imageFrame.setBounds(100,20,250,250);
   frmAbout.getContentPane().setBackground(new Color(175,238,238));
  }
  catch (Exception e)
  {
  
  }
  Color color = new Color(0,47,167);
  lbl1.setBounds(120,270,300,25);
  lbl2.setBounds(120,295,300,25);
  lbl3.setBounds(120,320,300,25);
  lbl4.setBounds(120,345,300,25);
  
  lbl1.setForeground(color);
  lbl2.setForeground(color);
  lbl3.setForeground(color);
  lbl4.setForeground(color);
  
  frmAbout.add(lbl1);
  frmAbout.add(lbl2);
  frmAbout.add(lbl3);
  frmAbout.add(lbl4);
  
 }
}