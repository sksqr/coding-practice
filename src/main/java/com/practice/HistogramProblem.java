package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistogramProblem {

  private static int unitsOfWaterLogged(List<Integer> a){
    List<Integer> leftMax = new ArrayList();
    int n=a.size();
    leftMax.add(a.get(0));
    int i=1;
    while (i<n){
      if(a.get(i) > leftMax.get(i-1)){
        leftMax.add(a.get(i));
      }
      else {
        leftMax.add(leftMax.get(i-1));
      }
      i++;
    }

    int[] rightMax = new int[n];
    rightMax[n-1]=a.get(n-1);
    i=n-2;
    while (i>=0){
      if(a.get(i) > rightMax[i+1]){
        rightMax[i]=a.get(i);
      }
      else {
        rightMax[i] = rightMax[i+1];
      }
      i--;
    }
    int waterLogged =0;

    for(i=0;i<n;i++){
      waterLogged += Math.min(leftMax.get(i),rightMax[i]) - a.get(i);
    }
    return waterLogged;
  }


  public static void main(String[] args) {
//    List<Integer> a = new ArrayList<>(Arrays.asList(4,0,2,0,8,0,3,0,5,0,2));
    List<Integer> a = new ArrayList<>(Arrays.asList(4,0,2,0));
    System.out.println(unitsOfWaterLogged(a));
  }

}
