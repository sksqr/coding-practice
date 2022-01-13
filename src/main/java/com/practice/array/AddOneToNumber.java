package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOneToNumber {

  public static void main(String[] args) {
    AddOneToNumber addOneToNumber = new AddOneToNumber();
    List<Integer> list = Arrays.asList(0);
    System.out.println(addOneToNumber.plusOne(new ArrayList<>(list)));
  }


  public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    ArrayList<Integer> result = new ArrayList<>();
    int carry=1;
    int n=A.size();
    for(int i=n-1;i>=0;i--){
      if(carry!=0){
        int add = A.get(i)+carry;
        int val = add%10;
        carry = add/10;
        A.set(i,val);
      }
      else{
        break;
      }
    }
    if(carry!=0){
      result.add(carry);
      result.addAll(A);
    }
    else{
      int i=0;
      while (A.get(i)==0 && i<n){
        i++;
      }

      result.addAll(A.subList(i,A.size()));

    }


    return result;
  }

}
