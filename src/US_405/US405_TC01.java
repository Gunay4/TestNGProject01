package US_405;


import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US405_TC01 extends BaseDriver {

    @Test
    public void MyAccount() {
        driver.get("https://openmrs.org");
        PomClass5 pom = new PomClass5();

        wait.until(ExpectedConditions.visibilityOf(pom.changeLanguageBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.englishBtn));
        pom.englishBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.demoBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.ExploreOpenMRS2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.EntertheOpenMRS2Demo));
        js.executeScript("arguments[0].click();",pom.EntertheOpenMRS2Demo);
        wait.until(ExpectedConditions.elementToBeClickable(pom.userName)).sendKeys("admin");
        wait.until(ExpectedConditions.elementToBeClickable(pom.password)).sendKeys("Admin123");

        wait.until(ExpectedConditions.urlContains("login"));
        pom.randomLocation.get((int) (Math.random() * pom.randomLocation.size())).click();
        pom.loginButton.click();
        wait.until(ExpectedConditions.urlContains("home"));
        actions.moveToElement(pom.adminBtn).build().perform();
        wait.until(ExpectedConditions.visibilityOf(pom.myAccount));
        Assert.assertTrue(pom.myAccount.isDisplayed());
        pom.myAccount.click();
        wait.until(ExpectedConditions.urlContains("myaccount"));
        Assert.assertTrue(pom.changePassword.getText().contains("Password"));
        Assert.assertTrue(pom.myLanguages.getText().contains("Languages"));

        js.executeScript("arguments[0].click();",pom.changePassword);
        driver.navigate().to("https://demo.openmrs.org/openmrs/adminui/myaccount/myAccount.page");
        pom.myLanguages.click();
        driver.navigate().to("https://demo.openmrs.org/openmrs/adminui/myaccount/myAccount.page");

        pom.returnToHomePage.click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.logOut)).click();
        wait.until(ExpectedConditions.urlContains("login"));







    }
}
