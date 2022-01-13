package com.practice.maths;

public class DistributeInCircle {

  public static void main(String[] args) {
    System.out.println(solve(10078,19216,32724));
  }

  public static int solve(int A, int B, int C) {
    return (A+C)%B-1;
  }

}
