package com.practice;

public class IslandProblem {


  public static void main(String[] args) {
    int[][] a={{1,0,0},
               {1,1,1},
               {1,0,0}};
    int row = a.length;
    int col = a[0].length;
    int isLand =0;
    for(int i=0;i<row;i++){
      for(int j=0;j<row;j++){
        isLand+= getIsland(a,i,j);
      }
    }
    System.out.println(isLand);
  }


  private static int getIsland(int[][] a, int i, int j){
    if(a[i][j] == 0){
      return 0;
    }
    else if(a[i][j]==1){
      if(isPartOfIsland(a,i,j)){
        a[i][j]=2;
        return 0;
      }
      else {
        a[i][j]=2;
        return 1;
      }
    }
    return 0;
  }

  private static boolean isPartOfIsland(int[][] a, int i, int j){
    if((i>0 && a[i-1][j]==2) || (i>0 && j>0 && a[i-1][j-1]==2) || (i>0 && j<a[0].length-1 && a[i-1][j+1]==2) || (j>0 && a[i][j-1]==2) ){
      return true;
    }
    else {
      return false;
    }
  }
}
