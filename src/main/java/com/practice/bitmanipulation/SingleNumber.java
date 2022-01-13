package com.practice.bitmanipulation;

import java.util.List;

public class SingleNumber {

  public int singleNumber(final List<Integer> A) {

    int xor;
    xor=A.get(0);
    int i=1;
    while(i<A.size()){
      xor ^= A.get(i);
      i++;
    }
    return xor;
  }

}
