package com.practice.array;

import java.util.ArrayList;

public class BalanceArray {

  public int solve(ArrayList<Integer> A) {
    int n=A.size();
    int count=0;
    for(int i=0;i<n;i++){
      int index=0;
      int evenSum=0;
      int oddSum=0;
      for(int j=0;j<n;j++){
        if(j==i){
          continue;
        }
        if(index%2==0){
          evenSum += A.get(j);
          index++;
        }
        else{
          oddSum += A.get(j);
          index++;
        }
      }
      if(oddSum==evenSum){
        count++;
      }
    }
    return count;
  }




  // Function to count array indices
  // whose removal makes sum of odd and
  // even indexed elements equal
  static int cntIndexesToMakeBalance(ArrayList<Integer>  arr)
  {
    int n =arr.size();

    // If size of the array is 1
    if (n == 1)
    {
      return 1;
    }

    // If size of the array is 2
    if (n == 2)
      return 0;

    // Stores sum of even-indexed
    // elements of the given array
    int sumEven = 0;

    // Stores sum of odd-indexed
    // elements of the given array
    int sumOdd = 0;

    // Traverse the array
    for (int i = 0; i < n; i++)
    {

      // If i is an even number
      if (i % 2 == 0)
      {

        // Update sumEven
        sumEven += arr.get(i);
      }

      // If i is an odd number
      else
      {

        // Update sumOdd
        sumOdd += arr.get(i);
      }
    }

    // Stores sum of even-indexed
    // array elements till i-th index
    int currOdd = 0;

    // Stores sum of odd-indexed
    // array elements till i-th index
    int currEven = arr.get(0);

    // Stores count of indices whose
    // removal makes sum of odd and
    // even indexed elements equal
    int res = 0;

    // Stores sum of even-indexed elements
    // after removing the i-th element
    int newEvenSum = 0;

    // Stores sum of odd-indexed elements
    // after removing the i-th element
    int newOddSum = 0;

    // Traverse the array
    for (int i = 1; i < n - 1; i++)
    {

      // If i is an odd number
      if (i % 2 != 0)
      {

        // Update currOdd
        currOdd += arr.get(i);

        // Update newEvenSum
        newEvenSum = currEven + sumOdd - currOdd;

        // Update newOddSum
        newOddSum = currOdd + sumEven
            - currEven - arr.get(i);
      }

      // If i is an even number
      else
      {

        // Update currEven
        currEven += arr.get(i);

        // Update newOddSum
        newOddSum = currOdd + sumEven
            - currEven;

        // Update newEvenSum
        newEvenSum = currEven + sumOdd
            - currOdd - arr.get(i);
      }

      // If newEvenSum is equal to newOddSum
      if (newEvenSum == newOddSum)
      {

        // Increase the count
        res++;
      }
    }

    // If sum of even-indexed and odd-indexed
    // elements is equal by removing the first element
    if (sumOdd == sumEven - arr.get(0))
    {

      // Increase the count
      res++;
    }

    // If length of the array
    // is an odd number
    if (n % 2 == 1)
    {

      // If sum of even-indexed and odd-indexed
      // elements is equal by removing the last element
      if (sumOdd == sumEven - arr.get(n - 1))
      {

        // Increase the count
        res++;
      }
    }

    // If length of the array
    // is an even number
    else
    {

      // If sum of even-indexed and odd-indexed
      // elements is equal by removing the last element
      if (sumEven == sumOdd - arr.get(n - 1))
      {

        // Increase the count
        res++;
      }
    }

    return res;
  }


}
