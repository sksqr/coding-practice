package com.practice.linkedlist;

public class AddTwoNumbersAsLists {

  public ListNode addTwoNumbers(ListNode A, ListNode B) {
    ListNode result = null;
    ListNode t1 = null;
    int carry=0;
    ListNode n1= A;
    ListNode n2 =B;
    while(n1!=null && n2!=null){
      int sum = n1.val + n2.val + carry;
      int val = sum%10;
      carry = sum/10;
      ListNode node = new ListNode(val);
      if(t1== null){
        t1 = node;
        result=node;
      }
      else{
        t1.next = node;
        t1 = node;
      }
      n1 = n1.next;
      n2 = n2.next;
    }
    while(n1!=null){
      int sum = n1.val + carry;
      int val = sum%10;
      carry = sum/10;
      ListNode node = new ListNode(val);
      if(t1== null){
        t1 = node;
        result=node;
      }
      else{
        t1.next = node;
        t1 = node;
      }
      n1 = n1.next;
    }

    while(n2!=null){
      int sum = n2.val + carry;
      int val = sum%10;
      carry = sum/10;
      ListNode node = new ListNode(val);
      if(t1== null){
        t1 = node;
        result=node;
      }
      else{
        t1.next = node;
        t1 = node;
      }
      n2 = n2.next;
    }
    if(carry > 0)  {
      ListNode node = new ListNode(carry);
      t1.next = node;
      t1 = node;
    }
    return result;
  }

}

