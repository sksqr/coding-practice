package com.practice.backtracking;

import java.util.Arrays;

public class GraphColoring {

  public static void main(String[] args) {
    int graphMatrix[][] = {
        { 0, 1, 1, 1 },
        { 1, 0, 1, 0 },
        { 1, 1, 0, 1 },
        { 1, 0, 1, 0 },
    };
    int m = 3; // Number of colors
    int [] colors = new int[graphMatrix.length];
    Arrays.fill(colors, 0);

    System.out.println(isPossible(graphMatrix,m,colors,0));

  }

  private static boolean isPossible(int[][] mat, int totalColor, int[] colors, int v){
    if(v == mat.length){
      return true;
    }
    for(int i=1;i<=totalColor;i++){

      if(isItSafeToColor(v,mat,i,colors)){
        colors[v] = i;
        if(isPossible(mat,totalColor,colors,v+1)){
          return true;
        }
          colors[v] =0;
      }

    }
    return false;
  }



  private static boolean isItSafeToColor(int v, int[][] mat, int c, int[] colors){
    for(int i=0;i<mat.length;i++){
      if(mat[v][i]==1 && colors[i]==c){
        return false;
      }
    }
    return true;
  }

}
