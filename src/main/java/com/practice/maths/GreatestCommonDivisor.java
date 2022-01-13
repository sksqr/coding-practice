package com.practice.maths;

public class GreatestCommonDivisor {

  public int gcd(int A, int B) {

    // Everything divides 0
    if (A == 0)
      return B;
    if (B == 0)
      return A;

    // base case
    if (A == B)
      return A;

    // a is greater
    if (A > B)
      return gcd(A-B, B);
    return gcd(A, B-A);
  }

}
