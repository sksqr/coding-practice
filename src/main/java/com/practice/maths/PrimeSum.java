package com.practice.maths;

import java.util.ArrayList;

public class PrimeSum {


  public static void main(String[] args) {
    PrimeSum primeSum = new PrimeSum();
    System.out.println(primeSum.primesum(10));
  }


  public ArrayList<Integer> primesum(int A) {
    int half = A/2;
    int i=2;
    ArrayList<Integer> result = new ArrayList();
    while(i<=half){
      if(isPrime(i) && isPrime(A-i) ){
        result.add(i);
        result.add(i-A);
        return result;
      }
      i++;
    }
    return result;
  }

  private boolean isPrime(int num){
    int sqrt = (int)Math.sqrt(num);
    int i=2;
    while(i<= sqrt){
      if(num%i==0){
        return false;
      }
      i++;
    }
    return true;
  }

}
