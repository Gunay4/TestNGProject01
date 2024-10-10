package US_409;

import Utility.BaseDriver;
import Utility.POM;
import Utility.Tools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class US409_TC01 extends BaseDriver {
     private static String id1="";
     private static String id2="";

    @Test(dataProvider = "userData")
    public void PatientRegistration(String admin, String password, String name, String middlename, String familyname, String genders, String days, String Months,
                                    String yearss, String addres, String phoneNumder, int reletiveshipType, String relativeShipname) {

        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        POM pom=new POM();
        pom.userName.sendKeys(admin);
        pom.password.sendKeys(password);
        pom.randomLocation.get((int) (Math.random() * pom.randomLocation.size())).click();
        pom.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pom.registerPatient)).click();
        wait.until(ExpectedConditions.visibilityOf(pom.name)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(pom.middleName)).sendKeys(middlename);
        wait.until(ExpectedConditions.visibilityOf(pom.familyName)).sendKeys(familyname);
        pom.nextButton.click();

        Select gender = new Select(pom.selectGender);
        gender.selectByVisibleText(genders);
        wait.until(ExpectedConditions.elementToBeClickable(pom.nextButton)).click();

        wait.until(ExpectedConditions.visibilityOf(pom.day)).sendKeys(days);
        wait.until(ExpectedConditions.visibilityOf(pom.selectMonth));
        Select months = new Select(pom.selectMonth);
        months.selectByVisibleText(Months);
        wait.until(ExpectedConditions.visibilityOf(pom.year)).sendKeys(yearss);
        pom.nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(pom.adress)).sendKeys(addres);
        pom.nextButton.click();


        wait.until(ExpectedConditions.visibilityOf(pom.phoneNumber)).sendKeys(phoneNumder);
        pom.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pom.relationshipSelect));
        Select relationships = new Select(pom.relationshipSelect);
        relationships.selectByIndex(reletiveshipType);
        pom.relationshipName.sendKeys(relativeShipname);
        pom.nextButton.click();
        pom.confirm.click();

        wait.until(ExpectedConditions.visibilityOf(pom.individualId));

       if (id1.isEmpty()){
           id1=pom.individualId.getText();

       }else {
           id2 = pom.individualId.getText();
       }


        Tools.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(pom.logOut)).click();


    }

    @Test(dependsOnMethods = {"PatientRegistration"})
    public void PatientRecordMerge() {
        POM pom=new POM();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        pom.userName.sendKeys("admin");
        pom.password.sendKeys("Admin123");
        pom.inpatientLocation.click();
        pom.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pom.dataManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.mergePatient)).click();

        wait.until(ExpectedConditions.visibilityOf(pom.patienIdtextBox1)).sendKeys(id1);
        wait.until(ExpectedConditions.visibilityOf(pom.patientIdtextBox2)).sendKeys(id2);
        actions.moveToLocation(750,420).click().build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(pom.confirmBtn)).click();

        wait.until(ExpectedConditions.visibilityOf(pom.warningMessage));
        Assert.assertTrue(pom.warningMessage.getText().contains("Merging cannot be undone"));
        wait.until(ExpectedConditions.elementToBeClickable(pom.firstPatientBox)).click();
        js.executeScript("arguments[0].scrollIntoView(true);", pom.confirmBtn);
        pom.confirmBtn.click();
        wait.until(ExpectedConditions.visibilityOf(pom.allId));
        Assert.assertTrue(pom.allId.isDisplayed());


    }

    @DataProvider
    Object[][] userData() {
        Object[][] userInfo = {
                {"admin", "Admin123", "Adams", "Harwerd", "Edward", "Male", "22", "April", "1999", "Ashforth St Nottingham NG3 4SS", "(555)232 434 666", 2, "Sarah Brown"},
                {"admin", "Admin123", "Julia", "Crasery", "alfred", "Female", "21", "March", "1983", "Wahsatch Ave Colorado Springs", "(553)355 7741 122", 4, "Melissa Sánchez"}

        };
        return userInfo;
    }


}
