package com.practice.array;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LargestNumber {

  public static void main(String[] args) {
    LargestNumber largestNumber = new LargestNumber();
    List<Integer> list = Arrays.asList(782, 240, 409, 678, 940, 502, 113, 686, 6, 825, 366, 686, 877, 357, 261, 772, 798, 29, 337, 646, 868, 974, 675, 271, 791, 124, 363, 298, 470, 991, 709, 533, 872, 780, 735, 19, 930, 895, 799, 395, 905 );
    System.out.println(largestNumber.largestNumber(list));
  }



  public String largestNumber(final List<Integer> A) {
    PriorityQueue<String> queue = new PriorityQueue((a1,a2)->{
      String s1 = a1.toString();
      String s2 = a2.toString();
      String s1s2 = s1+s2;
      String s2s1 = s2+s1;
      return s2s1.compareTo(s1s2);
    });

    for(int i=0;i<A.size();i++){
      queue.add(String.valueOf(A.get(i)));
    }
    StringBuilder sb = new StringBuilder();
    boolean firstSet=false;
    while(!queue.isEmpty())
    {    String num = queue.poll();
      if(firstSet){
        sb.append(num);
      }
      if(!firstSet && !num.equals("0")){
        sb.append(num);
        firstSet=true;
      }
    }
    if(!firstSet){
      sb.append("0");
    }
    return sb.toString();
  }

}
