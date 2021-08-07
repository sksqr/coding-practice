package com.practice.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleQueries {

  public static void main(String[] args) {
//    List<Integer> list = Arrays.asList(1,2,4);
//    List<List<Integer>> listOfList = getAllSubArrays(list);
//    System.out.println(listOfList);
//    List<Integer> maxOfSubArray = getMaxOfSubArrays(list);
//    System.out.println(maxOfSubArray);

//    List<Integer> A = Arrays.asList(1,2,4);
//    List<Integer> B = Arrays.asList(1, 2, 3, 4, 5, 6);
//      List<Integer> A = Arrays.asList(1,3);
//      List<Integer> B = Arrays.asList(1);

//    long mod = (long) 1e5;
//
//    System.out.println(mod);


    List<Integer> A = Arrays.asList(39, 99, 70, 24, 49, 13, 86, 43, 88, 74, 45, 92, 72, 71, 90, 32, 19, 76, 84, 46, 63, 15, 87, 1, 39, 58, 17, 65, 99, 43, 83, 29, 64, 67, 100, 14, 17, 100, 81, 26, 45, 40, 95, 94, 86, 2, 89, 57, 52, 91, 45);
    List<Integer> B = Arrays.asList(1221, 360, 459, 651, 958, 584, 345, 181, 536, 116, 1310, 403, 669, 1044, 1281, 711, 222, 280, 1255, 257, 811, 409, 698, 74, 838);
//    7569 1000000000 1000000000 440996283 778688 1000000000 1000000000 1000000000 1000000000 1000000000 83 1000000000 440996283 778688 3364 59969536 1000000000 1000000000 7569 1000000000 970299 1000000000 59969536 1000000000 970299
    System.out.println(solve(A,B));
  }

  public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
    List<Integer> maxOfSubArray = getMaxOfSubArrays(A);
//    System.out.println(maxOfSubArray);
    int n=maxOfSubArray.size();
    for(int i=0;i<n;i++){
      int prod = getProductOfDivisors(maxOfSubArray.get(i));
      maxOfSubArray.set(i,prod);
    }
    Collections.sort(maxOfSubArray, (i1,i2)->i2-i1);
//    System.out.println(maxOfSubArray);
    ArrayList result = new ArrayList();
    for(int i=0; i<B.size();i++){
      result.add(maxOfSubArray.get(B.get(i)-1));
    }
    return  result;
  }

  private static int getProductOfDivisors(int num){
    long modulo = 1000000007;
    long prod=1;
    int i=1;
    while (i<=num){
      if(num%i == 0 ){
        prod = ((prod%modulo)*(i%modulo))%modulo;
//        prod *= i;
      }
      i++;
    }
    return (int)(prod);
  }



  private static List<Integer> getMaxOfSubArrays(List<Integer> A){
    int n=A.size();
    int cap = (int)Math.pow(2,n);
    List<Integer> maxInSubArray = new ArrayList<>(cap);
    int max = Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
      max = A.get(i);
      maxInSubArray.add(max);
      for (int j=i+1;j<n;j++){
        if(A.get(j)>max){
          max = A.get(j);
        }
        maxInSubArray.add(max);
      }
    }
    return maxInSubArray;
  }

  private static List<List<Integer>> getAllSubArrays(List<Integer> A){
    int n=A.size();
    List<List<Integer>> listOfList = new ArrayList<>();
    List<Integer> maxInSubArray = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
      List<Integer> list = new ArrayList<>();
      list.add(A.get(i));
      listOfList.add(list);
      max = A.get(i);
      maxInSubArray.add(max);
      for (int j=i+1;j<n;j++){
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        list2.add(A.get(j));
        if(A.get(j)>max){
          max = A.get(j);
        }
        listOfList.add(list2);
        maxInSubArray.add(max);
        list=list2;
      }
    }
    return listOfList;
  }

}
