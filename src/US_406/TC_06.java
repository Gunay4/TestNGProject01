package US_406;

import Utility.BaseDriver;
import Utility.POM;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TC_06 extends BaseDriver {
    @Test
    public void searchInPatientList() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        POM pom = new POM();
        pom.userName.sendKeys("admin");
        pom.password.sendKeys("Admin123");
        pom.randomLocation.get((int) (Math.random() * (pom.randomLocation.size()))).click();
        pom.loginButton.click();
        pom.findPatientRecord.click();
        pom.patientSearch.sendKeys(PatientSearchInfos());
        if (!pom.noRecordsFound.isEmpty()) {
            Assert.assertTrue(pom.noRecordsFound
                            .getFirst()
                            .getText()
                            .equals("No matching records found")
                    , "No message found indicating no match.");
        } else if (!pom.deletedPatient.isEmpty()) {
            Assert.assertTrue(pom.deletedPatient
                            .getFirst()
                            .getText()
                            .equals("This patient has been deleted")
                    , "The message indicating that the patient record was deleted could not be displayed.");
        } else {
            pom.patientsFound
                    .getFirst()
                    .click();
            boolean allMatched = false;
            for (int i = 0; i < pom.infoRow.size(); i++) {
                for (WebElement p : pom.infoRow) {
                    if (p.getText().equals(patientInfos().get(i))) {
                        allMatched = true;
                        break;
                    } else allMatched = false;
                }
            }
            Assert.assertTrue(allMatched
                    , "All or part of the patient's info cannot be displayed.");
        }
        pom.returnToHomePage.click();
        pom.logOut.click();
    }

    public List<String> patientInfos() {
        List<String> pI = new ArrayList<>();

        pI.add("DIAGNOSES");
        pI.add("LATEST OBSERVATIONS");
        pI.add("HEALTH TREND SUMMARY");
        pI.add("WEIGHT GRAPH");
        pI.add("VITALS");
        pI.add("APPOINTMENTS");
        pI.add("RECENT VISITS");
        pI.add("FAMILY");
        pI.add("CONDITIONS");
        pI.add("ATTACHMENTS");
        pI.add("ALLERGIES");

        return pI;
    }

    public String PatientSearchInfos() {
        POM pom = new POM();
        List<String> patientSearchInfos = new ArrayList<>();
        int limit;
        if (pom.pages.isEmpty())
            limit=1;
        else limit=pom.pages.size();
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < pom.patientIds.size(); j++) {
                patientSearchInfos.add(pom.patientIds
                        .get(j)
                        .getText()
                        .replace("Recent", ""));
                patientSearchInfos.add(pom.patientNames
                        .get(j)
                        .getText());
            }
            if (!pom.pages.isEmpty()) {
                pom.pages.get(i).click();
                if (i == pom.pages.size() - 1) {
                    for (int j = 0; j < pom.patientIds.size(); j++) {
                        patientSearchInfos.add(pom.patientIds
                                .get(j)
                                .getText().replace("Recent", ""));
                        patientSearchInfos.add(pom.patientNames
                                .get(j)
                                .getText());
                    }
                }
            }
        }
        if (patientSearchInfos.isEmpty())
            return "test";
        else {
            String randomInfo = patientSearchInfos.get((int) ((Math.random()) * (patientSearchInfos.size())));
            return randomInfo;
        }
    }
}
