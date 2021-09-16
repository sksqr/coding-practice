package com.practice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
    List<Integer> list = Arrays.asList(1, 5, 4, 3);
    System.out.println(containerWithMostWater.maxArea(new ArrayList<>(list)));
  }

  public int maxArea(ArrayList<Integer> A) {
    int start=0;
    int last=A.size()-1;
    int max=0;
    while (last>start){
      int area = Math.min(A.get(start),A.get(last)) * (last-start);
      if(area>max){
        max=area;
      }
      if(A.get(start) < A.get(last)){
        start++;
      }
      else {
        last--;
      }
    }
    return max;
  }

}
