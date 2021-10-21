package com.practice.array;

import java.util.ArrayList;

public class MinStepsInInfiniteGrid {


  public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
    int n = A.size();
    int x=A.get(0);
    int y=B.get(0);
    int sum=0;
    for(int i=1; i<n; i++){
      int x1 = A.get(i);
      int y1 = B.get(i);
      sum += minSteps(x,y,x1,y1);
      x=x1;
      y=y1;

    }
    return sum;
  }

  private int minSteps(int x, int y, int x1, int y1){
    int xdif = Math.abs(x1-x);
    int ydif = Math.abs(y1-y);
    return Math.max(xdif,ydif);
  }

}
