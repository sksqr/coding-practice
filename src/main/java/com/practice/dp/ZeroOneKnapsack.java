package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroOneKnapsack {

  public static void main(String[] args) {
//    List<Integer> A = Arrays.asList(60, 100, 120);
//    List<Integer> B = Arrays.asList(10, 20, 30);
//    int C=50;
//    List<Integer> A = Arrays.asList(468, 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828, 437, 392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895, 704, 812, 323 );
//    List<Integer> B = Arrays.asList(4, 4, 5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5, 9, 7, 6, 1, 10, 1, 1, 7, 2, 4, 9, 10, 4, 5, 5, 7 );
//    int C=841;
//    //24576

//    List<Integer> A = Arrays.asList( 359, 963, 465, 706, 146, 282, 828, 962, 492);
//    List<Integer> B = Arrays.asList(96, 43, 28, 37, 92, 5, 3, 54, 93);
//    int C=383;
    //5057

    List<Integer> A = Arrays.asList(377, 932, 309, 945, 440, 627, 324, 538, 539, 119, 83, 930, 542, 834, 116, 640, 659, 705, 931, 978, 307, 674, 387, 22, 746, 925, 73, 271, 830, 778, 574, 98, 513, 987, 291, 162, 637, 356, 768, 656, 575, 32, 53, 351, 151, 942, 725, 967, 431, 108, 192, 8, 338, 458, 288, 754, 384, 946, 910, 210, 759, 222, 589, 423, 947, 507, 31 );
    List<Integer> B = Arrays.asList(14, 19, 1, 42, 13, 6, 11, 10, 25, 38, 49, 34, 46, 42, 3, 1, 42, 37, 25, 21, 47, 22, 49, 50, 19, 35, 32, 35, 4, 50, 19, 39, 1, 39, 28, 18, 29, 44, 49, 34, 8, 22, 11, 18, 14, 15, 10, 17, 36, 2, 1, 50, 20, 7, 49, 4, 25, 9, 45, 10, 40, 3, 46, 36, 44, 44, 24);
     int C = 588;
//22819

    ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
    int result = zeroOneKnapsack.solveGFG(A,B,C);
    System.out.println(result);
  }

  Map<String, Integer> map = new HashMap<>();

  Map<Integer, Integer> map2 = new HashMap<>();



  public int solve(List<Integer> A, List<Integer> B, int C) {
    System.out.println("A len:"+A.size());
    System.out.println("B len:"+B.size());
    return maxPossibleValueRec(A,B,C,A.size()-1,0);
  }

  public int maxPossibleValueRec(List<Integer> A, List<Integer> B, int C, int end, int totalValue) {
    if(end<0 ){
      return totalValue;
    }
    int value1=0;
    int value2=0;
    String key = end+":"+C;
    if(map.get(key)!=null){
      return map.get(key);
    }
    if(B.get(end) < C){
      value1 = maxPossibleValueRec(A,B,C-B.get(end), end-1,totalValue+A.get(end));
    }
      value2 = maxPossibleValueRec(A,B,C, end-1,totalValue);

    int value = Math.max(value1,value2);
    map.put(key,value);
    return value;
  }



  public int maxPossibleValue(List<Integer> A, List<Integer> B, int C, int start) {
    System.out.println("start:"+start);
    if(start==A.size()){
      return 0;
    }
    if(C<=0){
      return 0;
    }
    int value1=0;
    int value2=0;
    if(B.get(start)<=C){
      if(map2.get(start)!=null){
        value1 = map2.get(start);
      }
      else {
        value1 = A.get(start) + maxPossibleValue(A,B,C-B.get(start),start+1);
        map2.put(start,value1);
      }
    }
    if(map.get(-start)!=null){
      value2 = map2.get(-start);
    }
    else {
      value2 = maxPossibleValue(A,B,C,start+1);
      map2.put(-start,value2);
    }
    return Math.max(value1,value2);
  }


  // Returns the maximum value that can
  // be put in a knapsack of capacity W
  static int knapSack(int W, int wt[],
      int val[], int n)
  {
    int i, w;
    int K[][] = new int[n + 1][W + 1];

    // Build table K[][] in bottom up manner
    for (i = 0; i <= n; i++)
    {
      for (w = 0; w <= W; w++)
      {
        if (i == 0 || w == 0)
          K[i][w] = 0;
        else if (wt[i - 1] <= w)
          K[i][w]
              = Math.max(val[i - 1]
                  + K[i - 1][w - wt[i - 1]],
              K[i - 1][w]);
        else
          K[i][w] = K[i - 1][w];
      }
    }

    return K[n][W];
  }

  public int solveGFG(List<Integer> A, List<Integer> B, int C) {
    int[] wt = new int[B.size()];
    int[] val = new int[A.size()];
    int n= A.size();
    for(int i=0;i<n;i++){
      wt[i] =  B.get(i);
      val[i] = A.get(i);
    }
   return knapSack(C,wt ,val, n);
  }

}
