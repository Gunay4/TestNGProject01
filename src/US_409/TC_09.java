package US_409;

import US_405.PomClass5;
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TC_09 extends BaseDriver {
     private static String id1="";
     private static String id2="";

    @Test(dataProvider = "userData")
    public void PatientRegistration(String admin, String password, String name, String middlename, String familyname, String genders, String days, String Months,
                                    String yearss, String addres, String phoneNumder, int reletiveshipType, String relativeShipname) {

        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        PomClass5 pom5 = new PomClass5();
        PomClass9 pom9 = new PomClass9();
        pom5.userName.sendKeys(admin);
        pom5.password.sendKeys(password);
        pom5.randomLocation.get((int) (Math.random() * pom5.randomLocation.size())).click();
        pom5.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pom9.registerPatient)).click();
        wait.until(ExpectedConditions.visibilityOf(pom9.name)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(pom9.middleName)).sendKeys(middlename);
        wait.until(ExpectedConditions.visibilityOf(pom9.familyName)).sendKeys(familyname);
        pom9.nextButton.click();

        Select gender = new Select(pom9.selectgender);
        gender.selectByVisibleText(genders);
        wait.until(ExpectedConditions.elementToBeClickable(pom9.nextButton)).click();

        wait.until(ExpectedConditions.visibilityOf(pom9.day)).sendKeys(days);
        wait.until(ExpectedConditions.visibilityOf(pom9.selectMonth));
        Select months = new Select(pom9.selectMonth);
        months.selectByVisibleText(Months);
        wait.until(ExpectedConditions.visibilityOf(pom9.year)).sendKeys(yearss);
        pom9.nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(pom9.adress)).sendKeys(addres);
        pom9.nextButton.click();


        wait.until(ExpectedConditions.visibilityOf(pom9.phonenumber)).sendKeys(phoneNumder);
        pom9.nextButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pom9.relationshipSelect));
        Select relationships = new Select(pom9.relationshipSelect);
        relationships.selectByIndex(reletiveshipType);
        pom9.relatinshipName.sendKeys(relativeShipname);
        pom9.nextButton.click();
        pom9.confirm.click();

        wait.until(ExpectedConditions.visibilityOf(pom9.patiantID));

       if (id1.isEmpty()){
           id1=pom9.patiantID.getText();

       }else {
           id2 = pom9.patiantID.getText();
       }


        Tools.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(pom5.logOut)).click();


    }

    @Test(dependsOnMethods = {"PatientRegistration"})
    public void PatientRecordMerge() {
        PomClass5 pom5 = new PomClass5();
        PomClass9 pom9 = new PomClass9();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        pom5.userName.sendKeys("admin");
        pom5.password.sendKeys("Admin123");
        pom9.location.click();
        pom5.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pom9.dataManagement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom9.mergePatient)).click();

        wait.until(ExpectedConditions.visibilityOf(pom9.patienIdtextBox1)).sendKeys(id1);
        wait.until(ExpectedConditions.visibilityOf(pom9.patientIdtextBox2)).sendKeys(id2);
        actions.moveToLocation(750,420).click().build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(pom9.confirmBtn)).click();

        wait.until(ExpectedConditions.visibilityOf(pom9.warningMessage));
        Assert.assertTrue(pom9.warningMessage.getText().contains("Merging cannot be undone"));
        wait.until(ExpectedConditions.elementToBeClickable(pom9.firsPatientBox)).click();
        js.executeScript("arguments[0].scrollIntoView(true);", pom9.confirmBtn);
        pom9.confirmBtn.click();
        wait.until(ExpectedConditions.visibilityOf(pom9.allId));
        Assert.assertTrue(pom9.allId.isDisplayed());


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
