package com.practice.linkedlist;

public class RemoveDuplicatesFromSortedList {

  public ListNode deleteDuplicates(ListNode A) {
    ListNode head = A;
    ListNode t = head.next;
    int pre=A.val;
    ListNode preNode=head;
    while(t!=null){
      if(t.val == pre){
        preNode.next = t.next;
        t.next = null;
        t = preNode.next;
      }
      else{
        pre = t.val;
        preNode = t;
        t = preNode.next;
      }
    }
    return head;
  }

}
