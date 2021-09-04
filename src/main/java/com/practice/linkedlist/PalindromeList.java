package com.practice.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromeList {


  public int lPalin(ListNode A) {
    List<Integer> list = new ArrayList<>();
    ListNode temp = A;
    while (temp!=null){
      list.add(temp.val);
      temp = temp.next;
    }
    return isPalin(list);
  }

  static private int isPalin(List<Integer> list){
    int start = 0;
    int end = list.size()-1;
    while (start<end){
      if(!list.get(start).equals(list.get(end))){
        return 0;
      }
      start++;
      end--;
    }
    return 1;
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(418 , 381 , 96 , 356 , 411 , 336 , 94 , 433 , 315 , 29 , 140 , 194 , 333 , 489 , 440 , 433 , 469 , 402 , 228 , 228 , 264 , 499 , 318 , 182 , 159 , 159 , 182 , 318 , 499 , 264 , 228 , 228 , 402 , 469 , 433 , 440 , 489 , 333 , 194 , 140 , 29 , 315 , 433 , 94 , 336 , 411 , 356 , 96 , 381 , 418);
//    List<Integer> list = Arrays.asList(418 , 381 , 418 );
    System.out.println(isPalin(list));
  }
}
