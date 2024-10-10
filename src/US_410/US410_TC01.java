package US_410;

import Utility.BaseDriver;
import Utility.POM;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;

public class US410_TC01 extends BaseDriver {

    @Test
    public void IncorrectSystemTimezoneduringAppointmentBooking() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        POM pom=new POM();
        pom.userName.sendKeys("admin");
        pom.password.sendKeys("Admin123");
        pom.inpatientLocation.click();
        pom.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pom.appointmentScheduling)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.manageAppointment)).click();
        wait.until(ExpectedConditions.visibilityOf(pom.patientSearch)).sendKeys("100JWH");
        wait.until(ExpectedConditions.visibilityOf(pom.listFirst)).click();
        ZonedDateTime zdt = ZonedDateTime.now();

        if (!String.valueOf(zdt.getZone()).equals("Etc/UTC")){
            wait.until(ExpectedConditions.visibilityOf(pom.dateMessage));
        }
        if (!String.valueOf(zdt.getZone()).equals("Etc/UTC")) {
            Assert.assertTrue(pom.dateMessage.getText().contains("restart your browser"));
        }
    }
}

