package com.practice.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

enum Dir {
  UP,DOWN,LEFT,RIGHT;
}
public class SurroundedRegions {


  public static void main(String[] args) {
    char[][] board ={
        {'X','X','X','X'},
        {'X','O','O','X'},
        {'X','X','O','X'},
        {'X','O','X','X'}
    };

    SurroundedRegions obj = new SurroundedRegions();
    obj.solve(board);
    obj.print(board);


  }

  private void print(char[][] board){

    int row = board.length;
    int col = board[0].length;

    for(int i=0 ;i<row; i++) {

      for (int j = 0; j < col; j++) {
        System.out.print(board[i][j]+" ");
      }
      System.out.println();
    }
  }
//wrong solution
  public void solve(char[][] board) {


    int row = board.length;
    int col = board[0].length;

    //marking border O to 1
    for(int j=0 ;j<col; j++){
      if(board[row-1][j]=='O'){
        board[row-1][j]='1';
      }
      if(board[0][j]=='O'){
        board[0][j]='1';
      }

    }

    for(int i=0 ;i<row; i++){
      if(board[i][col-1]=='O'){
        board[i][col-1]='1';
      }
      if(board[i][0]=='O'){
        board[i][0]='1';
      }
    }


    System.out.println("After border 1");
    print(board);

    for(int i=1 ;i<row-1; i++){
      for(int j=1 ;j<col-1; j++){
        if(board[i][j]=='O' && isOneInSide(i,j,board)){
          board[i][j]='1';
        }
      }
    }

    for(int i=0 ;i<row; i++){
      for(int j=0 ;j<col; j++){
        if( board[i][j]=='O'){
          board[i][j]='X';
        }
        else if( board[i][j]=='1'){
          board[i][j]='O';
        }
      }
    }

  }

  private boolean isOneInSide(int i, int j, char[][] board){
    if(board[i-1][j]=='1'){
      return true;
    }
    if(board[i+1][j]=='1'){
      return true;
    }
    if(board[i][j-1]=='1'){
      return true;
    }
    if(board[i][j+1]=='1'){
      return true;
    }
    return false;
  }




  public void solve1(char[][] board) {


    int row = board.length;
    int col = board[0].length;

    for(int i=0 ;i<row; i++){

      for(int j=0 ;j<col; j++){

        if(board[i][j]=='O'){
          Set<Integer> region = new HashSet();
          Set<Dir> direction = new HashSet();
          Set<Integer> unique = new HashSet();
          Queue<Integer> q = new LinkedList();
          int ij = i*col+j;
          q.add(ij);
          region.add(ij);
          while(!q.isEmpty()){
            ij = q.poll();
            int i1= ij/col;
            int j1= ij%col;
            //UP
            int i2 = i1-1;
            int j2 = j1;
            int i2j2 = i2*col+j2;
            if(isValid(i2,j2,row,col)){
              if(board[i2][j2]=='X' && !direction.contains(Dir.UP)){
                direction.add(Dir.UP);
                unique.add(i2j2);
              }
              else {
                if(!region.contains(i2j2)){
                  region.add(i2j2);
                  q.add(i2j2);
                }
              }
            }
            // DOWN
            i2 = i1+1;
            j2 = j1;
            i2j2 = i2*col+j2;
            if(isValid(i2,j2,row,col)){
              if(board[i2][j2]=='X' && !direction.contains(Dir.DOWN)){
                direction.add(Dir.DOWN);
                unique.add(i2j2);
              }
              else{
                if(!region.contains(i2j2)){
                  region.add(i2j2);
                  q.add(i2j2);
                }
              }
            }
            // LEFT
            i2 = i1;
            j2 = j1-1;
            i2j2 = i2*col+j2;
            if(isValid(i2,j2,row,col)){
              if(board[i2][j2]=='X' && !direction.contains(Dir.LEFT)){
                direction.add(Dir.LEFT);
                unique.add(i2j2);
              }
              else{
                if(!region.contains(i2j2)){
                  region.add(i2j2);
                  q.add(i2j2);
                }
              }
            }
            // RIGHT
            i2 = i1;
            j2 = j1+1;
            i2j2 = i2*col+j2;
            if(isValid(i2,j2,row,col)){
              if(board[i2][j2]=='X' && !direction.contains(Dir.RIGHT)){
                direction.add(Dir.RIGHT);
                unique.add(i2j2);
              }
              else{
                if(!region.contains(i2j2)){
                  region.add(i2j2);
                  q.add(i2j2);
                }
              }
            }

          }
          if(direction.size()==4 && unique.size()==4 ){
            for(Integer indexij: region){
              int indexI = indexij/col;
              int indexJ = indexij%col;
              board[indexI][indexJ]='X';
            }
          }
        }

      }
    }
  }
  private boolean isValid(int i, int j, int row, int col){
    if(i>=row || i<0){
      return false;
    }
    if(j>=col || j<0){
      return false;
    }
    return true;
  }

}
