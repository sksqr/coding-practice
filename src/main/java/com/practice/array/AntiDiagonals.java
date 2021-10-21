package com.practice.array;

import java.util.ArrayList;

public class AntiDiagonals {

  public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
    ArrayList<ArrayList<Integer>> result = new ArrayList();
    int n = A.size();

    for(int k=0; k<n; k++){
      ArrayList<Integer> list = new ArrayList();
      for(int i=0;i<=k;i++){
        list.add(A.get(i).get(k-i));
      }
      result.add(list);
    }

    for(int k=1; k<n; k++){
      ArrayList<Integer> list = new ArrayList();
      for(int i=k; i<n; i++){
        list.add(A.get(i).get(n-1+k-i));
      }
      result.add(list);
    }


    return result;
  }

}
