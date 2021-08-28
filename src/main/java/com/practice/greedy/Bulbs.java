package com.practice.greedy;

import java.util.ArrayList;

public class Bulbs {


  public int bulbs(ArrayList<Integer> A) {
    int count=0;
    for(int i=0;i<A.size();i++){
      if((count%2==0 && A.get(i)==0) || (count%2==1 && A.get(i)==1) ){

        count++;
      }
    }
    return count;
  }

  private void flip(ArrayList<Integer> A, int switchPressed){
    for(int i=switchPressed; i<A.size(); i++){
      if(A.get(i)==0){
        A.set(i,1);
      }
      else{
        A.set(i,0);
      }
    }
  }

}
