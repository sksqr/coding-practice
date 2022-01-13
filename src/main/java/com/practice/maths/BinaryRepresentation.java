package com.practice.maths;

public class BinaryRepresentation {

  public static void main(String[] args) {
    System.out.println(findDigitsInBinary(6));
  }

  public static String findDigitsInBinary(int A) {
    StringBuilder sb = new StringBuilder();
    while (A>0){
      int rem = A%2;
      sb.append(rem);
      A = A/2;
    }
    return sb.reverse().toString();
  }

}
