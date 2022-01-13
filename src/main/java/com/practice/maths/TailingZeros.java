package com.practice.maths;

public class TailingZeros {

  public static void main(String[] args) {
    System.out.println(trailingZeroes(100));
  }
  public static int trailingZeroes(int A) {
    int fives = 0;
    int pow5 =5;
    int i=1;
    int count=1;
    while (count>0){
       count= (A/pow5);
       fives +=count;
      pow5 *= 5;
    }
    return fives;
  }

}
