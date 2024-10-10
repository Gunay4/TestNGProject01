package US_401;

import Utility.BaseDriver;
import Utility.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class US401_TC01 extends BaseDriver {

    @Test (dataProvider = "usersData")
    public void IncorrectLogin(String username,String password) {
        driver.get("https://openmrs.org");
        POM pom = new POM();

        wait.until(ExpectedConditions.elementToBeClickable(pom.demoBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.exploreOpenMRS2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.entertheOpenMRS2Demo));
        js.executeScript("arguments[0].click();",pom.entertheOpenMRS2Demo);
        wait.until(ExpectedConditions.urlContains("login"));

        if (!pom.userName.getText().isEmpty())
            pom.userName.clear();
        else
            pom.userName.sendKeys(username);
        pom.password.clear();
        pom.password.sendKeys(password);

        pom.inpatientLocation.click();
        pom.loginButton.click();
    }

    @DataProvider
    Object[][] usersData() {

        Object[][] userInfo = {
                {"invalid", "55555" },
                {"invalid2", "Admin123"},
                {"admin", "111"},
                {"", ""},
                {"", ""},
                {"admin", "Admin123"},
        };
        return userInfo;
    }





    }




