package US_403;

import Utility.BaseDriver;
import Utility.POM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03 extends BaseDriver {

    @Test
    public void LogOut (){

        driver.get("https://openmrs.org");
        POM pom = new POM();

        wait.until(ExpectedConditions.visibilityOf(pom.changeLanguageBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.englishBtn));
        pom.englishBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.demoBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.exploreOpenMRS2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.entertheOpenMRS2Demo));
        js.executeScript("arguments[0].click();",pom.entertheOpenMRS2Demo);

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        pom.userName.sendKeys("admin");
        pom.password.sendKeys("Admin123");

        int randomIndex = (int) (Math.random() * pom.randomLocation.size());
        WebElement selectedLocationElement = pom.randomLocation.get(randomIndex);
        String selectedLocationText = selectedLocationElement.getText();
        selectedLocationElement.click();

        pom.loginButton.click();




        //Degisiklik yapilacak bolum
        PomClass3 pom1 = new PomClass3();
        wait.until(ExpectedConditions.visibilityOf(pom1.selectedLocation));
        String displayedLocationText = pom1.selectedLocation.getText();





        Assert.assertEquals(selectedLocationText, displayedLocationText, "Seçilen ve görüntülenen location eşleşmiyor!");

        wait.until(ExpectedConditions.elementToBeClickable(pom.logOut)).click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));

        driver.quit();
    }
}
