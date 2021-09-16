package com.practice.linkedlist;

import java.util.List;

public class SortList {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node10 = new ListNode(10);
    node1.next=node10;

    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(12);
    ListNode node4 = new ListNode(4);
    node2.next=node3;
    node3.next=node4;

    ListNode sorted = sortList(node2);
    display(sorted);



  }

  public static void display(ListNode head){
    while (head!=null){
      System.out.print(head.val+"->");
      head=head.next;
    }

  }


  public static ListNode sortList(ListNode A) {
    if(A==null || A.next==null){
      return A;
    }
    ListNode start = A;
    ListNode mid = A;
    ListNode end = A;
    ListNode temp=mid;
    while (end.next!=null){
      temp=mid;
      mid=mid.next;
      if(end.next.next!=null){
        end=end.next.next;
      }
      else {
        end= end.next;
      }
      ListNode l1=A;
      ListNode l2=temp.next;
      temp.next=null;

      ListNode l1sorted = sortList(l1);
      ListNode l2sorted = sortList(l2);
      ListNode merged = mergeList(l1sorted,l2sorted);
      return merged;
    }
    return null;
  }



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
