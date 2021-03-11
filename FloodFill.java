import java.util.*;
import java.io.*;
public class FloodFill{
  public static void main(String []args)throws Exception{
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    int m=s.nextInt();
    int [][]arr=new int[n][m];
    for(int i=0;i<arr.length;i++){
      for(int j=0;j<arr[0].length;j++){
        arr[i][j]=s.nextInt();
      }
    }
    //created visited array for marking the path you visited 
    boolean [][]visited=new int [n][m];
    floodfill(arr,0,0," ",visited);
  }
  public static void floodfill(int [][]maze,int row,int col,String ans,boolean [][]visited)
  {
    if(row<0 || col<0 || row==maze.length || col==maze[0].length || maze[row][col]==1 || visited[row][col]==true)
    {
      return;
    }
    if(row==maze.length-1 && col==maze[0].length-1)
    {
      System.out.println(ans);
      return;
    }
    visited[row][col]=true;  //first make visited array true 
    floodfill(maze,row-1,col,ans+'t',visited);   //when we move top row decrease
    floodfill(maze,row,col-1,ans+'l',visited);   //when we move left col decrease
    floodfill(maze,row+1,col,ans+'d',visited);    //when we move down  row incerase 
    floodfill(maze,row,col+1,ans+'r',visited);    //when we move right col incerase 
    visited[row][col]=false;  //when we completed all tldr then unmarked that box so we can find another path also
  }
}
