package com.practice.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
  int i;
  int j;

  Pair(int a, int b){
    i=a;
    j=b;

  }
}

public class RiverSizes {

  public static void main(String[] args) {
    int[][] mat= {
        {1,1,1,1},
        {1,1,1,1},
        {1,1,0,1}
    };
    System.out.println(riverSizes(mat));
  }
  private static boolean isValid(int i, int j, int row, int col){
    if(i<0 || i>row-1){
      return false;
    }
    if(j<0 || j>col-1){
      return false;
    }
    return true;
  }
  public static List<Integer> riverSizes(int[][] matrix) {
    // Write your code here.
    int row= matrix.length;
    int col= matrix[0].length;
    int[][] visited = new int[row][col];
    for(int i=0; i<row; i++){
      for(int j=0; j<col; j++){
        visited[i][j]=0;
      }
    }
    List<Integer> result= new ArrayList<Integer>();
    for(int i=0; i<row; i++){
      for(int j=0; j<col; j++){
        if(matrix[i][j]==1 && visited[i][j]==0){
          int count=0;
          Stack<Pair> stack = new Stack<Pair>();
          stack.add(new Pair(i,j));
          visited[i][j]=1;
          while(!stack.isEmpty()){
            Pair p = stack.pop();
            count++;
            int i1= p.i-1;
            int j1= p.j;
            if(isValid(i1,j1,row,col) && matrix[i1][j1]==1 && visited[i1][j1]==0){
              stack.add(new Pair(i1,j1));
              visited[i1][j1]=1;
            }
            i1= p.i+1;
            j1= p.j;
            if(isValid(i1,j1,row,col) && matrix[i1][j1]==1 && visited[i1][j1]==0){
              stack.add(new Pair(i1,j1));
              visited[i1][j1]=1;
            }
            i1= p.i;
            j1= p.j-1;
            if(isValid(i1,j1,row,col) && matrix[i1][j1]==1 && visited[i1][j1]==0){
              stack.add(new Pair(i1,j1));
              visited[i1][j1]=1;
            }
            i1= p.i;
            j1= p.j+1;
            if(isValid(i1,j1,row,col) && matrix[i1][j1]==1 && visited[i1][j1]==0){
              stack.add(new Pair(i1,j1));
              visited[i1][j1]=1;
            }
          }
          if(count>0){
            result.add(count);
          }
        }
      }
    }
    return result;
  }
}

