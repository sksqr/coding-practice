package com.practice.backtracking;

import java.util.Arrays;

public class NQueen {

  public static void main(String[] args) {
    solutionOfNqueen(3);
  }


  private static void solutionOfNqueen(int n){
    int[][] mat = new int[n][n];
    int count=0;
    for (int i=0;i<n;i++){
      Arrays.fill(mat[i],0);
    }
    System.out.println(isPossible(count,n,mat,0));


  }

  private static boolean isPossible(int count, int n, int[][] mat,int i){
    if(count==n){
      return true;
    }
    for(;i<n;i++){
      for(int j=0; j<n ;j++){
        if(isSafe(i,j,mat,n)){
          mat[i][j]=1;
          count++;
          if(!isPossible(count,n,mat,i+1)){
            mat[i][j]=0;
            count--;
          }
          else {
            return true;
          }
        }
      }
    }
    return false;
  }






  private static boolean isSafe(int i, int j, int[][] mat, int n){
    //same row
    for(int k=0;k<n; k++){
      if(mat[i][k] == 1){
        return false;
      }
    }
    //same column
    for(int k=0;k<n; k++){
      if(mat[k][j] == 1){
        return false;
      }
    }
    //left to right diagonal
    int k=i;
    int l=j;
    while (k>=0 && l>=0){
      if(mat[k][l] == 1){
        return false;
      }
      k--; l--;
    }
    k=i; l=j;
    while (k<n && l<n){
      if(mat[k][l] == 1){
        return false;
      }
      k++; l++;
    }


    //right to left diagonal
    k=i;
    l=j;
    while (k<n && l>=0){
      if(mat[k][l] == 1){
        return false;
      }
      k++; l--;
    }
    k=i; l=j;
    while (k>=0 && l<n){
      if(mat[k][l] == 1){
        return false;
      }
      k--; l++;
    }
    return true;
  }

}
