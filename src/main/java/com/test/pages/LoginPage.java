/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.pages;

import io.appium.java_client.android.AndroidDriver;

/**
 *
 * @author kentvanlim
 */
public class LoginPage extends BasePage {

    public void sendEmailToLogin(AndroidDriver driver, String keywords) {
        waitAndThenEnterData(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/textInputEditTextEmail", keywords);

    }

    public void sendPasswordToLogin(AndroidDriver driver, String keywords) {
        waitAndThenEnterData(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/textInputEditTextPassword", keywords);
    }

    public void buttonLogin(AndroidDriver driver) {
        waitAndThenClick(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/appCompatButtonLogin");

    }

    public Boolean getErrorMessageLogin(AndroidDriver driver) {
        Boolean status = validateElementPresent(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/snackbar_text");
        return status;
    }

    public Boolean verifyAccountAfterLogin(AndroidDriver driver) {
        Boolean status = validateElementPresent(driver, BasePage.ByLocator.id,
                "com.loginmodule.learning:id/textViewEmail");
        return status;
    }
}
