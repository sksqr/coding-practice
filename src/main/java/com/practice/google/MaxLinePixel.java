package com.practice.google;

public class MaxLinePixel {

  public static void main(String[] args) {
    int [][] mat = {{1,0,1,1},
                    {0,0,0,0},
                    {1,0,0,1}
                    };

    System.out.println(getMaxPixelLen(mat));
  }

  private static int getMaxPixelLen(int[][] mat){
    int max = 0;
    for(int i=0;i<mat.length;i++){
      for(int j=0; j<mat[0].length; j++){
        int tempMax1 = Math.max(maxLenHorizontal(mat,i,j),maxLenVertical(mat,i,j));
        int tempMax2 = Math.max(maxLenD1(mat,i,j),maxLenD2(mat,i,j));
        int tempMax = Math.max(tempMax1,tempMax2);
        max = Math.max(max,tempMax);
      }
    }
    return max;
  }

  private static int maxLenHorizontal(int [][] mat, int i, int j){
    int count=0;
    while (j< mat[0].length && mat[i][j]==1){
      count++;
      j++;
    }
    return count;
  }

  private static int maxLenVertical(int [][] mat, int i, int j){
    int count=0;
    while (i< mat.length && mat[i][j]==1){
      count++;
      i++;
    }
    return count;
  }

  private static int maxLenD1(int [][] mat, int i, int j){
    int count=0;
    while (i< mat.length && j<mat[0].length && mat[i][j]==1){
      count++;
      i++;
      j++;
    }
    return count;
  }

  private static int maxLenD2(int [][] mat, int i, int j){
    int count=0;
    while (i< mat.length && j<mat[0].length && mat[i][j]==1){
      count++;
      i++;
      j++;
    }
    return count;
  }




}
