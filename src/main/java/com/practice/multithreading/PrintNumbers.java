package com.practice.multithreading;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class PrintNumbers {

  public static void main(String[] args) {

    CountDownLatch countDownLatch = new CountDownLatch(1);
    countDownLatch.countDown();

    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ReentrantLock lock = new ReentrantLock();



    System.out.println("CPU:"+Runtime.getRuntime().availableProcessors());


    ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(6);
    IntConsumer intConsumer = new IntConsumer() {
      @Override
      public void accept(int i) {
        System.out.print(i);
      }
    };

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          zeroEvenOdd.zero(intConsumer);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          zeroEvenOdd.even(intConsumer);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });


    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          zeroEvenOdd.odd(intConsumer);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    t1.start();
    t2.start();
    t3.start();

  }

}



class ZeroEvenOdd {
  private int n;

  volatile int odd=1;
  volatile int even=2;
  volatile int total=0;

  ReentrantLock lock = new ReentrantLock();



  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    while(total<2*n){
      lock.lock();
      if(total<2*n && (total%4==0 || total%4==2) )
      {
        printNumber.accept(0);
        total++;
      }
      lock.unlock();
    }
    System.exit(1);
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    while(total<2*n){
      lock.lock();
      if(total<2*n && (total%4==3) )
      {
        printNumber.accept(even);
        even=even+2;
        total++;
      }
      lock.unlock();
    }
    System.exit(1);
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    while(total<2*n){
      lock.lock();
      if(total<2*n && (total%4==1) )
      {
        printNumber.accept(odd);
        odd = odd+2;
        total++;
      }
      lock.unlock();
    }
    System.exit(1);

  }

}
