package com.practice.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;

public class MinXORValue {

  public int findMinXor(ArrayList<Integer> A) {
    Collections.sort(A);
    int min=Integer.MAX_VALUE;
    int n = A.size();
    for(int i=0;i<n-1;i++){
      int xor = A.get(i)^A.get(i+1);
      if(xor<min){
        min=xor;
      }
    }
    return min;
  }
}
