package US_407;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TC_07 extends BaseDriver {
    @Test
    public void deletingPatientRecord() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        PomClass7 pom = new PomClass7();
        pom.userName.sendKeys("admin");
        pom.password.sendKeys("Admin123");
        pom.randomLocation.get((int) (Math.random() * (pom.randomLocation.size()))).click();
        pom.loginButton.click();
        pom.findPatientRecord.click();
        pom.patientSearch.sendKeys(PatientSearchInfos());
        pom.patientsFound.get((int) (Math.random() * (pom.patientsFound.size()))).click();
        String id = pom.individualId.getText();
        for (int i = 0; i < pom.generalActions.size(); i++) {
            if (pom.generalActions.get(i).getText().contains("Delete Patient")) {
                pom.generalActions.get(i).click();
                break;
            }
        }
        pom.deleteReason.sendKeys(DeleteReason());
        pom.deleteConfirm.click();
        pom.patientSearch.clear();
        pom.patientSearch.sendKeys(id);
        Assert.assertTrue(!pom.noRecordsFound.isEmpty()
                , "Patient record couldn't deleted.");
        pom.returnToHomePage.click();
        pom.logOut.click();
    }

    public String PatientSearchInfos() {
        PomClass7 pom = new PomClass7();
        List<String> patientSearchInfos = new ArrayList<>();
        for (int i = 0; i < pom.pages.size(); i++) {
            for (int j = 0; j < pom.patientIds.size(); j++) {
                patientSearchInfos.add(pom.patientIds
                        .get(j)
                        .getText()
                        .replace("Recent", ""));
                patientSearchInfos.add(pom.patientNames
                        .get(j)
                        .getText());
            }
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
        String randomInfo = patientSearchInfos.get((int) ((Math.random()) * (patientSearchInfos.size())));
        return randomInfo;
    }

    public String DeleteReason() {
        List<String> deleteReason = new ArrayList<>();
        deleteReason.add("Privacy");
        deleteReason.add("Incorrect Information");
        deleteReason.add("Association Error");
        deleteReason.add("Deceased");
        deleteReason.add("Patient Request");
        deleteReason.add("Legal Reasons");
        deleteReason.add("Security Breach");
        deleteReason.add("Database Issue");

        String randomReason = deleteReason.get((int) ((Math.random()) * (deleteReason.size())));
        return randomReason;
    }
}
