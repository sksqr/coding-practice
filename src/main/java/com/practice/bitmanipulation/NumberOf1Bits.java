package com.practice.bitmanipulation;

public class NumberOf1Bits {

  public static void main(String[] args) {
    long a=4294967295L;
    //32
    System.out.println(numSetBits(a));
  }

  public static int numSetBits(long a) {
    long one = 1L;
    int count=0;
    long num=a;
    while(num!=0){
      long and = num & one;
      if(and == 1) {
        count++;
      }
      num=num>>1;
    }
    return count;
  }

}
