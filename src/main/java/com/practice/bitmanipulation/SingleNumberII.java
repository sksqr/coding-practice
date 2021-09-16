package com.practice.bitmanipulation;

/*
https://techmunching.com/find-the-element-that-appears-once-in-array-but-other-elements-appear-thrice/
 */

import java.util.List;

public class SingleNumberII {

  public int singleNumber(final List<Integer> A) {
    return getSingle(A,A.size());
  }

  static int getSingle(List<Integer> arr, int n)
  {
    int ones = 0, twos = 0;
    int common_bit_mask;

    for (int i = 0; i < n; i++) {
            /*"one & arr[i]" gives the bits that are there in
            both 'ones' and new element from arr[]. We
            add these bits to 'twos' using bitwise OR*/
      twos = twos | (ones & arr.get(i));

            /*"one & arr[i]" gives the bits that are
            there in both 'ones' and new element from arr[].
            We add these bits to 'twos' using bitwise OR*/
      ones = ones ^ arr.get(i);

            /* The common bits are those bits which appear third time
            So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can
            be removed from 'ones' and 'twos'*/
      common_bit_mask = ~(ones & twos);

      /*Remove common bits (the bits that appear third time) from 'ones'*/
      ones &= common_bit_mask;

      /*Remove common bits (the bits that appear third time) from 'twos'*/
      twos &= common_bit_mask;
    }
    return ones;
  }


  public int singleNumber2(final List<Integer> A) {
    int num = 0;
    int count = 0;
    for(int i=0;i<32;++i) {
      count = 0;
      for(int a : A) {
        if((a & 1 << i) != 0) {
          count++;
        }
      }
      if(count%3 != 0) {
        num+=1<<i;
      }
    }
    return num;
  }


}
