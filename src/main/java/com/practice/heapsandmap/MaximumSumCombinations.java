package com.practice.heapsandmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

public class MaximumSumCombinations {

  public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {

//    MaxPairSum(A,B,C);
    Collections.sort(A,Comparator.reverseOrder());
    Collections.sort(B,Comparator.reverseOrder());

    ArrayList<Integer> result = new ArrayList();
    int first =0;
    while (C>0 && first<A.size()){
      int second =0;
      while (C>0 && second<B.size()){
        result.add(A.get(first)+B.get(second));
        second++;
      }
      first++;
    }
    return result;

  }


  public static  ArrayList<Integer> MaxPairSum(ArrayList<Integer> A, ArrayList<Integer> B,
      int N, int K)
  {

    ArrayList<Integer> result = new ArrayList();
    // sort both arrays A and B
    Collections.sort(A);
    Collections.sort(B);

    // Max heap which contains Pair of
    // the format (sum, (i, j)) i and j are
    // the indices of the elements from
    // array A and array B which make up the sum.
    PriorityQueue<PairSum> sums
        = new PriorityQueue<PairSum>();

    // pairs is used to store the indices of
    // the  Pair(i, j) we use pairs to make sure
    // the indices doe not repeat inside max heap.
    HashSet<Pair> pairs = new HashSet<Pair>();

    // initialize the heap with the maximum sum
    // combination ie (A[N - 1] + B[N - 1])
    // and also push indices (N - 1, N - 1) along
    // with sum.
    int l = N - 1;
    int m = N - 1;
    pairs.add(new Pair(l, m));
    sums.add(new PairSum(A.get(l) + B.get(m), l, m));

    // iterate upto K
    for (int i = 0; i < K; i++)
    {
      // Poll the element from the
      // maxheap in theformat (sum, (l,m))
      PairSum max = sums.poll();
      result.add(max.sum);
      l = max.l - 1;
      m = max.m;
      // insert only if l and m are greater
      // than 0 and the pair (l, m) is
      // not already present inside set i.e.
      // no repeating pair should be
      // present inside the heap.
      if (l >= 0 && m >= 0
          && !pairs.contains(new Pair(l, m)))
      {
        // insert (A[l]+B[m], (l, m))
        // in the heap
        sums.add(new PairSum(A.get(l)
            + B.get(m), l, m));
        pairs.add(new Pair(l, m));
      }

      l = max.l;
      m = max.m - 1;

      // insert only if l and m are
      // greater than 0 and
      // the pair (l, m) is not
      // already present inside
      // set i.e. no repeating pair
      // should be present
      // inside the heap.
      if (l >= 0 && m >= 0
          && !pairs.contains(new Pair(l, m)))
      {
        // insert (A[i1]+B[i2], (i1, i2))
        // in the heap
        sums.add(new PairSum(A.get(l)
            + B.get(m), l, m));
        pairs.add(new Pair(l, m));
      }
    }
    return result;
  }


  public static class Pair {

    public Pair(int l, int m)
    {
      this.l = l;
      this.m = m;
    }

    int l;
    int m;

    @Override public boolean equals(Object o)
    {
      if (o == null) {
        return false;
      }
      if (!(o instanceof Pair)) {
        return false;
      }
      Pair obj = (Pair)o;
      return (l == obj.l && m == obj.m);
    }

    @Override public int hashCode()
    {
      return Objects.hash(l, m);
    }
  }


  public static class PairSum
      implements Comparable<PairSum> {

    public PairSum(int sum, int l, int m)
    {
      this.sum = sum;
      this.l = l;
      this.m = m;
    }

    int sum;
    int l;
    int m;

    @Override public int compareTo(PairSum o)
    {
      return Integer.compare(o.sum, sum);
    }
  }


}
