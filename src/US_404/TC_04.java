package US_404;

import Utility.BaseDriver;
import Utility.POM;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04 extends BaseDriver {

    @Test
    public void PatientRegistration() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        POM pom=new POM();

        pom.userName.sendKeys("admin");
        pom.password.sendKeys("Admin123");
        pom.randomLocation.get((int)(Math.random()*pom.randomLocation.size())).click();

        wait.until(ExpectedConditions.elementToBeClickable(pom.loginButton)).click();
        wait.until((ExpectedConditions.elementToBeClickable(pom.registerPatient))).click();;
        wait.until(ExpectedConditions.visibilityOf(pom.name)).sendKeys("Mehmet");
        wait.until(ExpectedConditions.visibilityOf(pom.middleName)).sendKeys("Akif");
        wait.until(ExpectedConditions.visibilityOf(pom.familyName)).sendKeys("Ersoy");
        pom.nextButton.click();
        Select genders=new Select(pom.selectGender);
        genders.selectByVisibleText("Male");
        pom.nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(pom.day)).sendKeys("01");
        Select months=new Select(pom.selectMonth);
        months.selectByValue("2");
        wait.until(ExpectedConditions.visibilityOf(pom.year)).sendKeys("1995");
        pom.nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(pom.adress)).sendKeys("Yunus Emre sokak Mevlana türbesi yanı");
        pom.nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(pom.phoneNumber)).sendKeys("08765432356");
        pom.nextButton.click();

        Select relations=new Select(pom.relationshipSelect);
        relations.selectByIndex(3);
        wait.until(ExpectedConditions.visibilityOf(pom.relationshipName)).sendKeys("Ahmet Bulut");
        pom.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pom.confirm)).click();
        wait.until(ExpectedConditions.visibilityOf(pom.individualId));
        wait.until(ExpectedConditions.visibilityOf(pom.individualName));
        Assert.assertTrue(pom.individualId.isDisplayed() && pom.individualName.isDisplayed(),"Hasta adı veya Id numarası görüntülenemedi");




    }


}
