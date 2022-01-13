package com.practice.tree;

import com.google.gson.internal.$Gson$Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class HightAndPlace{
  public int height;
  public int order;

  public HightAndPlace(int height, int order) {
    this.height = height;
    this.order = order;
  }
}

public class OrderOfPeopleHeights {


  public static void main(String[] args) {
    Object[] array;
    List a = Arrays.asList(5, 3 ,2, 6, 1, 4);
    List b = Arrays.asList( 0, 1, 2, 0, 3, 2);
    ArrayList<Integer> A = new ArrayList<>(a);
    ArrayList<Integer> B = new ArrayList<>(b);
    System.out.println(order(A,B));
  }

  public static ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
    int n = A.size();
    List<HightAndPlace> list = new ArrayList<>();
    for(int i=0; i<n;i++){
      list.add(new HightAndPlace(A.get(i),B.get(i)));
    }
    Collections.sort(list, new Comparator<HightAndPlace>() {
      @Override
      public int compare(HightAndPlace hightAndPlace, HightAndPlace t1) {
        return hightAndPlace.height - t1.height;
      }
    });

    for(int i=n-2; i>=0; i--){
      HightAndPlace hightAndPlace = list.get(i);
      if(hightAndPlace.order!=0){
        int k=hightAndPlace.order;
        int j=i;
        while (k>0){
          HightAndPlace temp = list.get(j);
          list.set(j,list.get(j+1));
          list.set(j+1,temp);
          k--;
          j++;
        }
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    for(int i=0; i<n; i++){
      result.add(list.get(i).height);
    }
    return result;
  }
}
