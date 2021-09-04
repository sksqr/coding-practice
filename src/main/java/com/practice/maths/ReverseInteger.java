package com.practice.maths;

public class ReverseInteger {

  public static void main(String[] args) {
    ReverseInteger reverseInteger = new ReverseInteger();
    System.out.println(reverseInteger.reverse(-1146467285));
  }


  public int reverse(int A) {
    int sign = A<0?-1:1;
    int num = A * sign;
    int result=0;
    while(num>0){
      int rem = num%10;
      if(Integer.MAX_VALUE/10 < result){
        return 0;
      }
      result = (result*10) + rem;
      num=num/10;
    }
    result = result * sign;
    return result;
  }

}
