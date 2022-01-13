package com.practice.dp;

import java.util.ArrayList;

public class IncreasingPathInMatrix {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> mat = getInput();
    System.out.println(solve(mat));
  }

  public static int solve(ArrayList<ArrayList<Integer>> A) {
    int row = A.size();
    int col = A.get(0).size();
//    return largePath(A,row-1,col-1,Integer.MAX_VALUE);
    return largePathIterative(A);
  }



  private static int largePathIterative(ArrayList<ArrayList<Integer>> A){
    int row = A.size();
    int col = A.get(0).size();
    int [][] path = new int[row][col];
    path[0][0]=1;
    for(int i=1;i<row;i++){
      if(A.get(i).get(0) > A.get(i-1).get(0) && path[i-1][0]!=-1){
        path[i][0] = 1+ path[i-1][0];
      }
      else {
        path[i][0]=-1;
      }
    }
    for(int i=1;i<col;i++){
      if(A.get(0).get(i) > A.get(0).get(i-1) && path[0][i-1]!=-1){
        path[0][i] = 1+ path[0][i-1];
      }
      else {
        path[0][i]=-1;
      }
    }

    for(int i=1;i<row;i++){

      for(int j=1;j<col;j++){
        int val1 = -1;
        if(A.get(i).get(j) > A.get(i-1).get(j) ){
          val1=path[i-1][j];
        }
        int val2 = -1;
        if(A.get(i).get(j) > A.get(i).get(j-1)){
          val2 = path[i][j-1];
        }
        int val = Math.max(val1,val2);
        if(val==-1){
          path[i][j]=-1;
        }
        else {
          path[i][j]=1+val;
        }
      }
    }
    return path[row-1][col-1];
  }


  private static int largePath(ArrayList<ArrayList<Integer>> A, int r, int c, int nextValue){
    if(r<0 || c <0){
      return -1;
    }
    if(r==0 && c==0){
      return 1;
    }
    if(A.get(r).get(c) >= nextValue){
      return -1;
    }

      int val1 = largePath(A,r-1,c,A.get(r).get(c));
      int val2 = largePath(A,r,c-1,A.get(r).get(c));
    if (val1==-1 && val2 == -1){
      return -1;
    }
    return Math.max(val1+1,val2+1);
  }


  private static ArrayList<ArrayList<Integer>>  getInput() {
    ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();

//    int[][] A = { {1, 10, 3, 4},
//                  {10, 2, 3, 4},
//                  {3, 2, 3, 4},
//                  {4, 5, 6, 7},
//                };


//    int[][] A = { {1, 2, 3, 4},
//        {2, 2, 3, 4},
//        {3, 2, 3, 4},
//        {4, 5, 6, 7},
//    };
//
    int[][] A = {
        {21, 91, 25, 89, 64, 41, 52, 63, 30, 1, 14, 59, 79, 66},
        {8, 78, 1, 59, 40, 4, 61, 58, 25, 78, 9, 14, 88, 2},
        {51, 61, 29, 94, 85, 6, 41, 12, 5, 36, 57, 73, 51, 24},
        {86, 57, 17, 27, 58, 27, 58, 38, 72, 70, 62, 97, 23, 18},
        {13, 18, 97, 86, 42, 24, 30, 30, 66, 60, 33, 97, 56, 54},
        {63, 85, 35, 55, 73, 58, 70, 33, 64, 8, 84, 12, 36, 68},
        {49, 76, 39, 24, 43, 55, 12, 42, 76, 60, 26, 22, 71, 27},
        {35, 6, 84, 51, 99, 80, 2, 94, 35, 38, 35, 57, 94, 77},
    };

    for(int i=0;i<A.length;i++){
      ArrayList<Integer> list = new ArrayList<>();
      for(int j=0; j<A[i].length;j++){
        list.add(A[i][j]);
      }
      listArrayList.add(list);
    }
    return listArrayList;
  }

}
