package com.practice.heapsandmap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class SumPair{
  int sum;
  int i;
  int j;
  SumPair(int a, int b, int c){
    i=a;
    j=b;
    sum=c;
  }
}
public class NMaxPairCombinations {

  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(3, 2, 4, 2);
    List<Integer> list2 = Arrays.asList(4, 3, 1, 2);
    NMaxPairCombinations nMaxPairCombinations =  new NMaxPairCombinations();
    System.out.println(nMaxPairCombinations.solve(new ArrayList<>(list1), new ArrayList<>(list2)));
  }


  public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    int N=A.size();
    Collections.sort(A);
    Collections.sort(B);
    PriorityQueue<SumPair> sums = new PriorityQueue((p1,p2)->{
      p1 = (SumPair)p1;
      p2 = (SumPair)p2;
      return ((SumPair) p2).sum- ((SumPair) p1).sum;
    });
    Set<String> set = new HashSet();
    int l = N - 1;
    int m = N - 1;
    sums.add(new SumPair(l, m,A.get(l)+B.get(m)));
    set.add(l+":"+m);
    // iterate upto K
    int K=N;
    ArrayList<Integer> result= new ArrayList();
    for (int i = 0; i < K; i++)
    {
      // Poll the element from the
      // maxheap in theformat (sum, (l,m))
      SumPair max = sums.poll();
      result.add(max.sum);
      l = max.i - 1;
      m = max.j;
      String key = l+":"+m;
      // insert only if l and m are greater
      // than 0 and the SumPair (l, m) is
      // not already present inside set i.e.
      // no repeating SumPair should be
      // present inside the heap.
      if (l >= 0 && m >= 0
          && !set.contains(key))
      {
        // insert (A[l]+B[m], (l, m))
        // in the heap
        sums.add(new SumPair(l, m,A.get(l)+B.get(m)));
        set.add(key);
      }

      l = max.i;
      m = max.j - 1;
      key = l+":"+m;
      // insert only if l and m are
      // greater than 0 and
      // the SumPair (l, m) is not
      // already present inside
      // set i.e. no repeating SumPair
      // should be present
      // inside the heap.
      if (l >= 0 && m >= 0
          && !set.contains(key))
      {
        // insert (A[i1]+B[i2], (i1, i2))
        // in the heap
        sums.add(new SumPair(l, m,A.get(l)+B.get(m)));
        set.add(key);
      }
    }

    return result;
  }
}

