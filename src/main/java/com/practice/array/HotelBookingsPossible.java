package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBookingsPossible {

  public static void main(String[] args) {
    ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8));
    ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53));
    HotelBookingsPossible hotelBookingsPossible = new HotelBookingsPossible();
    System.out.println(hotelBookingsPossible.hotel(arrive,depart,23));

  }

  public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    Collections.sort(depart);
    Collections.sort(arrive);
    int n=arrive.size();
    int i=0;
    int j=0;
    int max=0;
    int count=0;
    while(i<n && j<n){
      int a = arrive.get(i);
      int d = depart.get(j);
      if(a==d){
        ;
        i++;
        j++;
      }
      else if(a<d){
        count++;
        if(count>max){
          max=count;
        }
        i++;
      }
      else{
        count--;
        j++;
      }
    }
    while(i<n){
      count++;
      if(count>max){
        max=count;
      }
      i++;
    }
    while(j<n){
      count--;
      j++;
    }
    if(max>K){
      return false;
    }
    return true;
  }

}
