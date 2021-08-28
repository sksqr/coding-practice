package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChainOfPairs {

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> listOfPairs = getInput();

    System.out.println(maxChainLength(listOfPairs,listOfPairs.size()));

//    System.out.println(pairLCS(listOfPairs,1,listOfPairs.get(0),1));
//    System.out.println(pairLCSIterative(getInput()));
  }

  public int solve(ArrayList<ArrayList<Integer>> A ) {
return 0;
  }

    private static int pairLCSIterative(ArrayList<ArrayList<Integer>> A) {
      int n = A.size();
      int[] dp = new int[n];
      Arrays.fill(dp,-1);
      dp[0]=1;

      ArrayList<Integer> lastPair =A.get(0);
      for(int i=1;i<n;i++){
        if(A.get(i).get(0) > lastPair.get(1)){
          dp[i]=dp[i-1]+1;
          lastPair=A.get(i);
        }
        else {
          dp[i]=dp[i-1];
        }
      }
      return dp[n-1];
    }



  private static int pairLCS(ArrayList<ArrayList<Integer>> A, int n, ArrayList<Integer> lastPair, int count ) {
    if(n==A.size()){
      return count;
    }
    int val1=0;
    int val2=0;
    int val3=0;
    if(A.get(n).get(0) > A.get(n-1).get(1)){
      val1 =  pairLCS(A,n+1,A.get(n),2);
    }
    if( A.get(n).get(0) > lastPair.get(1)){
      val2 = pairLCS(A,n+1,A.get(n),count+1);
    }
    val3 = pairLCS(A,n+1,lastPair,count);
    return Math.max(val1,Math.max(val2,val3));
  }


  // This function assumes that
  // arr[] is sorted in increasing order
  // according the first (or smaller)
  // values in pairs.
  static int maxChainLength(ArrayList<ArrayList<Integer>> arr, int n)
  {
    int i, j, max = 0;
    int mcl[] = new int[n];

       /* Initialize MCL (max chain length)
        values for all indexes */
    for ( i = 0; i < n; i++ )
      mcl[i] = 1;

       /* Compute optimized chain length
        values in bottom up manner */
    for ( i = 1; i < n; i++ )
      for ( j = 0; j < i; j++ )
        if ( arr.get(i).get(0) > arr.get(j).get(1) &&
            mcl[i] < mcl[j] + 1)
          mcl[i] = mcl[j] + 1;

    // mcl[i] now stores the maximum
    // chain length ending with pair i

    /* Pick maximum of all MCL values */
    for ( i = 0; i < n; i++ )
      if ( max < mcl[i] )
        max = mcl[i];

    return max;
  }


  private static ArrayList<ArrayList<Integer>>  getInput() {
    ArrayList<ArrayList<Integer>> listArrayList = new ArrayList<>();
   // int[][] A = {{98, 894},{397, 942},{70, 519},{258, 456},{286, 449},{516, 626},{370, 873},{214, 224},{74, 629},{265, 886},{708, 815},{394, 770},{56, 252}};
    int[][] A = {{74, 236},{734, 888},{283, 533},{571, 613},{575, 722},{102, 976},{50, 585},{149, 188},{454, 717},{613, 686},{655, 755},{559, 909},{184, 475},{483, 760},{545, 738},{431, 589},{719, 854},{76, 387},{736, 819}};
    for(int i=0;i<A.length;i++){


        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(A[i][0]);
      pair.add(A[i][1]);
      listArrayList.add(pair);
    }
return listArrayList;
  }
}
