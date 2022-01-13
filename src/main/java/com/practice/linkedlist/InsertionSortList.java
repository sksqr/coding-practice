package com.practice.linkedlist;

public class InsertionSortList {

  public ListNode insertionSortList(ListNode A) {
    ListNode newHead = null;
    ListNode newTail = null;
    while(A!=null){
      if(newHead == null){
        newHead=A;
        newTail=A;
        A=A.next;
        newHead.next=null;
      }
      else{
        ListNode temp = newHead;
        ListNode prev = null;
        while( temp!=null && temp.val < A.val){
          prev = temp;
          temp = temp.next;
        }
        if(prev==null){
          ListNode temp2 = A.next;
          A.next=newHead;
          newHead=A;
          A=temp2;
        }
        else{
          ListNode temp2 = A.next;
          A.next=temp;
          prev.next=A;
          A=temp2;
        }
      }
    }
    return newHead;
  }

}
