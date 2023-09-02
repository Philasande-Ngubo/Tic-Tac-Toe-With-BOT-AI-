/*The gui For Tic Tac Toe
 *author : Philasande Ngubo
 *Date   : 01-09-2023
 */
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 
 public class Play implements ActionListener{
 
 private JFrame frmPlay = new JFrame("Tic Tac Toe");
 private JLabel lblBack = new JLabel("←");
 private JLabel lblPlayer = new JLabel ("Turn: Player 1");
 private JLabel lblTitle = new JLabel();
 
 private JButton btn1    = new JButton("");
 private JButton btn2    = new JButton("");
 private JButton btn3    = new JButton("");
 private JButton btn4    = new JButton("");
 private JButton btn5    = new JButton("");
 private JButton btn6    = new JButton("");
 private JButton btn7    = new JButton("");
 private JButton btn8    = new JButton("");
 private JButton btn9    = new JButton("");
 private int player    ;
 private ImageIcon icon;
 private Game game;
 private Bot bot;
 
 private Play(){}
 public Play(String Mode){
   this.game = new Game();
   this.player = 1;
   frmPlay.setSize(600,550);
   frmPlay.setLocationRelativeTo(null);
   frmPlay.setResizable(false);
   frmPlay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frmPlay.setVisible(true);
   frmPlay.getContentPane().setBackground(new Color(192,192,192));
   frmPlay.setLayout(null);
   
   try{
    icon = new ImageIcon(getClass().getResource("picc.png"));
    frmPlay.setIconImage(icon.getImage());
   }
   catch(Exception e){}
   lblBack.setBounds(5,0,40,25);
   lblPlayer.setBounds(400,35,300,25);
   lblTitle.setBounds(170,2,300,30);
   lblTitle.setText(Mode);
   frmPlay.add(lblBack);
   frmPlay.add(lblPlayer);
   frmPlay.add(lblTitle);
   lblBack.setFont(new Font("Bernard MT",Font.BOLD,45));
   lblPlayer.setFont(new Font("SimSun",Font.PLAIN,20));
   lblTitle.setFont(new Font("SimSun",Font.BOLD,23));
   
   btn1.setBounds(105,90,130,130);
   btn2.setBounds(235,90,130,130);
   btn3.setBounds(365,90,130,130);
   btn4.setBounds(105,220,130,130);
   btn5.setBounds(235,220,130,130);
   btn6.setBounds(365,220,130,130);
   btn7.setBounds(105,350,130,130);
   btn8.setBounds(235,350,130,130);
   btn9.setBounds(365,350,130,130);
   
   Font game = new Font("Calisto MT",Font.ITALIC,50);
   btn1.setFont(game);
   btn2.setFont(game);
   btn3.setFont(game);
   btn4.setFont(game);
   btn5.setFont(game);
   btn6.setFont(game);
   btn7.setFont(game);
   btn8.setFont(game);
   btn9.setFont(game);
   
  
   frmPlay.add(btn1);
   frmPlay.add(btn2);
   frmPlay.add(btn3);
   frmPlay.add(btn4);
   frmPlay.add(btn5);
   frmPlay.add(btn6);
   frmPlay.add(btn7);
   frmPlay.add(btn8);
   frmPlay.add(btn9);
   
   btn1.addActionListener(this);
   btn2.addActionListener(this);
   btn3.addActionListener(this);
   btn4.addActionListener(this);
   btn5.addActionListener(this);
   btn6.addActionListener(this);
   btn7.addActionListener(this);
   btn8.addActionListener(this);
   btn9.addActionListener(this);
   
  lblBack.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                   new Menu();
                   frmPlay.setVisible(false); 
                }

            });
  if (Menu.getPlayer() == 1){
   bot = new Bot(Menu.getDifficulty());
  }
  }
  
  public void actionPerformed(ActionEvent e){
  
     int buttonClicked = 0;
     if (e.getSource() == btn1)
     {
       buttonClicked =1;
     }
     else if (e.getSource() == btn2)
     {
       buttonClicked =2;
     }  
     else if (e.getSource() == btn3)
     {
       buttonClicked =3;
     }
     
      else if (e.getSource() == btn4)
     {
       buttonClicked =4;
     }
     else if (e.getSource() == btn5)
     {
       buttonClicked =5;
     }
     else if (e.getSource() == btn6)
     {
       buttonClicked =6;
     }
     else if (e.getSource() == btn7)
     {
       buttonClicked =7;
     }
     else if (e.getSource() == btn8)
     {
       buttonClicked =8;
     }
     else
       {
       buttonClicked =9;
     }
     
     int move = 0 ;
     
     if (this.player == 1){
      game.playerOneMoved(buttonClicked);
     }
     else
     {
      game.playerTwoMoved(buttonClicked);
      
     }
     
     switch (Menu.getPlayer())
     {
      case 0:
        played();
        ((JButton) e.getSource()).setText(game.getMoveChar());
        ((JButton) e.getSource()).setEnabled(false);
        victoryCheck();
        break;
      case 1:
      played();
       ((JButton) e.getSource()).setText(game.getMoveChar());
       ((JButton) e.getSource()).setEnabled(false);
       victoryCheck();
       
       lblPlayer.setText("Turn: Bot ");
       move = bot.move(available(),game.getPlayer2(),game.getPlayer1());
       move = bot.move(available(),game.getPlayer2(),game.getPlayer1());
       click(move);
       game.playerTwoMoved(move);
       played();
       victoryCheck();
       lblPlayer.setText("Turn: You");
       this.player= 1;
      break;
     }
     
    }
  private void victoryCheck()
  {
   int Winner = game.Winner( available() );
   String Msg = "";
   switch (Winner){
   case 1:
     Msg = (Menu.getPlayer() == 0) ?"Player 1 won.":"You won.";
   break;
   case 2:
     Msg = (Menu.getPlayer() == 0) ?"Player 2 won.":"You lost.";
   break;
     
   case 3:
    Msg = "It's is a draw";
   break;
   }
   
   if (Winner > 0){
   
   String[] buttons = { "Replay", "Menu", "Quit"};
   int option = JOptionPane.showOptionDialog(null, Msg, "Ngubo TTC",
        2, 0, null, buttons, buttons[2]);
   if ( (option == -1) || (option == 1)){
    this.frmPlay.setVisible(false);
    new Menu();
   }
   if (option == 0){
   replay();
   }
   
   if (option == 2)
   {
    System.exit(0);
   }
   
  }
  }
  public void played()
  {

    if (this.player ==1 ){
     this.player = 2;
    }
    else
    {
     this.player =1;
    }
    lblPlayer.setText("Turn: Player "+Integer.toString(this.player));
  
  }
  public int[] available()
 {
  //Return the number of unclicked button
  int Count =0;
  
  if (btn1.getText().equals("")){
    Count++;  
  }
  if (btn2.getText().equals("")){
    Count++;  
  }
  if (btn3.getText().equals("")){
    Count++;  
  }  
  if (btn4.getText().equals("")){
    Count++;  
  }
  if (btn5.getText().equals("")){
    Count++;  
  }
  if (btn6.getText().equals("")){
    Count++;  
  }
  if (btn7.getText().equals("")){
    Count++;  
  }
  if (btn8.getText().equals("")){
    Count++;  
  }
  if (btn9.getText().equals("")){
    Count++;  
  } 
  
  int[] results = new int[Count];
  Count = 0;
  
  if (btn1.getText().equals("")){
    results[Count++] =1;  
  }
  if (btn2.getText().equals("")){
    results[Count++] =2;  
  }
  if (btn3.getText().equals("")){
    results[Count++] =3;  
  }  
  if (btn4.getText().equals("")){
    results[Count++] =4;  
  }
  if (btn5.getText().equals("")){
    results[Count++] =5;  
  }
  if (btn6.getText().equals("")){
    results[Count++] =6;  
  }
  if (btn7.getText().equals("")){
    results[Count++] =7;  
  }
  if (btn8.getText().equals("")){
    results[Count++] =8;  
  }
  if (btn9.getText().equals("")){
    results[Count++] =9;  
  }  
  
  int[] Returns = new int[results.length];
  
  for (int i =0 ; i < results.length ; i++){
   Returns[i]=results[i];
  }
  return results;   
 }
 private void click(int iButton){
 switch (iButton){
   case 1:
    btn1.setText(this.game.getMoveChar());
    btn1.setEnabled(false);
   break;
   case 2:
     btn2.setText(this.game.getMoveChar());
     btn2.setEnabled(false);
   break;
   case 3:
      btn3.setText(this.game.getMoveChar());
      btn3.setEnabled(false);
   break;
   case 4:
       btn4.setText(this.game.getMoveChar());
       btn4.setEnabled(false);
   break;
   case 5:
       btn5.setText(this.game.getMoveChar());
       btn5.setEnabled(false);
   break;
   case 6:
        btn6.setText(this.game.getMoveChar());
        btn6.setEnabled(false);
   break;
   case 7:
        btn7.setText(this.game.getMoveChar());
        btn7.setEnabled(false);
   break;
       
   case 8:
        btn8.setText(this.game.getMoveChar());
        btn8.setEnabled(false);
   break;
   case 9:
        btn9.setText(this.game.getMoveChar());
        btn9.setEnabled(false);
        
   break;

  }
 }
 private void replay()
 {
  this.lblPlayer.setText("Turn : Player 1");
  this.player = 1;
  btn1.setText("");
  btn1.setEnabled(true);
  btn2.setText("");
  btn2.setEnabled(true);
  btn3.setText("");
  btn3.setEnabled(true);
  btn4.setText("");
  btn4.setEnabled(true);
  btn5.setText("");
  btn5.setEnabled(true);
  btn6.setText("");
  btn6.setEnabled(true);
  btn7.setText("");
  btn7.setEnabled(true);
  btn8.setText("");
  btn8.setEnabled(true);
  btn9.setText("");
  btn9.setEnabled(true);
  game.reset();
 }
  
 }