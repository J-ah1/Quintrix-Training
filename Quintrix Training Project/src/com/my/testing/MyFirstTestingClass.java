package com.my.testing;

import com.my.stuff.Apple;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class MyFirstTestingClass {
  @Test
  public void f() {
	  Apple greenApple = new Apple("Apple");
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
