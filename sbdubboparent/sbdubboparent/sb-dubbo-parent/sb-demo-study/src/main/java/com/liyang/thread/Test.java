package com.liyang.thread;

public class Test {
    public static void main(String [] args){
        final SynObj synObj = new SynObj();

      new Thread(new Runnable() {
          @Override
          public void run() {
              synObj.showA();
          }
      }).start();

      new Thread(new Runnable() {
          @Override
          public void run() {
              synObj.showB();
          }
      }).start();

      new Thread(new Runnable() {
          @Override
          public void run() {
              synObj.showC();
          }
      }).start();

    }
}
