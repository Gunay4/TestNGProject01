package US_401;

import Utility.BaseDriver;
import Utility.POM;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class US401_TC01 extends BaseDriver {


    @Test
    public void Login() {
        POM pom = new POM();
        driver.get("https://openmrs.org");


        wait.until(ExpectedConditions.visibilityOf(pom.changeLanguageBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.englishBtn));
        pom.englishBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.demoBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.exploreOpenMRS2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.entertheOpenMRS2Demo));
        js.executeScript("arguments[0].click();",pom.entertheOpenMRS2Demo);
        wait.until(ExpectedConditions.urlContains("login"));


    }

    @Test(dataProvider = "usersData",dependsOnMethods = {"Login"})
    public void IncorrectLogin(String username, String password) {
         POM pom=new POM();
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
                {"invalid", "55555"},
                {"invalid2", "Admin123"},
                {"admin", "111"},
                {"", ""},
                {"", ""},
                {"admin", "Admin123"},
        };
        return userInfo;
    }


}




