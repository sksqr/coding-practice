package com.practice.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree {

  public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    Set<Integer> set3 = new HashSet<>();
    A.forEach(e->set1.add(e));
    B.forEach(e->set2.add(e));
    C.forEach(e->set3.add(e));
    Set<Integer> list = new HashSet<>();

    A.forEach(e->{if(isOccuringInTwo(set1,set2,set3,e)){
        list.add(e);
    }
    });

    B.forEach(e->{if(isOccuringInTwo(set1,set2,set3,e)){
      list.add(e);
    }
    });

    C.forEach(e->{if(isOccuringInTwo(set1,set2,set3,e)){
      list.add(e);
    }
    });

    ArrayList<Integer> result = new ArrayList<>();
    result.addAll(list);
    Collections.sort(result);
    return result;
  }


  private static boolean isOccuringInTwo(Set<Integer> set1,Set<Integer> set2,Set<Integer> set3, Integer n){
    int count=0;
    if(set1.contains(n)){
      count++;
    }
    if(set2.contains(n)){
      count++;
    }
    if(set3.contains(n)){
      count++;
    }
    if(count>=2){
      return true;
    }
    return false;
  }

}
