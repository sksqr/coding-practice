package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderMatrixI {

  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList( 1, 2, 3 );
    List<Integer> list2 = Arrays.asList( 4, 5, 6 );
    List<Integer> list3 = Arrays.asList( 7, 8, 9 );

//    List<Integer> list1 = Arrays.asList( 1);
//    List<Integer> list2 = Arrays.asList( 2 );
//    List<Integer> list3 = Arrays.asList( 3 );



    List<List<Integer>> A = new ArrayList<>();

    A.add(list1);
    A.add(list2);
    A.add(list3);

    System.out.println(spiralOrder(A));


  }


  public static List<Integer> spiralOrder(final List<List<Integer>> A) {
    List<Integer> result = new ArrayList<>();
    int row = A.size();
    if(A.size()==1){
      return A.get(0);
    }
    int col = A.get(0).size();

    int total= row*col;
    int dir = 0;
    int upprerRow=0;
    int bottomRow=row-1;
    int leftColumn=0;
    int rightColumn=col-1;
    while (total>0){

      if(dir==0 && total>0){
        int i=leftColumn;
        while (i<=rightColumn){
          result.add(A.get(upprerRow).get(i));
          i++;
          total--;
        }
        upprerRow++;
        dir = (dir+1)%4;
      }

      if(dir==1 && total>0){
        int i=upprerRow;
        while (i<=bottomRow){
          result.add(A.get(i).get(rightColumn));
          i++;
          total--;
        }
        rightColumn--;
        dir = (dir+1)%4;
      }

      if(dir==2 && total>0){
        int i=rightColumn;
        while (i>=leftColumn){
          result.add(A.get(bottomRow).get(i));
          i--;
          total--;
        }
        bottomRow--;
        dir = (dir+1)%4;
      }


      if(dir==3 && total>0){
        int i=bottomRow;
        while (i>= upprerRow){
          result.add(A.get(i).get(leftColumn));
          i--;
          total--;
        }
        leftColumn++;
        dir = (dir+1)%4;
      }
    }
    return result;
  }

}
