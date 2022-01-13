package com.practice.linkedlist;

public class IntersectionOfLinkedLists {

  public ListNode getIntersectionNode(ListNode a, ListNode b) {

    int n1=countEle(a);
    int n2=countEle(b);
    int diff=Math.abs(n1-n2);
    ListNode head1=a;
    ListNode head2=b;
    if(n1>n2){
      while(diff>0){
        head1=head1.next;
        diff--;
      }
    }
    else{
      while(diff>0){
        head2=head2.next;
        diff--;
      }
    }
    while(head1!=head2){
      head1=head1.next;
      head2=head2.next;
    }
    return head1;

  }

  private int countEle(ListNode a){
    int n1=0;
    ListNode head1 = a;
    while(head1!=null){
      n1++;
      head1=head1.next;
    }
    return n1;
  }

}
