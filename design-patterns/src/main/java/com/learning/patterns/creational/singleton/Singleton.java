package com.learning.patterns.creational.singleton;

public final class Singleton {

  private Singleton() {
  }

  static class InstanceHolder {
    private static final Singleton INSTANCE = new Singleton();
  }

  public Singleton getInstance() {
    return InstanceHolder.INSTANCE;
  }
}
