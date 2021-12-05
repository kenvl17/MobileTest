/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.pages;

import static com.test.pages.BasePage.waitAndThenEnterData;
import io.appium.java_client.android.AndroidDriver;

/**
 *
 * @author kentvanlim
 */
public class RegisterPage extends BasePage {

    String randomString = generateRandomString(3);

    public void clickRegister(AndroidDriver driver) {
        waitAndThenClick(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/textViewLinkRegister");
    }

    public void inputName(AndroidDriver driver) {
        waitAndThenEnterData(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/textInputEditTextName", "kent");
    }

    public void inputEmail(AndroidDriver driver,String keywords) {
        waitAndThenEnterData(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/textInputEditTextEmail", randomString+keywords);
    }

    public Boolean validateLoginAfterRegister(AndroidDriver driver) {
        Boolean status = validateElementPresent(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/appCompatButtonLogin");
        return status;
    }

    public void inputPassword(AndroidDriver driver) {
        waitAndThenEnterData(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/textInputEditTextPassword", "Login1234");
    }

    public void reinputPassword(AndroidDriver driver) {
        waitAndThenEnterData(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/textInputEditTextConfirmPassword", "Login1234");
    }

    public void clickButtonRegister(AndroidDriver driver) {
        waitAndThenClick(driver, BasePage.ByLocator.uiselector, "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.loginmodule.learning:id/appCompatTextViewLoginLink\"))");
    }

    public Boolean validateErrorInvalidEmail(AndroidDriver driver) {
        Boolean status = validateElementPresent(driver, BasePage.ByLocator.uiselector, ".text(\"Enter Valid Email\")");
        return status;
    }

}
