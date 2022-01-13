package com.practice.linkedlist;


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReverseLinkedList {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode  l2= new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    l1.next = l2; l2.next=l3; l3.next=l4;

    ListNode reverse = reverseList(l1);

    System.out.println(reverse);
  }

  public static ListNode reverseList(ListNode A) {

    ListNode head =null;
    ListNode newHead =A;
    ListNode t1=A;
    ListNode t2 =null;
    while (t1!=null){
      if(t1.next == null){
        newHead = t1;
      }
      t2 =t1.next;
      t1.next=head;
      head=t1;
      t1=t2;

    }
    return newHead;
  }

}


