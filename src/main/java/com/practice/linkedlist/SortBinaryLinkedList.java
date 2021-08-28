package com.practice.linkedlist;

import java.util.Arrays;
import java.util.List;

public class SortBinaryLinkedList {

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

  public static void printList(ListNode res){
    while(res!=null){
      System.out.print(res.val+" -> ");
      res= res.next;
    }
    System.out.print(" NULL");
  }

  public static void main(String[] args) {
//    List<Integer> list = Arrays.asList(0,0,1,1,0);
    List<Integer> list = Arrays.asList(0 , 0 , 1 , 1 , 0 , 1 , 0 , 0 , 0 , 1 , 1 , 1 , 1 , 1 , 0 , 0 , 1 , 0);
    ListNode head = getLinkedListFromArray(list);
    ListNode res = solve(head);
    System.out.println(res);
    printList(res);

  }

  public static ListNode solve(ListNode A) {
    ListNode head = A;
    ListNode t = A.next;
    ListNode preNode = A;
    while(t != null){
      if(t.val==0){

          ListNode temp = t;
          preNode.next=t.next;
          t =  preNode.next;
          temp.next=head;
          head=temp;

      }
      else {
        preNode =t;
        t = t.next;
      }
    }
    return head;

  }

}

