package US_404;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;

public class TC_04 extends BaseDriver {

    @Test
    public void PatientRegistration() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        PomClass4 pom4=new PomClass4();

        pom4.userName.sendKeys("admin");
        pom4.password.sendKeys("Admin123");
        pom4.randomLocation.get((int)(Math.random()*pom4.randomLocation.size())).click();

        wait.until(ExpectedConditions.elementToBeClickable(pom4.loginButton)).click();
        wait.until((ExpectedConditions.elementToBeClickable(pom4.registerPatient))).click();;
        wait.until(ExpectedConditions.visibilityOf(pom4.name)).sendKeys("Mehmet");
        wait.until(ExpectedConditions.visibilityOf(pom4.middleName)).sendKeys("Akif");
        wait.until(ExpectedConditions.visibilityOf(pom4.familyName)).sendKeys("Ersoy");
        pom4.nextButton.click();
        Select genders=new Select(pom4.selectgender);
        genders.selectByVisibleText("Male");
        pom4.nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(pom4.day)).sendKeys("01");
        Select months=new Select(pom4.selectMonth);
        months.selectByValue("2");
        wait.until(ExpectedConditions.visibilityOf(pom4.year)).sendKeys("1995");
        pom4.nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(pom4.adress)).sendKeys("Yunus Emre sokak Mevlana türbesi yanı");
        pom4.nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(pom4.phonenumber)).sendKeys("08765432356");
        pom4.nextButton.click();

        Select relations=new Select(pom4.relationshipSelect);
        relations.selectByIndex(3);
        wait.until(ExpectedConditions.visibilityOf(pom4.relatinshipName)).sendKeys("Ahmet Bulut");
        pom4.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pom4.confirm)).click();
        wait.until(ExpectedConditions.visibilityOf(pom4.patiantID));
        wait.until(ExpectedConditions.visibilityOf(pom4.confirmPatientName));
        Assert.assertTrue(pom4.patiantID.isDisplayed() && pom4.confirmPatientName.isDisplayed(),"Hasta adı veya Id numarası görüntülenemedi");




    }


}
