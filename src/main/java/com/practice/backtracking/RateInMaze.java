package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RateInMaze {

  int[][] maze;

  List<Choice> choiceList;

  List<String> allPath;

  public RateInMaze(int[][] maze, List<Choice> choiceList) {
    this.maze = maze;
    this.choiceList = choiceList;
    allPath = new ArrayList<>();
  }

  private void addInAllPath(Stack<String> stack){
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()){
      sb.append(stack.pop()).append("-");
    }
    allPath.add(sb.reverse().toString());
  }

  public static void main(String[] args) {
    int[][] maze = {{1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 1, 1},
                    {1, 0, 1, 1}};

    pathLenthNew(maze);

//    Stack<Character> stack = new Stack<>();
//    System.out.println(pathLenth(maze,0,0,stack));
//    StringBuilder sb = new StringBuilder();
//    while (!stack.isEmpty()){
//      sb.append(stack.pop()).append("-");
//    }
//    System.out.println(sb);
  }


  private static   void pathLenthNew(int[][] maze){

    List<Choice> choiceList = new ArrayList<>();
    choiceList.add(new Choice(0,1,"F"));
    choiceList.add(new Choice(1,0,"D"));
    RateInMaze rateInMaze = new RateInMaze(maze,choiceList);

    rateInMaze.printPath();
  }

  public void printPath(){
    Stack<String> stack = new Stack<>();
    getAnyPossiblePath(0,0,stack);
//    StringBuilder sb = new StringBuilder();
//    while (!stack.isEmpty()){
//      sb.append(stack.pop()).append("-");
//    }
//    System.out.println(sb.reverse());

    System.out.println(allPath);

  }

  private void getAnyPossiblePath(int i, int j, Stack<String> stack){
    if(i==maze.length-1 && j==maze[0].length-1){
      addInAllPath(stack);
//      if(!stack.isEmpty()){
//        stack.pop();
//      }
      return ;
    }
    if(i<0 || j<0 || i>maze.length-1 || j>maze[0].length-1 || maze[i][j]==0){
      if(!stack.isEmpty()){
        stack.pop();
      }
      return ;
    }
    choiceList.forEach(e -> {
      stack.add(e.name);
      getAnyPossiblePath(i+e.i,j+e.j, stack);
    });
  }


}

class Choice{
  int i;
  int j;
  String name;

  public Choice(int i, int j, String name) {
    this.i = i;
    this.j = j;
    this.name = name;
  }



  private static int pathLenth(int[][] maze, int i, int j,Stack<Character> stack){
    if(i==maze.length-1 && j==maze[0].length-1){
      return 0;
    }
    if(i<0 || j<0 || i>maze.length-1 || j>maze[0].length-1 || maze[i][j]==0){
      if(!stack.isEmpty()){
        stack.pop();
      }
      return -1;
    }

    int forwardPath = pathLenth(maze,i,j+1,stack);
    if(forwardPath!=-1){
      stack.add('F');
      return 1+forwardPath;
    }
    int downPath = pathLenth(maze,i+1,j,stack);
    if(downPath!=-1){
      stack.add('D');
      return 1+downPath;
    }
    return -1;
  }
}
