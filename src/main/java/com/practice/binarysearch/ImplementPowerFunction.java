package com.practice.binarysearch;

public class ImplementPowerFunction {

  public static void main(String[] args) {
    int x = 71045970;
    int n = 41535484;
    int d = 64735492;
    //20805472

    int x1 = 2;
    int n1 = 3;
    int d1 = 3;
//System.out.println(Math.floorMod(-1,2));
//    System.out.println(-1%2);
//    System.out.println(pow(x,n,d));

//    System.out.print(d+ power(x, n, d));
  }

 private static  int modulus(int x, int d){
   int modulus = x % d;
   if (modulus<0) modulus += d;
   return modulus;
 }

  public static int pow(int x, int n, int d) {
    int res = myPow(x,n,d);
    return res;
  }

  private static int myPow(int x, int n, int d){
    x=x%d;
    if(n==0){
      return 1%d;
    }
    if(n==1){
      return x%d;
    }
    int prod = (x*x)%d;
    if(n%2 == 0){
      return myPow(prod , n/2, d)%d;
    }
    else{
      return ((x%d) * myPow( prod, (n-1)/2, d))%d;
    }

  }



  static int power(int x, int y, int p)
  {
    int res = 1; // Initialize result

    x = x % p; // Update x if it is more than or
    // equal to p

    if (x == 0)
      return 0; // In case x is divisible by p;

    while (y > 0)
    {

      // If y is odd, multiply x with result
      if ((y & 1) != 0)
        res = (res * x) % p;

      // y must be even now
      y = y >> 1; // y = y/2
      x = (x * x) % p;
    }
    return res;
  }


}
