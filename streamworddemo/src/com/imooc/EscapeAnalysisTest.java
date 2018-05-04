package com.imooc;

public class EscapeAnalysisTest {
  private static class Foo {
      private int x;
      private static int counter;
      public Foo() {
          x = (++counter);
      }
  }
  public static void main(String[] args) {
      long start = System.nanoTime();
      for (int i = 0; i < 1000 * 1000 * 10; ++i) {
          Foo foo = new Foo();
          test(foo);
      }
      long end = System.nanoTime();
      System.out.println("Time cost is " + (end - start));
  }
  private static void test(Foo foo) {
    // TODO Auto-generated method stub
    
  }
}