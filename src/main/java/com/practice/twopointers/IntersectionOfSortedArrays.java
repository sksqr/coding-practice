package com.practice.twopointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {

  public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
    List<Integer> larger = null;
    List<Integer> shorter = null;
    if(A.size() > B.size()){
      larger = A;
      shorter = B;
    }
    else{
      larger = B;
      shorter =A;
    }
    int start1=0;
    while(start1<larger.size() && larger.get(start1) < larger.get(0)) {
      start1++;
    }
    int start2=0;
    ArrayList<Integer> intersection = new  ArrayList();
    while(start1<larger.size() && start2<shorter.size()){
      if(larger.get(start1).equals(shorter.get(start2))){
        intersection.add(larger.get(start1));
        start2++;
        start1++;
      }
      else if(larger.get(start1) > shorter.get(start2)){
        start2++;
      }
      else{
        start1++;
      }
    }
    return intersection;
  }


}
