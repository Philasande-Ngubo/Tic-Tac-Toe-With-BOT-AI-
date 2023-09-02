/*The game class
 *author: Philasande Ngubo
 *Date: 02-august-2023
 */
public class Game
{
 private int[] PlayerTwo;
 private int nextFree2;
 private int[] PlayerOne;
 private int nextFree;
 private String moveChar;
 
 public Game()
{
 this.nextFree2 =0;
 this.nextFree =0;
 PlayerTwo =new int[5];
 PlayerOne = new int[5];
 this.moveChar="o";
 for (int i = 0 ;i < 5; i++ ){
 PlayerTwo[i]=0;
 PlayerOne[i]=0;
 }
}

 public int[] getPlayer2(){
  int[] playerTwoCopy = new int[this.nextFree2];
  for (int i = 0 ; i< this.nextFree2  ;i++)
  {
   playerTwoCopy[i] = this.PlayerTwo[i];  
  }
  return playerTwoCopy;
 }
 
 public int[] getPlayer1(){
 
  int[] playerOneCopy = new int[this.nextFree];
  for (int i = 0 ; i< this.nextFree  ;i++)
  {
   playerOneCopy[i] = this.PlayerOne[i];  
  }
  return playerOneCopy;
 }
 
 public void playerOneMoved(int move)
 {
  if ((move>9) || (nextFree>5))
  {
   throw new IllegalArgumentException("playerMoved: Invalid move");
  }
  else
  {
   this.PlayerOne[nextFree++] = move ;
  }
 }
 
 public void playerTwoMoved(int move)
 {
  if ((move>9) || (nextFree2>5))
  {
   throw new IllegalArgumentException("playerMoved: Invalid move");
  }
  else
  {
   try {
    this.PlayerTwo[nextFree2++] = move ;
   }
   catch(Exception e) {
   throw e;
   }
  }
 }
public String getMoveChar()
{
 String Results="o";
 if (this.moveChar.equals("o"))
 {
  this.moveChar="x";
  Results="x";
 }
 else
 {
  this.moveChar="o";
 }
 return Results;
}

public int Winner(int[] vacant){

 int Results = 0;
 if (won(1)){
  Results = 1;
 }
 if ( won(2) ){
  Results = 2;
 }
 if ( (Results == 0) && (vacant.length == 0)){
  Results = 3;
 }
 return Results;
}

private boolean won(int player){
 boolean Results = false ;
 switch (player){
 case 1 :
  Results = winning (PlayerOne);
 break;
 case 2:
  Results = winning (PlayerTwo);
 break;
 }
 return Results;
}

private boolean winning(int[] arrTemp){
 boolean Results = false;
 int Similar = 0;
 
 for (int j = 0; j < Bot.Wins.length ; j++){
  Similar = 0;
  for (int i = 0 ;i < 3 ; i++){
   if ( !(search(arrTemp,Bot.Wins[j][i])==-1) ){
   Similar++;
   }
  }
  if (Similar == 3){
    Results = true;
    break;
   }
    }
  return Results;  
 }
 
private int search(int[] arrTemp, int value){
     int Results = -1 ;
     for (int i = 0 ; i < arrTemp.length ; i++){
      if (arrTemp[i] ==value){
        Results = i;
        break;
      }
     }
     return Results;
   }
 public void reset(){
   this.nextFree2 =0;
   this.nextFree =0;
   PlayerTwo =new int[6];
 PlayerOne = new int[6];
 this.moveChar="O";
 for (int i = 0 ;i < 5; i++ ){
 PlayerTwo[i]=0;
 PlayerOne[i]=0;
 }
 } 

}