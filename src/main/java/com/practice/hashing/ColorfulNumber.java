package com.practice.hashing;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

  public static void main(String[] args) {
    ColorfulNumber colorfulNumber = new ColorfulNumber();
//    System.out.println(colorfulNumber.colorful(23));
//    System.out.println(colorfulNumber.colorful(234));
//    System.out.println(colorfulNumber.colorful(12));
//    System.out.println(colorfulNumber.colorful(3245));
    System.out.println(colorfulNumber.colorful(222222222));
  }



  public int colorful(int A) {
    Set<Integer> products = new HashSet();
    int divisor = 10;
    while(A > divisor/10){
      int n=A;
      while(n> divisor/10){
        int rem = n%divisor;
        n=n/10;
        int digitProduct = getDigitProduct(rem);
        if(products.contains(digitProduct)){
          return 0;
        }
        else{
          products.add(digitProduct);
        }
      }
      divisor=divisor*10;
    }
    return 1;
  }

  int getDigitProduct(int n){
    int product=1;
    while(n>0){
      int rem = n%10;
      product = product*rem;
      n = n/10;
    }
    return product;
  }

}
