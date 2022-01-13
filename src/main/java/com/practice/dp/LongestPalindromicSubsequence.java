package com.practice.dp;

public class LongestPalindromicSubsequence {

  public static void main(String[] args) {
    String s1="BBABCBCAB";

    System.out.println(LPS(s1,0,s1.length()-1));
    System.out.println(LPSIterative(s1));
  }

  private static int LPSIterative(String s1){
    int n=s1.length();
    int L[][] = new int[n][n];
    for(int i=0;i<n;i++){
      L[i][i]=1;
    }
    int i, j, cl;
    for (cl=2; cl<=n; cl++)
    {
      for (i=0; i<n-cl+1; i++)
      {
        j = i+cl-1;
        if (s1.charAt(i) == s1.charAt(j) && cl == 2)
          L[i][j] = 2;
        else if (s1.charAt(i) == s1.charAt(j))
          L[i][j] = L[i+1][j-1] + 2;
        else
          L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
      }
    }

    return L[0][n-1];
  }

  private static int LPS(String s1, int start, int end){
    if(start>end){
      return 0;
    }
    int value1=0;
    int count=2;
    if(s1.charAt(start) == s1.charAt(end)){
      if(end==start){
        count=1;
      }
      value1 = count + LPS(s1,start+1,end-1);
    }
    else {
      value1 = Math.max(LPS(s1,start,end-1),LPS(s1,start+1,end));
    }
    return value1;
  }
}
