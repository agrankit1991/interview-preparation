package com.learning.patterns.creational.singleton;

public class Singleton2 {
  private static volatile Singleton2 instance;

  private Singleton2() {
  }

  public static Singleton2 getInstance() {
    if (instance == null) {
      synchronized (Singleton2.class) {
        if (instance == null) {
          instance = new Singleton2();
        }
      }
    }
    return instance;
  }

  public void perform() {
    System.out.println("From Singleton2");
  }

  public static void main(String[] args) {
    Singleton2 singleton2 = Singleton2.getInstance();
    singleton2.perform();
  }
}
