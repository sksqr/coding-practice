package com.practice.twopointers;

import java.util.ArrayList;

public class SortByColor {

  public void sortColors(ArrayList<Integer> a) {
    int zeroCount=0;
    int oneCount=0;
    int twoCount=0;
    for(int i=0;i<a.size();i++){
      if(a.get(i)==0){
        zeroCount++;
      }
      else if(a.get(i)==1){
        oneCount++;
      }
      else{
        twoCount++;
      }
    }
    int i=0;
    while(i<zeroCount){
      a.set(i,0);
      i++;
    }
    int k=0;
    while(k<oneCount){
      a.set(i,1);
      i++;
      k++;
    }
    k=0;
    while(k<twoCount){
      a.set(i,2);
      i++;
      k++;
    }
  }

}
