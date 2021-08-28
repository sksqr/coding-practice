package com.practice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxContinuousSeriesOf1s {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1,1, 1);
    System.out.println(maxone(list,1));
  }


  public static ArrayList<Integer> maxone(List<Integer> A, int B) {
    int n=A.size();
    int start = 0;
    int end =0;
    int maxLen =0;
    int maxStart=0;
    int maxEnd =0;
    int flip =B;

    while (end<n && start<n){

      if (A.get(end)==1){
        end++;
      }
      else if(end<n && flip >0){
//        A.set(end,1);
        flip--;
        end++;
      }
      else {
        int len = end-start;
        if(len>maxLen){
          maxLen=len;
          maxStart=start;
          maxEnd=end;
        }
        if(A.get(start)==0){
          flip++;
        }
        start++;
      }
    }
    if(end-start >maxLen){
      maxLen = end-start;
      maxStart=start;
      maxEnd=end;
    }

    ArrayList<Integer> list = new ArrayList<>();
    for(int i=maxStart;i<maxEnd;i++){
      list.add(i);
    }

    System.out.println("Max len: "+maxLen);
    return list;
  }

}
