package US_408;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PomClass8 {
    public PomClass8() {
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

    @FindBy(css = "[id='patient-search-results-table_info']")
    public WebElement entries;

    @FindBy(css = "[class='fg-button ui-button ui-state-default']")
    public List<WebElement> pages;

    @FindBy(css = "[role='alert']>tr> :nth-child(1)")
    public List<WebElement> patientIds;

    @FindBy(css = "[class='icon-home small']")
    public WebElement returnToHomePage;

    @FindBy(css = "[class='nav-item logout']>a")
    public WebElement logOut;

}
