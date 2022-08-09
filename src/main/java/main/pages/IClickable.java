package main.pages;

import org.openqa.selenium.By;

public interface IClickable {

  By getSelector();

  boolean isClickWithKeyboard();
}
