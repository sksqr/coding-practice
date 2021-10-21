package com.practice.array;
/*
Given an array A containing N integers.

You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.

If no such triplet exist return 0.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MaximumSumTriplet {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(2, 5, 3, 1, 4, 9);
    System.out.println(maxTripletSum2(new ArrayList<>(list)));
  }


  public static int maxTripletSum2(ArrayList<Integer> arr)
  {
    int n= arr.size();
    // Initialize suffix-array
    int maxSuffArr[] = new int[n + 1];

    // Set the last element
    maxSuffArr[n] = 0;

    // Calculate suffix-array containing maximum
    // value for index i, i+1, i+2, ... n-1 in
    // arr[i]
    for(int i = n - 1; i >= 0; --i)
      maxSuffArr[i] = Math.max(maxSuffArr[i + 1],
          arr.get(i));

    int ans = 0;

    // Initialize set container
    TreeSet<Integer> lowValue = new TreeSet<Integer>();

    // Insert minimum value for first comparison
    // in the set
    lowValue.add(Integer.MIN_VALUE);

    for(int i = 0; i < n - 1; ++i)
    {
      if (maxSuffArr[i + 1] >arr.get(i))
      {
        ans = Math.max(ans, lowValue.lower(arr.get(i)) +
            arr.get(i) + maxSuffArr[i + 1]);

        // Insert arr[i] in set<> for further
        // processing
        lowValue.add(arr.get(i));
      }
    }
    return ans;
  }

}
