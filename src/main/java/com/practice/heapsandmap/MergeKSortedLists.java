package com.practice.heapsandmap;

import com.practice.linkedlist.LinkListUtils;
import com.practice.linkedlist.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ListNodeK{
  ListNode node;
  int k;

  public ListNodeK(ListNode node, int k) {
    this.node = node;
    this.k = k;
  }
}
public class MergeKSortedLists {

  public static void main(String[] args) {
    ListNode l1 =LinkListUtils.getLinkedListFromArray(Arrays.asList(1,10,20));
    ListNode l2 =LinkListUtils.getLinkedListFromArray(Arrays.asList(4,11,13));
    ListNode l3 =LinkListUtils.getLinkedListFromArray(Arrays.asList(3,8,9));
    ArrayList<ListNode> a = new ArrayList<>();
    a.add(l1);
    a.add(l2);
    a.add(l3);
    MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
    ListNode r =mergeKSortedLists.mergeKLists(a);
    LinkListUtils.print(r);

  }


  public ListNode mergeKLists(ArrayList<ListNode> a) {
    PriorityQueue<ListNodeK> heap = new PriorityQueue((l1,l2)->{
      return ((ListNodeK)l1).node.val - ((ListNodeK)l2).node.val;
    });
    Map<Integer,ListNode> headMap = new HashMap<>();
    int k=a.size()-1;
    ListNode result=null;
    ListNode last=null;
    while (k>=0){
      headMap.put(k,a.get(k));
      heap.add(new ListNodeK(headMap.get(k),k));
      k--;
    }
    while (!heap.isEmpty()){
      ListNodeK listNodeK = heap.poll();
      if(result==null){
        result=listNodeK.node;
        last=listNodeK.node;
      }
      else{
        last.next = listNodeK.node;
        last = last.next;
      }
      headMap.put(listNodeK.k,listNodeK.node.next);
      ListNode next = headMap.get(listNodeK.k);
      if(next!=null){
        heap.add(new ListNodeK(next,listNodeK.k));
      }
    }
    return result;
  }

}
