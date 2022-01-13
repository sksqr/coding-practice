package com.practice.dp;

public class PalindromePartitioningII {

  public static void main(String[] args) {
    System.out.println(minPalPartionIterative("ababb"));
  }

  public static int minCut(String A) {
    return minPalPartion(A.toCharArray(),0,A.length()-1);
  }

  private static int minPalPartion(char[] a, int start, int end){
    if(start >= end || isPalindrome(a,start,end)){
      return 0;
    }
    int val1=0;
    int val2=0;

    int ans = Integer.MAX_VALUE, count;
    for(int k = start; k < end; k++)
    {
      count = minPalPartion(a, start, k) +
          minPalPartion(a, k + 1, end) + 1;

      ans = Math.min(ans, count);
    }
    return ans;

  }

  static boolean isPalindrome(char[] a, int i, int j)
  {
    while(i < j)
    {
      if(a[i] != a[j])
        return false;
      i++;
      j--;
    }
    return true;
  }



  static int minPalPartionIterative(String str)
  {
    // Get the length of the string
    int n = str.length();

        /* Create two arrays to build the solution
           in bottom up manner
           C[i][j] = Minimum number of cuts needed
                     for palindrome partitioning
                     of substring str[i..j]
           P[i][j] = true if substring str[i..j] is
                     palindrome, else false
           Note that C[i][j] is 0 if P[i][j] is
           true */
    int[][] C = new int[n][n];
    boolean[][] P = new boolean[n][n];

    int i, j, k, L; // different looping variables

    // Every substring of length 1 is a palindrome
    for (i = 0; i < n; i++) {
      P[i][i] = true;
      C[i][i] = 0;
    }

        /* L is substring length. Build the solution in
         bottom up manner by considering all substrings
         of length starting from 2 to n. The loop
         structure is same as Matrix Chain Multiplication
         problem (
        See https:// www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/ )*/
    for (L = 2; L <= n; L++) {
      // For substring of length L, set different
      // possible starting indexes
      for (i = 0; i < n - L + 1; i++) {
        j = i + L - 1; // Set ending index

        // If L is 2, then we just need to
        // compare two characters. Else need to
        // check two corner characters and value
        // of P[i+1][j-1]
        if (L == 2)
          P[i][j] = (str.charAt(i) == str.charAt(j));
        else
          P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];

        // IF str[i..j] is palindrome, then
        // C[i][j] is 0
        if (P[i][j] == true)
          C[i][j] = 0;
        else {
          // Make a cut at every possible
          // localtion starting from i to j,
          // and get the minimum cost cut.
          C[i][j] = Integer.MAX_VALUE;
          for (k = i; k <= j - 1; k++)
            C[i][j] = Integer.min(C[i][j],
                C[i][k] + C[k + 1][j] + 1);
        }
      }
    }

    // Return the min cut value for complete
    // string. i.e., str[0..n-1]
    return C[0][n - 1];
  }


}
