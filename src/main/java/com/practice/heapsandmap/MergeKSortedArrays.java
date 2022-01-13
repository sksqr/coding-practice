package com.practice.heapsandmap;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
  int val;
  int posrow;
  int poscol;
  public Pair(int val,int posrow,int poscol){
    this.val=val;
    this.posrow=posrow;
    this.poscol=poscol;
  }

}
class cmp implements Comparator<Pair> {
  public int compare(Pair a,Pair b){
    return a.val-b.val;
  }
}

public class MergeKSortedArrays {

  public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
    ArrayList<Integer> arr=new ArrayList<Integer>();
    int n=A.size();
    PriorityQueue<Pair> pq=new PriorityQueue<>(n,new cmp());

    int k=A.get(0).size();
    for(int i=0;i<A.size();i++){
      pq.add(new Pair(A.get(i).get(0),i,0));
    }
    while(!pq.isEmpty()){
      Pair p=pq.poll();
      int pos=p.posrow;
      arr.add(p.val);
      if(p.poscol+1<k)pq.add(new Pair(A.get(pos).get(p.poscol+1),pos,p.poscol+1));
    }
    return arr;
  }

}
