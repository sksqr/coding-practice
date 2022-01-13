package com.practice.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferentBitsSumPairwise {

  public static void main(String[] args) {
    DifferentBitsSumPairwise sumPairwise =new DifferentBitsSumPairwise();
    List<Integer> list = Arrays.asList( 1, 3, 5);
    System.out.println(sumPairwise.efficient(new ArrayList<>(list)));
  }

//O(n)
  public int efficient(ArrayList<Integer> A) {
    int totalCount=0;
    int n=A.size();
    int mod = 1000000007;
    int setBit = 1;
    for(int i=0;i<32;i++){
      int oneCount=0;
      for(int j=0;j<n;j++){
        int and = setBit & A.get(j);
        if(and!=0){
          oneCount++;
        }
      }
      int zeroCount=n-oneCount;
      int diffCount = (oneCount*zeroCount)*2;
      totalCount = (totalCount+diffCount)%mod;
      setBit = setBit<<1;
    }
    return totalCount;
  }


  public int cntBits(ArrayList<Integer> A) {
    int totalCount=0;
    int n=A.size();
    int mod = 1000000007;
    for(int i=0;i<n;i++){

      for(int j=0;j<n;j++){
        int diffCount = countDiffBit(A.get(i),A.get(j));
        totalCount = (totalCount+diffCount)%mod;
      }
    }
    return totalCount;
  }

  private int countDiffBit(int a1,int a2){
    int n=32;
    int count=0;
    int one=1;
    int i=0;
    int xor=a1^a2;
    while(i<n){
      int and = xor&one;
      if(and==1){
        count++;
      }
      xor = xor>>1;
      i++;
    }
    return count;
  }

}
