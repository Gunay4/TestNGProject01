package US_402;

import Utility.BaseDriver;
import Utility.POM;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US402_TC01 extends BaseDriver {
    @Test(dataProvider = "usersData")
    public void sixDifferentUnsuccessfulLogins(String username, String password, int location) {
        POM pom = new POM();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        if (!pom.userName.getText().isEmpty())
            pom.userName.clear();
        else
            pom.userName.sendKeys(username);
        pom.password.clear();
        pom.password.sendKeys(password);

        if (location <= 5)
            pom.randomLocation.get(location).click();

        pom.loginButton.click();
    }

    @DataProvider
    Object[][] usersData() {

        Object[][] userInfo = {
                {"afds", "56756", 7},
                {"kjlj", "Admin123", 0},
                {"admin", "000", 3},
                {"", "", 7},
                {"", "", 4},
                {"admin", "Admin123", 7},
        };
        return userInfo;
    }

    @Test(dependsOnMethods = {"sixDifferentUnsuccessfulLogins"})
    public void PerformLoginInTheSystem() {
        POM pom = new POM();

        driver.get("https://openmrs.org");


        wait.until(ExpectedConditions.visibilityOf(pom.changeLanguageBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.englishBtn));
        pom.englishBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.demoBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.exploreOpenMRS2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.entertheOpenMRS2Demo));
        js.executeScript("arguments[0].click();", pom.entertheOpenMRS2Demo);
        wait.until(ExpectedConditions.urlContains("login"));
        wait.until(ExpectedConditions.elementToBeClickable(pom.userName)).sendKeys("admin");
        wait.until(ExpectedConditions.elementToBeClickable(pom.password)).sendKeys("Admin123");


        pom.inpatientLocation.click();
        pom.loginButton.click();
    }

}
