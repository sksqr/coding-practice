package com.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class AssignMiceToHoles {

  public static void main(String[] args) {
    AssignMiceToHoles assignMiceToHoles = new AssignMiceToHoles();
    ArrayList A = new ArrayList<Integer>(Arrays.asList(4, -4, 2));
    ArrayList B = new ArrayList<Integer>(Arrays.asList(4, 0, 5 ));

//    ArrayList A = new ArrayList<Integer>(Arrays.asList(-49, 58, 72, -78, 9, 65, -42, -3));
//    ArrayList B = new ArrayList<Integer>(Arrays.asList( 30, -13, -70, 58, -34, 79, -36, 27 ));


//    ArrayList A = new ArrayList<Integer>(Arrays.asList(-10, -79, -79, 67, 93, -85, -28, -94));
//    ArrayList B = new ArrayList<Integer>(Arrays.asList(-2, 9, 69, 25, -31, 23, 50, 78));

    System.out.println(assignMiceToHoles.mice(A,B));

  }


  public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
    int maxMinDiff=0;
//    Collections.sort(A, Comparator.reverseOrder());
    Collections.sort(A);
    Collections.sort(B);
    Set<Integer> allocated= new HashSet();
    for(int i=0;i<A.size();i++){
      int diff = Math.abs(A.get(i)-B.get(i));
      if(diff>maxMinDiff){
        maxMinDiff=diff;
      }
//      int minDiffIndex =0;
//      int minDif = Math.abs(A.get(i)-B.get(minDiffIndex));
//      for(int j=1;j<B.size();j++){
//        if(!allocated.contains(j)){
//          int dif = Math.abs(A.get(i)-B.get(j));
//          if( dif < minDif){
//            minDif = dif;
//            minDiffIndex = j;
//          }
//        }
//      }
//      allocated.add(minDiffIndex);
//      if(minDif > maxMinDiff){
//        maxMinDiff =minDif;
//      }
      }
    return maxMinDiff;
  }

}
