package com.pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
 public WebDriver driver;
	@FindBy(xpath="(//div[@class=\"_36fx1h _6t1WkM _3HqJxg\"]//div[@class=\"_1YokD2 _3Mn1Gg\"]//div[@class=\"_1AtVbE col-12-12\"]//div[@class=\"_13oc-S\"]//a)[12]") private WebElement productLink ;
	
	
	
	 public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
		}
	 public void clickonProduct() throws InterruptedException {
		 		 productLink.click();
	 }

}
