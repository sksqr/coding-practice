package com.practice.linkedlist;

import java.util.Arrays;
import java.util.List;

public class KReverseLinkedList {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
    //                                 3,2,1; 6,7,5
    //                                nh   nt
    ListNode head = LinkListUtils.getLinkedListFromArray(list);
    LinkListUtils.print(head);
    KReverseLinkedList kReverseLinkedList = new KReverseLinkedList();
//    ListNode newHead =  kReverseLinkedList.reverseAll(head);
//    System.out.println("Reverse:");
//    LinkListUtils.print(newHead);
    ListNode hh = kReverseLinkedList.reverseListRec(head,3);
    LinkListUtils.print(hh);
  }


  public ListNode reverseListRec(ListNode A, int B) {
    if(A==null || B<=1){
      return A;
    }
    ListNode oldHead = A;
    ListNode end = oldHead;
    int k=0;
    while (end.next!=null && k<B-1){
      end = end.next;
      k++;
    }
    ListNode nextHead = end.next;
    end.next=null;
    ListNode newHead = reverseAll(oldHead);
    oldHead.next = reverseListRec(nextHead,B);
    return newHead;
  }

  public ListNode reverseList(ListNode A, int B) {
    ListNode oldHead = A;
    ListNode newHead = null;
    ListNode newTail = null;
    while (oldHead!=null){
      int k=0;
      ListNode start = oldHead;
      ListNode end = oldHead;
      while (end!=null && k<B){
        end = end.next;
        k++;
      }
      newTail = oldHead;
      oldHead = end.next;
      end.next=null;
      ListNode head = reverseAll(start);
      if(newHead==null){
        newHead = head;
      }
      else {
        newTail.next = head;
      }
    }
    return newHead;
  }

  public ListNode reverseAll(ListNode A){
    ListNode newHead = null;
    ListNode oldHead= A;
    ListNode temp= null;

    while (oldHead!=null){
      temp = newHead;
      newHead = oldHead;
      oldHead = oldHead.next;
      newHead.next=temp;
    }
    return newHead;
  }






}
