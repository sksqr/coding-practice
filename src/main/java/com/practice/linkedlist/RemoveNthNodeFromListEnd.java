package com.practice.linkedlist;

import java.util.Arrays;
import java.util.List;

public class RemoveNthNodeFromListEnd {

  public static void main(String[] args) {
    RemoveNthNodeFromListEnd removeNthNodeFromListEnd = new RemoveNthNodeFromListEnd();
//    List<Integer> list = Arrays.asList(20 , 380 , 349 , 322 , 389 , 424 , 429 , 120 , 64 , 691 , 677 , 58 , 327 , 631 , 916 , 203 , 484 , 918 , 596 , 252 , 509 , 644 , 33 , 460);
    List<Integer> list = Arrays.asList(1 , 2 , 3 , 4 , 5);
    ListNode node = removeNthNodeFromListEnd.removeNthFromEnd(getInput(list),1);

    display(node);
  }

  static void display(ListNode node){
    while (node!=null){
      System.out.print(node.val+"->");
      node = node.next;
    }
  }

  public ListNode removeNthFromEnd(ListNode A, int B) {

    int n=B;
    ListNode last = A;
    while(n>0 && last.next!=null){
      last = last.next;
      n--;
    }
    if(last.next==null){
      if(B==1) {
        return null;
      }
      ListNode temp = A;
      A = A.next;
      temp.next=null;
      return A;
    }
    ListNode nthFromLast = A;
    while(last.next!=null){
      last = last.next;
      nthFromLast = nthFromLast.next;
    }
    ListNode temp = nthFromLast.next;
    nthFromLast.next=temp.next;
    temp.next=null;
    return A;
  }

  static  ListNode getInput(List<Integer> list){
    ListNode head = null;
    ListNode last = null;
    for(int i=0;i<list.size();i++){
      ListNode temp = new ListNode(list.get(i));
      if(head==null){
        head=temp;
        last=temp;
      }
      else {
        last.next=temp;
        last=temp;
      }
    }
    return head;
  }


}


