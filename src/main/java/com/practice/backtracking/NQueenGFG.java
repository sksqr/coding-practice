package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenGFG {

  public static void main(String[] args)
  {
    int n = 4;
    ArrayList<ArrayList<String>> res = solveNQueens(n);
    System.out.println(res);
  }

  // [2 4 1 3 ][3 1 4 2 ]
  /*
  [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
   */

  public static ArrayList<ArrayList<String>> solveNQueens(int a) {

    List<List<Integer> > res = nQueen(a);
    System.out.println(res);
    ArrayList<ArrayList<String>> sol = new ArrayList<>();
    for(int i=0;i<res.size();i++){
      ArrayList<String> subSol = new ArrayList<>();
      for(int j=0; j<res.get(i).size();j++){
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<a;k++){
          if(k+1 == res.get(i).get(j)){
            sb.append("Q");
          }
          else {
            sb.append(".");
          }
        }
        subSol.add(sb.toString());
      }
      sol.add(subSol);
    }
    return sol;
  }


  static List<List<Integer> > result
      = new ArrayList<List<Integer> >();
  static boolean[] cols,leftDiagonal,rightDiagonal;


  /* This function solves the N Queen problem using
    Backtracking. It mainly uses solveNQUtil() to
    solve the problem.
    */
  static List<List<Integer>> nQueen(int n) {
    // cols[i] = true if there is a queen previously placed at ith column
    cols = new boolean[n];
    // leftDiagonal[i] = true if there is a queen previously placed at
    // i = (row + col )th left diagonal
    leftDiagonal = new boolean[2*n];
    // rightDiagonal[i] = true if there is a queen previously placed at
    // i = (row - col + n - 1)th rightDiagonal diagonal
    rightDiagonal = new boolean[2*n];
    result  = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    for(int i=0;i<n;i++)temp.add(0);
    solveNQUtil(result,n,0,temp);

    return result;
  }
  private static void solveNQUtil(List<List<Integer>> result,int n,int row,List<Integer> comb){
    if(row==n){
      // if row==n it means we have successfully placed all n queens.
      // hence add current arrangement to our answer
      // comb represent current combination
      result.add(new ArrayList<>(comb));
      return;
    }
    for(int col = 0;col<n;col++){
      // if we have a queen previously placed in the current column
      // or in current left or right diagonal we continue
      if(cols[col] || leftDiagonal[row+col] || rightDiagonal[row-col+n])
        continue;
      // otherwise we place a queen at cell[row][col] and
      //make current column, left diagonal and righ diagonal true
      cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = true;
      comb.set(col,row+1);
      // then we goto next row
      solveNQUtil(result,n,row+1,comb);
      // then we backtrack and remove our currently placed queen
      cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = false;
    }
  }


}
