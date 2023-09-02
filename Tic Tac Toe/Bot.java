/*The bot to simulate a tic tac toe player
 *author: Philasande Ngubo
 *date  : 02-August-2023
 */
import java.util.Random;
public class Bot{
private int Difficulty;
public static final int[][] Wins ={ {1,2,3} ,{4,5,6} ,{7,8,9} ,{1,4,7},
                                 {2,5,8} ,{3,6,9} ,{3,5,7} ,{1,5,9}};
public static final int[] corners ={1,3,7,9};
   
public Bot(int Level){
 this.Difficulty =Level;
}

public int move(int[] available, int[]  myMoves,int other[]){

int Results = -1 ;
switch (this.Difficulty){
case 0:
  //For this the bot just places randomly where there are vacant spaces
  // hoping to win (Just like a beginner)
  Random rand = new Random();
  int iTemp = rand.nextInt(available.length);
  Results = available[iTemp];
  break;
case 1:
 //Medium the bot actually analyses the game and places to win
  Results = medium(available,myMoves,other);
  break;
case 2:
  Results = hard(available,myMoves,other);
  break;

}
return Results; 
}
private int hard(int[] vacant ,int[] myMoves ,int[] Other ){
 // here the blocks and places in a manner to secure a win
 int Results = 0;
 if (vacant.length == 9){
    Random rand = new Random();
    Results= Bot.corners[rand.nextInt(4)];
  }
  else if (vacant.length == 8)
  {
   if ( ! (search(Bot.corners , Other[0]) == -1) )
   {
    Results = 5;
   }
   else
   {
    Random rand = new Random();
    Results = vacant[rand.nextInt(8)];
   }
  }
  else
  {
    if (! (shouldBlock(myMoves,vacant) == 0) ) {
     Results =shouldBlock(myMoves,vacant);
    }
    else if (! (shouldBlock(Other,vacant) == 0) ){
     Results = shouldBlock(Other,vacant);
    } 
    else
    {
     Results = smartMove(vacant,myMoves);
    } 
  }
  return Results;
}
private int medium(int[] vacant ,int[] myMoves ,int[] Other ){
 // at this point the bot just blocks and places randomly
 // and hopes for a win
 int Results =0; 
 if (vacant.length == 9){
    Random rand = new Random();
    Results= vacant[rand.nextInt(9)];
  }
 else{
 
   if (shouldBlock(Other ,vacant) ==  0){
     Random rand = new Random();
     Results= vacant[rand.nextInt(vacant.length)];
   }
   else
   {
    Results =shouldBlock(Other ,vacant);
   }
 }
 return Results;
}

 private int shouldBlock(int[] other , int[] vacant ){
 // looks at the at the players move to see whether to block or not
 int Results = 0;
 int Similar;
 int[] arrTemp = new int[3];
 int Count;  
  for (int j =0 ; j < Bot.Wins.length ; j++)
 {
   initialiseIntArray(arrTemp,0);
   Similar = 0;
   Count =0;
   for ( int i =0 ; i < 3 ; i++){
    
    if ( ! (search(other,Bot.Wins[j][i]) ==-1 ) ){
     Similar++;
     arrTemp[Count++] = Bot.Wins[j][i];
     
    }    
   }
   
   if (Similar == 2){
    int Temp = -1;
    for (int i = 0 ; i < 3 ;i++){
       if (  search(other ,Bot.Wins[j][i]) == -1 ){
       Temp =Bot.Wins[j][i]; 
       if ( search(vacant,Temp) > -1){
         Results =Temp;
         break;
       }
     }
    }
     
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
   
private void initialiseIntArray( int[] array , int vaule){
  // initialise all vaules of the int array to same vaule
  for (int i =0 ; i < array.length;i++){
   array[i] = vaule;
  }
}

private int countMoves(int[] arrTemp){

 int Moves = 5;
 for (int i : arrTemp){
  if ( i== 0){
   Moves-=1;
  }
 }
 return Moves; 
}
public int smartMove(int[] vacant , int[] myMoves){
 Random rand = new Random();
 int Results = vacant[rand.nextInt(vacant.length)];
 return Results;
}
}