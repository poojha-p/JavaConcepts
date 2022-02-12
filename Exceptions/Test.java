package com.comp301.a03exceptions;

import java.util.ArrayList;
import java.util.List;

public class Test {
  private static List<String> lines;

  public static void main(String args[]) {
    methodA();
  }

  public static void methodA() {
    try {
      System.out.print("a");
      methodB();
      System.out.print("b");
    } catch (ArithmeticException e) {
      System.out.print("c");
    } finally{
      System.out.print("d");
    }
  }

  public static void methodB() {
    try {
      System.out.print("e");
      methodC();
      System.out.print("f");
    } catch (RuntimeException e) {
      System.out.print("g");
    } finally{
      System.out.print("h");
    }
  }

  public static void methodC() {
    try {
      System.out.print("i");
      lines.add("Made it to method c!");
      System.out.print("j");
    } catch (ArithmeticException e) {
      System.out.print("l");
    } finally{
      System.out.print("m");
    }
  }
}
