package com.practice.linkedlist;

import java.util.List;

public class KthNodeFromMiddle {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(468);
    ListNode l2 = new ListNode(335);
    l1.next = l2.next;

    System.out.println(solve(l1,1));

  }

  public static int solve(ListNode A, int B) {
    ListNode step2 = A;
    int midCount=0;
    int total=0;
    while (step2!=null){
        step2 = step2.next;
        total++;
      }

    midCount= (int)Math.ceil((double) total/2);
    int num=midCount-B;
    int i=0;
    if(total%2==1){
      num=num-1;
    }
    ListNode res = A;
    while (i<num && res!=null){
      res = res.next;
      i++;
    }
    if(i==num && res!=null){
      return res.val;
    }
    return -1;
  }


}
