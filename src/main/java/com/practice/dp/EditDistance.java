package com.practice.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditDistance {

  public static void main(String[] args) {
    String A = "Anshuman";
    String B = "Antihuman";
    System.out.println(minDistance(A,B));
  }

private static Map<Integer, Integer> map = new HashMap<>();

  public static int minDistance(String A, String B ) {
    return minDistance(A,B,0);
  }


  private static int minDistance(String A, String B, int n ) {
    if(n==A.length()){
      if(A.length()<B.length()|| A.length()>B.length()){
        return Math.abs(A.length() - B.length());
      }
      return 0;
    }
    if(n>A.length()-1 || n>B.length()-1  ){
      return 0;
    }

    int val =0;
    if(A.charAt(n)==B.charAt(n)){
      val = minDistance(A,B,n+1);
      return val;
    }
      char[] aa = A.toCharArray();
      //replace
      aa[n] = B.charAt(n);
      int val1 = 1+minDistance(new String(aa),B,n+1);
      //delete
      char[] aDel = new char[A.length()-1];
      for(int i=0;i<A.length()-1;i++){
        if(i<n){
          aDel[i]=A.charAt(i);
        }
        else if(i>=n){
          aDel[i]=A.charAt(i+1);
        }
      }
      int val2 = 1+minDistance(new String(aDel),B,n+1);
      //insert
      char[] aInsert = new char[A.length()+1];
      for(int i=0;i<A.length()+1;i++){
        if(i<n){
          aInsert[i]=A.charAt(i);
        }
        else if(i>n){
          aInsert[i]=A.charAt(i-1);
        }
        else {
          aInsert[i]=B.charAt(n);
        }
      }
    int val3 = 1+minDistance(new String(aInsert),B,n+1);
    val= Math.min(val1,Math.min(val2,val3));
    return val;
  }



  static int editDist(String str1, String str2, int m,
      int n)
  {
    // If first string is empty, the only option is to
    // insert all characters of second string into first
    if (m == 0)
      return n;

    // If second string is empty, the only option is to
    // remove all characters of first string
    if (n == 0)
      return m;

    // If last characters of two strings are same,
    // nothing much to do. Ignore last characters and
    // get count for remaining strings.
    if (str1.charAt(m - 1) == str2.charAt(n - 1))
      return editDist(str1, str2, m - 1, n - 1);

    // If last characters are not same, consider all
    // three operations on last character of first
    // string, recursively compute minimum cost for all
    // three operations and take minimum of three
    // values.
    return 1
        + min(editDist(str1, str2, m, n - 1), // Insert
        editDist(str1, str2, m - 1, n), // Remove
        editDist(str1, str2, m - 1,
            n - 1) // Replace
    );
  }

  static int min(int x, int y, int z)
  {
    if (x <= y && x <= z)
      return x;
    if (y <= x && y <= z)
      return y;
    else
      return z;
  }


  static int editDistDP(String str1, String str2, int m,
      int n)
  {
    // Create a table to store results of subproblems
    int dp[][] = new int[m + 1][n + 1];

    // Fill d[][] in bottom up manner
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        // If first string is empty, only option is
        // to insert all characters of second string
        if (i == 0)
          dp[i][j] = j; // Min. operations = j

          // If second string is empty, only option is
          // to remove all characters of second string
        else if (j == 0)
          dp[i][j] = i; // Min. operations = i

          // If last characters are same, ignore last
          // char and recur for remaining string
        else if (str1.charAt(i - 1)
            == str2.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1];

          // If the last character is different,
          // consider all possibilities and find the
          // minimum
        else
          dp[i][j] = 1
              + min(dp[i][j - 1], // Insert
              dp[i - 1][j], // Remove
              dp[i - 1]
                  [j - 1]); // Replace
      }
    }

    return dp[m][n];
  }

}
