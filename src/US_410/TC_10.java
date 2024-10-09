package US_410;

import US_405.PomClass5;
import US_406.PomClass6;
import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class TC_10 extends BaseDriver {

    @Test
    public void IncorrectSystemTimezoneduringAppointmentBooking() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        PomClass5 pom5 = new PomClass5();
        PomClass6 pom6 = new PomClass6();
        pom5.userName.sendKeys("admin");
        pom5.password.sendKeys("Admin123");
        pom5.inpatientLocation.click();
        pom5.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pom5.AppointmentScheduling)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom5.manageAppointment)).click();
        wait.until(ExpectedConditions.visibilityOf(pom6.patientSearch)).sendKeys("100JWH");
        wait.until(ExpectedConditions.visibilityOf(pom5.listFirst)).click();
        ZonedDateTime zdt = ZonedDateTime.now();
        if (!zdt.getZone().equals("UTC")) {
         Assert.assertTrue(pom5.dateMessage.getText().contains("restart your browser"));
        }
    }
}

