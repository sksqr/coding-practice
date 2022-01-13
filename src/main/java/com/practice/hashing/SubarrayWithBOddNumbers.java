package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayWithBOddNumbers {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(68, 35, 44);
    int[] a = {68, 35};

//    System.out.println(solve(list,0));
//    System.out.println(countSubarrays(a,2,0));
  }


  public static int solve(List<Integer> A, int B) {

    Map<Integer, List<Integer>> mapNoOfOddsAndIndex = new HashMap<>();

    int i=0;
    int oddCount=0;
    int subArray=0;
    while (i<A.size()){
      if(A.get(i)%2 == 1){
        oddCount++;
      }
      if(mapNoOfOddsAndIndex.get(oddCount) == null){
        mapNoOfOddsAndIndex.put(oddCount, new ArrayList<>());
      }
      mapNoOfOddsAndIndex.get(oddCount).add(i);
      i++;
      if(oddCount>=B){
        if(oddCount==B){
          subArray++;
        }
        if(B!=0){
          subArray += mapNoOfOddsAndIndex.get(oddCount-B)==null?0: mapNoOfOddsAndIndex.get(oddCount-B).size();
        }
      }
    }
    return subArray;

  }


  public static int countSubarrays(List<Integer> a, int m)
  {
    int n=a.size();
    int count = 0;
    int prefix[] = new int[n + 1];
    int odd = 0;

    // Traverse in the array
    for (int i = 0; i < n; i++)
    {
      prefix[odd]++;

      // If array element is odd
      if ((a.get(i) & 1) == 1)
        odd++;

      // When number of odd
      // elements >= M
      if (odd >= m)
        count += prefix[odd - m];
    }

    return count;
  }

}
