package US_407;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PomClass7 {
    public PomClass7() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(css = "[id='username']")
    public WebElement userName;

    @FindBy(css = "[id='password']")
    public WebElement password;

    @FindBy(css = "[id='sessionLocation']>li")
    public List<WebElement> randomLocation;

    @FindBy(css = "[id='loginButton']")
    public WebElement loginButton;

    @FindBy(css = "[class='icon-search']")
    public WebElement findPatientRecord;

    @FindBy(css = "[class='fg-button ui-button ui-state-default']")
    public List<WebElement> pages;

    @FindBy(css = "[role='alert']>tr> :nth-child(1)")
    public List<WebElement> patientIds;

    @FindBy(css = "[role='alert']>tr> :nth-child(2)")
    public List<WebElement> patientNames;

    @FindBy(css = "[id='patient-search']")
    public WebElement patientSearch;

    @FindBy(css = "[role='alert']>tr")
    public List<WebElement> patientsFound;

    @FindBy(css = " [class='float-sm-right']> :nth-child(2)")
    public WebElement individualId;

    @FindBy(xpath = "//td[text()='No matching records found']")
    public List<WebElement> noRecordsFound;

    @FindBy(css = "[class='col-11 col-lg-10']")
    public List<WebElement> generalActions;

    @FindBy(css = "[id='delete-reason']")
    public WebElement deleteReason;

    @FindBy(css = "[id='delete-patient-creation-dialog'] [class='confirm right']")
    public WebElement deleteConfirm;

    @FindBy(css = "[class='icon-home small']")
    public WebElement returnToHomePage;

    @FindBy(css = "[class='nav-item logout']>a")
    public WebElement logOut;
}
