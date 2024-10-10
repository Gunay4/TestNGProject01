package US_408;

import Utility.BaseDriver;
import Utility.POM;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class US408_TC01 extends BaseDriver {
    @Test()
    public void listingPatients() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        POM pom=new POM();
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
        POM pom=new POM();
        List<String> patientCount = new ArrayList<>();
        int limit;
        if (pom.pages.isEmpty())
            limit=1;
        else limit=pom.pages.size();
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < pom.patientIds.size(); j++) {
                patientCount
                        .add(pom.patientIds
                                .get(j)
                                .getText()
                                .replace("Recent", ""));
            }
            if (!pom.pages.isEmpty()) {
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
        }
        return patientCount.size();
    }
}
