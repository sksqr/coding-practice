package com.practice.linkedlist;

public class MergeTwoSortedLists {

  public static ListNode mergeList(ListNode l1, ListNode l2) {
    ListNode head1 = l1;
    ListNode head2 =l2;
    ListNode head = null;
    ListNode temp3 =null;

    while (head1!=null && head2!=null){
      if(head1.val > head2.val){
        ListNode temp = head2.next;
        head2.next=null;
        if(head==null){
          head=head2;
          temp3=head2;
        }
        else {
          temp3.next=head2;
          temp3=head2;
        }
        head2=temp;
      }
      else {
        ListNode temp = head1.next;
        head1.next=null;
        if(head==null){
          head=head1;
          temp3=head1;
        }
        else {
          temp3.next=head1;
          temp3=head1;
        }
        head1=temp;
      }

    }
    if (head1!=null){
      temp3.next = head1;
    }
    else if(head2!=null){
      temp3.next = head2;
    }
    return head;
  }


}
