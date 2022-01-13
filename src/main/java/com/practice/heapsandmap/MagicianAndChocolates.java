package com.practice.heapsandmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(2147483647, 2000000014, 2147483647);
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.addAll(list);
    MagicianAndChocolates magicianAndChocolates = new MagicianAndChocolates();
    System.out.println(magicianAndChocolates.nchoc(10,arrayList));
  }

  public int nchoc(int A, ArrayList<Integer> B) {

    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    int n =B.size();
    for(int i=0;i<n;i++){
      queue.add(B.get(i));
    }

    int mod =1000000007;
    int max =0;
    for(int i=0;i<A;i++){
      int chocolates = queue.poll();
      max = (max + chocolates%mod)%mod;
      chocolates = chocolates/2;
      queue.add(chocolates);
    }
    return max;

  }

}


