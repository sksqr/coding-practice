package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {

  public static void main(String[] args) {
    LargestContinuousSequenceZeroSum largestContinuousSequenceZeroSum = new LargestContinuousSequenceZeroSum();
    List<Integer> list = Arrays.asList( -8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25
);
    System.out.println(largestContinuousSequenceZeroSum.lszero(new ArrayList<>(list)));
  }


  public ArrayList<Integer> lszero(ArrayList<Integer> A) {
    int start=-1;
    int end =-1;
    Map<Integer,Integer> sumToIndexMap = new HashMap();
    int i=0;
    int n=A.size();
    int sum=0;
    sumToIndexMap.put(0,-1);
    while(i<n){
      sum += A.get(i);
      if(sumToIndexMap.get(sum)==null){
        sumToIndexMap.put(sum,i);
      }
      else{
        int tempStart = sumToIndexMap.get(sum)+1;
        int tempEnd = i;
        if(tempEnd-tempStart > end-start || start==-1){
          start=tempStart;
          end=tempEnd;
        }
      }
      i++;
    }
    ArrayList<Integer> result = new ArrayList();
    while(start>-1 && start <= end){
      result.add(A.get(start));
      start++;
    }
    return result;
  }

}
