package com.practice.bitmanipulation;

public class SumOfSetBitsToN {
  //

  public static void main(String[] args) {
    int A=1000000000;
    //846928043
    System.out.println(getSum(A));
  }

  private static  int modulo = 1000000007;
  private static int getSum(int A){
    if(A<1){
      return 0;
    }
    if(A==1){
      return 1;
    }
    int leftMostBit = getLeftMostSetBit(A);
    int num = (int)Math.pow(2,leftMostBit);
    long num_minus1 = (int)Math.pow(2,leftMostBit-1);
    long count =  (leftMostBit*(num_minus1%modulo))+1;
    int countModulo = (int)(count%modulo);
    int diff = A-num;
    return (countModulo + diff%modulo+ getSum(diff))%modulo;
  }

  private static int getLeftMostSetBit(int n){
    int count=0;
    while (n>1){
      count++;
      n = n >> 1;
    }
    return count;
  }

}
