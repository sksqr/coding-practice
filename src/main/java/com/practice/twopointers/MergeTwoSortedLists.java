package com.practice.twopointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>();
    A.add(-4); A.add(-3); A.add(0);
    //Arrays.asList( -4, -3, 0 );
    ArrayList<Integer> B = new ArrayList<>();
    B.add(2);
    merge(A,B);
    System.out.println(A);
  }

  public static void merge(ArrayList<Integer> A, ArrayList<Integer> B) {
    int n1=A.size();
    int n2=B.size();
    int n3 = n1+n2;
    for(int i=0;i<n2;i++){
      A.add(null);
    }
    int i=n1-1;
    for(int j=n3-1;j>=n3-n1;j--){
      A.set(j,A.get(i));
      i--;
    }
    int s1=n2;
    int s2=0;
    int s3=0;
    while(s1<n3 && s2<n2){
      if(A.get(s1) < B.get(s2)){
        A.set(s3,A.get(s1));
        s3++;
        s1++;
      }
      else{
        A.set(s3,B.get(s2));
        s3++;
        s2++;
      }
    }
    while(s1<n3){
      A.set(s3,A.get(s1));
      s1++;
      s3++;
    }
    while(s2<n2){
      A.set(s3,B.get(s2));
      s2++;
      s3++;
    }
  }

}
