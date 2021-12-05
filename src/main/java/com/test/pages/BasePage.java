/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author kentvanlim
 */
public class BasePage {

    public static enum ByLocator {
        xpath, id, uiselector
    };

    public static void waitAndThenEnterData(AndroidDriver driver, ByLocator loc, String locator, String keywords) {
        try {
            switch (loc) {
                case xpath:
                    AndroidElement elementXpath = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                    elementXpath.sendKeys(keywords);
                    break;
                case id:
                    AndroidElement elementId = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                    elementId.sendKeys(keywords);
                    break;
                case uiselector:
                    AndroidElement elementUiAutomator = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
                    elementUiAutomator.sendKeys(keywords);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void waitAndThenGetText(AndroidDriver driver, ByLocator loc, String locator) {
        try {
            switch (loc) {
                case xpath:
                    AndroidElement elementXpath = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                    elementXpath.getText();
                    break;
                case id:
                    AndroidElement elementId = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                    elementId.getText();
                    break;
                case uiselector:
                    AndroidElement elementUiAutomator = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
                    elementUiAutomator.getText();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean validateElementPresent(AndroidDriver driver, ByLocator loc, String locator) {
        try {
            switch (loc) {
                case xpath:
                    AndroidElement elementXpath = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                    elementXpath.isDisplayed();
                    break;
                case id:
                    AndroidElement elementId = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                    elementId.isDisplayed();
                    break;
                case uiselector:
                    AndroidElement elementUiAutomator = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
                    elementUiAutomator.isDisplayed();
                    break;
            }
                return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
   public static String generateRandomString(int length)
	{
		Random rd = new Random();
		String aphaNumericString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(length);
		
		for (int i = 0; i < length; i++)
		{
			sb.append(aphaNumericString.charAt(rd.nextInt(aphaNumericString.length())));
		}
		return sb.toString();
	}
   
    public static void waitAndThenClick(AndroidDriver driver, ByLocator loc, String locator) {
        try {
            switch (loc) {
                case xpath:
                    AndroidElement elementXpath = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                    elementXpath.click();
                    break;
                case id:
                    AndroidElement elementId = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                    elementId.click();
                    break;
                case uiselector:
                    AndroidElement elementUiAutomator = (AndroidElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
                    elementUiAutomator.click();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
