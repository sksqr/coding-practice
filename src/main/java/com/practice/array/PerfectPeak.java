package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerfectPeak {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9);
    List<Integer> B = Arrays.asList(5, 1, 4, 4);
    List<Integer> D = Arrays.asList(9488, 25784, 5652, 9861, 31311, 8611, 1671, 7129, 28183, 2743, 11059, 4473, 7927, 21287, 2259, 7214, 32529);
    List<Integer> C = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 3, 10);
    System.out.println(perfectPeak(D));



  }

  public static int perfectPeak(List<Integer> A) {
    int n=A.size();
    int[] leftMaxPrefix = new int[n];
    int[] rightMinPrefix = new int[n];

    Map<Integer,Integer> map = new HashMap<>();;

    int max= Integer.MIN_VALUE;
    for(int i=0; i<n;i++){
      if(map.get(A.get(i))!=null){
        map.put(A.get(i),map.get(A.get(i))+1);
      }
      else {
        map.put(A.get(i),1);
      }
      if(A.get(i) > max){
        leftMaxPrefix[i] = A.get(i);
        max = A.get(i);
      }
      else{
        leftMaxPrefix[i] = max;
      }
    }


    int min= Integer.MAX_VALUE;
    for(int i=n-1; i>=0;i--){
      if(A.get(i) < min){
        rightMinPrefix[i] = A.get(i);
        min = A.get(i);
      }
      else{
        rightMinPrefix[i] = min;
      }
    }

    for(int i=0; i<n;i++){
      if(A.get(i) > leftMaxPrefix[i] && A.get(i) < rightMinPrefix[i] ){
        return 1;
      }
    }
    return 0;

  }


}
