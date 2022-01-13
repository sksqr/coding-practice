package com.practice.maths;

public class ReverseBits {

  public static void main(String[] args) {
    ReverseBits reverseBits = new ReverseBits();
    System.out.println(reverseBits.reverse(0));
  }


  public long reverse(long a) {
    long one =1;
    long reverse=0;
    int i=0;
    while(i<32){
      long bit = one & a;
      reverse = (reverse*2 + bit);
      a = a>>1;
      i++;
    }
    return reverse;
  }

}
