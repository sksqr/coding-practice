package com.practice.linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PartitionList {


  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,4,3,2,5,2);
    ListNode head = getInput(list);
    PartitionList partitionList = new PartitionList();
    int B=3;
    ListNode result = partitionList.partition(head,B);
    LinkListUtils.print(result);
  }


  public ListNode partition(ListNode A, int B) {


    ListNode root = A;
    ListNode temp = A;
    ListNode pre = A;
    ListNode less = null;
    ListNode tempLess = null;


    ListNode high = null;
    ListNode tempHigh = null;

    while(temp!=null){
      if(temp.val < B){
        pre = temp.next;
        if(less==null){
          less = temp;
          tempLess= temp;
        }
        else {
          tempLess.next=temp;
          tempLess=temp;
        }
        temp.next=null;
        temp = pre;
      }
      else{
        pre = temp.next;
        if(high==null){
          high = temp;
          tempHigh= temp;
        }
        else {
          tempHigh.next=temp;
          tempHigh=temp;
        }
        temp.next=null;
        temp = pre;
      }

    }

    if(less!=null){
      tempLess.next=high;
      return less;
    }
    return high;
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
