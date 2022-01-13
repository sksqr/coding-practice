package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointsOnTheStraightLine {


  public static void main(String[] args) {
    List<Integer> x = Arrays.asList(1,2,1,3,2);
    List<Integer> y = Arrays.asList(1,2,2,3,3);
    ArrayList<Integer> a = new ArrayList<>(x);
    ArrayList<Integer> b = new ArrayList<>(y);

    PointsOnTheStraightLine pointsOnTheStraightLine = new PointsOnTheStraightLine();
    System.out.println(pointsOnTheStraightLine.maxPoints(a,b));
  }

  public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
    int n=a.size();
    Map<Double,Integer> map = new HashMap<>();
    int verticalLines =1;
    int max=0;
    for(int i=0;i<n;i++){
      int x1 = a.get(i);
      int y1 = b.get(i);
      for(int j=i+1;j<n;j++){
        int x2 = a.get(j);
        int y2 = b.get(j);
        if(isVertical(x1,x2)){
          verticalLines++;
        }
        else  {
          double slope = getSlope(x1,y1,x2,y2);
          if(map.get(slope)==null){
            map.put(slope,0);
          }
          map.put(slope,map.get(slope)+1);
          if(map.get(slope)>max){
            max = map.get(slope);
          }
        }
      }
    }
    return Math.max(max,verticalLines);
  }

  private double getSlope(int x1, int y1, int x2, int y2){
    return (y1-y2)/(x1-x2);
  }

  private boolean isVertical(int x1, int x2){
    return x1==x2;
  }
}
