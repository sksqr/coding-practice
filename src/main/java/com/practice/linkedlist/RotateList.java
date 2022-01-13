package com.practice.linkedlist;

import java.util.Arrays;
import java.util.List;

public class RotateList {

  public static void main(String[] args) {
//    List<Integer> list = Arrays.asList(91 , 34 , 18 , 83 , 38 , 82 , 21 , 69);
//    int B=89;
    //    69 -> 91 -> 34 -> 18 -> 83 -> 38 -> 82 -> 21
    List<Integer> list = Arrays.asList(68, 86,  36, 16, 5,75 );
    int B=90;
//    68 -> 86 -> 36 -> 16 -> 5 -> 75
    ListNode head = SortBinaryLinkedList.getLinkedListFromArray(list);
    ListNode res = rotateRight(head,B);
    SortBinaryLinkedList.printList(res);
  }


  public static ListNode rotateRight(ListNode A, int B) {
    int k=B;
    ListNode head1 = A;
    ListNode t1 = head1;
    ListNode last = head1;
    int total =0;
    while(k>0 && last!=null){
      total++;
      last = last.next;
      k--;
    }
    if(last==null){
      if(B==total || total==1 || B%total==0){
        return head1;
      }
      else {
        k = B%total;
        last = head1;
        while(k>0 && last!=null){
          total++;
          last = last.next;
          k--;
        }
      }
    }
    while(last.next != null){
      last = last.next;
      t1= t1.next;
    }
    ListNode newHead = t1.next;
    t1.next=null;
    last.next=head1;
    return newHead;

  }

}
