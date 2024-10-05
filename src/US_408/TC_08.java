package US_408;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TC_08 extends BaseDriver {
    @Test
    public void listingPatients() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        PomClass8 pom = new PomClass8();
        pom.userName.sendKeys("admin");
        pom.password.sendKeys("Admin123");
        pom.randomLocation.get((int) (Math.random() * (pom.randomLocation.size()))).click();
        pom.loginButton.click();
        pom.findPatientRecord.click();
        int totalEntries = Integer.parseInt(pom.entries
                .getText()
                .substring(pom.entries
                        .getText()
                        .indexOf("of"))
                .replaceAll("[^0-9]", ""));
        Assert.assertTrue(totalEntries == TotalPatient()
                , "Total patient count doesn't match total entries.");

        pom.returnToHomePage.click();
        pom.logOut.click();
    }

    public int TotalPatient() {
        PomClass8 pom = new PomClass8();
        List<String> patientCount = new ArrayList<>();
        for (int i = 0; i < pom.pages.size(); i++) {
            for (int j = 0; j < pom.patientIds.size(); j++) {
                patientCount
                        .add(pom.patientIds
                                .get(j)
                                .getText()
                                .replace("Recent", ""));
            }
            pom.pages.get(i).click();
            if (i == pom.pages.size() - 1) {
                for (int j = 0; j < pom.patientIds.size(); j++) {
                    patientCount
                            .add(pom.patientIds
                                    .get(j)
                                    .getText()
                                    .replace("Recent", ""));
                }
            }
        }
        return patientCount.size();
    }
}
