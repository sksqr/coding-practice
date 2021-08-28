package com.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class Stairs {

  Map<Integer,Integer> map = new HashMap();

  public int climbStairs(int A) {
    if(A==1){
      return 1;
    }
    if(A==2){
      return 2;
    }
    Integer subProblem1 = map.get(A-1);
    if(subProblem1==null){
      subProblem1 = climbStairs(A-1);
      map.put(A-1,subProblem1);
    }

    Integer subProblem2 = map.get(A-2);
    if(subProblem2==null){
      subProblem2 = climbStairs(A-2);
      map.put(A-2,subProblem2);
    }
    return climbStairs(A-1)+climbStairs(A-2);
  }

}
