package com.practice.linkedlist;

import java.util.List;

public class LinkListUtils {

  public static void print(ListNode node){
    while (node!=null){
      System.out.print(node.val+" -> ");
      node = node.next;
    }
    System.out.print(" NULL ");
  }


  public static ListNode getLinkedListFromArray(List<Integer> list){
    ListNode head = null;
    ListNode last = null;
    for(int i=0; i<list.size(); i++){
      if(head == null){
        ListNode node = new ListNode(list.get(i));
        head=node;
        last=node;
      }
      else {
        ListNode node = new ListNode(list.get(i));
        last.next=node;
        last =node;
      }
    }
    return head;
  }

}
