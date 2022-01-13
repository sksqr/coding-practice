package com.practice.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HitsAndCapacity{
  ArrayList<Integer> hits;
  int capacity;
  HitsAndCapacity(ArrayList<Integer> h, int c){
    hits=h;
    capacity=c;
  }
}
public class TusharBirthdayBombs {

  Map<String,HitsAndCapacity> map = new HashMap<>();

  public static void main(String[] args) {
    TusharBirthdayBombs tusharBirthdayBombs = new TusharBirthdayBombs();
    List<Integer> list = Arrays.asList(17786, 11924, 22802, 13344, 10395, 10501, 16658, 16430, 2371, 15036, 18699, 20068, 22772, 13935, 5549, 8435, 14181, 5745, 5220, 20377, 2576, 6438, 15791, 21539, 22871, 15132, 24076, 3144, 13938, 4811, 9031, 23067, 8078, 23176, 11402, 18465, 20, 3051, 1238, 2382, 9430, 19928, 13793, 23546, 207, 19333, 23324, 14379, 16422, 3535, 1100, 18989, 9965, 16882, 6871, 24179, 7005, 22290, 2314, 20934, 2093, 11336, 10345, 1514, 855, 21738, 11322, 866, 16133, 3904, 19591, 554, 23823, 8376, 15443, 15373, 19052, 13759, 21096, 1817, 17285, 22187, 20797, 18593, 5412, 2660
);
    List<Integer> aList = Arrays.asList(22692, 19309, 10377, 2225, 7455, 11158, 12946, 8630, 13168, 14312, 21396, 23230, 15051, 21052, 7784, 19786, 19719, 4471, 5395, 879, 4106, 17902, 18426, 17070, 16737, 18833, 19126, 8775, 8867, 20968, 8475, 22902, 15268, 10195, 118, 14066, 21344, 13055, 14039, 9504, 18711, 10426, 7725, 105, 22822, 15501, 19883, 17532 );
    //36 36 36
//    int A=9383;
    int A=1842;

//    System.out.println(tusharBirthdayBombs.solve(A,new ArrayList<>(list)));
    System.out.println(tusharBirthdayBombs.solveGreedy(A, new ArrayList<>(aList)));

  }

  public ArrayList<Integer> solveGreedy(int A, ArrayList<Integer> B) {
    ArrayList<Integer> result = new ArrayList<>();
    int minIndex = 0;
    int i=1;
    while(i<B.size()){
      if(B.get(i)<B.get(minIndex)){
        minIndex=i;
      }
      i++;
    }
    if(B.get(minIndex) <= A){
      int num = A/B.get(minIndex);
      for(int j=0;j<num;j++){
        result.add(minIndex);
      }
      int remainingCap = A - (B.get(minIndex)*num);
      int k=0;
      for(int j=0;j<minIndex && k<result.size();){
        if(B.get(j) <= (B.get(minIndex)+remainingCap)){
          result.set(k,j);
          remainingCap = (B.get(minIndex)+remainingCap) - B.get(j);
          k++;
        }
        else{
          j++;
        }
      }
    }
    return result;
  }

  public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
    // ArrayList<Integer> list = new ArrayList();
    // int i=0;
    // int n=B.size();
    // while(A>=0 && i<n){
    //     if(B.get(i)<A){
    //         list.add(i);
    //         A = A-B.get(i);
    //     }
    //     else{
    //         i++;
    //     }
    // }
    // return list;
    HitsAndCapacity hitCap = hitingOrder(A,B,0,new ArrayList());
    return hitCap.hits;

  }

  private  HitsAndCapacity hitingOrder(int A, ArrayList<Integer> B, int i, ArrayList<Integer> result){
    String key = A+":"+i;
    if (map.get(key)!=null){
      return  map.get(key);
    }
    if(i==B.size() || A==0){
      return new HitsAndCapacity(result,A);
    }
    HitsAndCapacity hitCap = null;
    if(B.get(i)<=A){
      ArrayList<Integer> r1 = new ArrayList();
      r1.addAll(result);
      r1.add(i);
      HitsAndCapacity hitCap1 = hitingOrder(A-B.get(i),B,i,r1);
      ArrayList<Integer> r2 = new ArrayList();
      r2.addAll(result);
      r2.add(i);
      HitsAndCapacity hitCap2 = hitingOrder(A-B.get(i),B,i+1,r2);
      hitCap = getHitsAndCapacity(hitCap1, hitCap2);
    }
    HitsAndCapacity hitCap3 = hitingOrder(A,B,i+1,result);
    if(hitCap!=null){

      map.put(key,getHitsAndCapacity(hitCap,hitCap3));
      return map.get(key);
    }
    map.put(key,hitCap3);
    return hitCap3;
  }

  private HitsAndCapacity getHitsAndCapacity(HitsAndCapacity hitCap1, HitsAndCapacity hitCap2) {
    if(hitCap1.hits.size() > hitCap2.hits.size()){
      return hitCap1;
    }
    else if(hitCap1.hits.size() < hitCap2.hits.size()){
      return hitCap2;
    }
    else {
      if(hitCap1.capacity <= hitCap2.capacity){
        return hitCap1;
      }
      else{
        return hitCap2;
      }

    }
  }


}
