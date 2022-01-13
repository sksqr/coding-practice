package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMaxProduct {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(2,3,4,-11,-4,5,-7,10));
    Collections.sort(list);
    int n =list.size();
    long maxProd =0;
    if(list.size()>=3){
      long p1=0;
      long p2=0;
      if(list.get(0)<0 && list.get(1) <0){
        p1 = list.get(0) * list.get(1);
      }
      p2 = list.get(n-2) * list.get(n-3);
      if(p1 > p2){
        maxProd = p1 * list.get(n-1);
      }
      else {
        maxProd = p2 * list.get(n-1);
      }
    }
    System.out.println("Max Prod:"+maxProd);
  }

}
