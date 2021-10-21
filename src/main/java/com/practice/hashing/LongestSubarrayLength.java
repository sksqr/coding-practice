package com.practice.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubarrayLength {


  public int solve(ArrayList<Integer> A) {
    return lenOfLongSubarr(A);
  }



  // function to find the length of longest
// subarray having count of 1's one more
// than count of 0's
  static int lenOfLongSubarr(ArrayList<Integer> arr)
  {
    int n= arr.size();
    // unordered_map 'um' implemented as
    // hash table
    HashMap<Integer, Integer> um = new HashMap<Integer,
        Integer>();
    int sum = 0, maxLen = 0;

    // traverse the given array
    for (int i = 0; i < n; i++)
    {

      // consider '0' as '-1'
      sum += arr.get(i) == 0 ? -1 : 1;

      // when subarray starts form index '0'
      if (sum == 1)
        maxLen = i + 1;

        // make an entry for 'sum' if it is
        // not present in 'um'
      else if (!um.containsKey(sum))
        um. put(sum, i);

      // check if 'sum-1' is present in 'um'
      // or not
      if (um.containsKey(sum - 1))
      {

        // update maxLength
        if (maxLen < (i - um.get(sum - 1)))
          maxLen = i - um.get(sum - 1);
      }
    }

    // required maximum length
    return maxLen;
  }

}
