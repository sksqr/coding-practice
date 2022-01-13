package com.practice.maths;

import java.util.HashMap;
import java.util.Map;

public class GridUniquePath {

  public static void main(String[] args) {
    GridUniquePath gridUniquePath = new GridUniquePath();
    System.out.println(gridUniquePath.uniquePaths(3,4));
  }

  private Map<String,Integer> map = new HashMap();
  public int uniquePaths(int A, int B) {
    if(A==1 || B==1){
      return 1;
    }
    String key = A+":"+B;
    Integer result = map.get(key);
    if(result!=null){
      return result;
    }
    int a_bMinus1 = uniquePaths(A,B-1);
    int aMinus1_b = uniquePaths(A-1,B);
    result = a_bMinus1 + aMinus1_b;
    map.put(key,result);
    return result;

  }

}
