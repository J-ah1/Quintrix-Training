package com.my.testing;

import com.my.stuff.Apple;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MyFirstTestingClass {
  @Test
  public void aTest() {
	  Apple greenApple = new Apple("Green");
	  Assert.assertEquals(greenApple.getColor(), "Green");
  }
  @Test
  public void bTest() {
	  Apple redApple = new Apple("Red");
	  Assert.assertEquals(redApple.getColor(), "Green");
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
