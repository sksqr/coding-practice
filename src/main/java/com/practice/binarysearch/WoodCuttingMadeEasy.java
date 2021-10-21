package com.practice.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WoodCuttingMadeEasy {

  public static void main(String[] args) {
    WoodCuttingMadeEasy woodCuttingMadeEasy = new WoodCuttingMadeEasy();
    List<Integer> list = Arrays.asList(20, 15, 10, 17);
    int B =7;
//    List<Integer> list = Arrays.asList(4, 42, 40, 26, 46);
//    int B =20;

//    List<Integer> list = Arrays.asList(114, 55, 95, 131, 77, 111, 141 );
//    int B =95;
    System.out.println(woodCuttingMadeEasy.solve(new ArrayList<>(list), B));

  }


  public int solve(ArrayList<Integer> A, int B) {

    Collections.sort(A);
    int n = A.size();
    int[] woodLength = new int[n];
    int i=n-1;
    int sum =0;
    while(i>=0){
      sum += A.get(i);
      woodLength[i] = sum;
      i--;
    }
    int hight = binarySearch(A,woodLength,A.get(0),A.get(n-1),B);
    return hight;

  }

  int binarySearch(ArrayList<Integer> A, int[] woodLength, int low, int high, int B ){
    if(low > high){
      return high;
    }

    int midHight = low + ((high - low) / 2);
    int index = hightIndex(A,midHight,0,A.size());
    int len = woodLength[index] - (midHight * (A.size()-index));
    if(len == B){
      return midHight;
    }
    else if(len < B){
      return binarySearch(A, woodLength, low, midHight-1, B);
    }
    else{
      return binarySearch(A, woodLength, midHight+1, high, B);
    }

  }

  int hightIndex(ArrayList<Integer> A, int ht, int low, int high){
    if(low > high){
      return high-1;
    }
    int mid = low + ((high - low) / 2);
    if(mid+1 < A.size() && A.get(mid) <= ht && A.get(mid+1) >ht){
      return mid+1;
    }
    else if(A.get(mid) >ht){
      return hightIndex(A,ht,low,mid-1);
    }
    else {
      return hightIndex(A,ht,mid+1,high);
    }
  }


  public static int solve2(ArrayList<Integer> A, int B) {

    int h = 0;
    int max = 0;
    int min =0;
    int ans = 0;

    for(int i=0;i<A.size();i++){
      max = Math.max(max,A.get(i));
    }

    while(min<=max){
      int mid = min+(max-min)/2;
      long wood = 0;
      for(int j=0;j<A.size();j++){
        if(A.get(j)-mid>0){
          wood = wood+A.get(j)-mid;
        }
      }
      if(wood>=(long)B){
        min = mid+1;
        //0 5 10 15
        ans = Math.max(ans,mid);//15
      }else{
        max = mid-1;
      }
    }
    return ans;
  }


}
