package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class POM {
    public POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    //One POM class to rule them all, one POM class to find them, one POM class to bring them all, and in the Intellij bind them.


    //Login-logout actions

    @FindBy(css = "[class='zak-button']")
    public WebElement demoBtn;

    @FindBy(xpath = "//span[text()='Explore OpenMRS 2']")
    public WebElement exploreOpenMRS2;

    @FindBy(xpath = "//span[text()='Enter the OpenMRS 2 Demo']")
    public WebElement entertheOpenMRS2Demo;

    @FindBy(css = "[class='gt-current-lang']")
    public WebElement changeLanguageBtn;

    @FindBy(css = "[data-gt-lang='en']")
    public WebElement englishBtn;

    @FindBy(css = "[id='username']")
    public WebElement userName;

    @FindBy(css = "[id='password']")
    public WebElement password;

    @FindBy(css = "[id='sessionLocation']>li")
    public List<WebElement> randomLocation;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientLocation;

    @FindBy(css = "[id='loginButton']")
    public WebElement loginButton;

    @FindBy(css = "[class='icon-home small']")
    public WebElement returnToHomePage;

    @FindBy(css = "[class='nav-item logout']>a")
    public WebElement logOut;


    //Header Menu
    @FindBy(css = "[class='icon-user small']")
    public WebElement adminBtn;

    @FindBy(css = "[id='user-account-menu'] a")
    public WebElement myAccount;

    @FindBy(xpath = "(//div[@id='tasks']/a)[1]")
    public WebElement changePassword;

    @FindBy(xpath = "(//div[@id='tasks']/a)[2]")
    public WebElement myLanguages;


    //DashBoard actions

    @FindBy(css = "[class='icon-search']")
    public WebElement findPatientRecord;

    @FindBy(css = "[id='apps'] > :nth-child(6)")
    public WebElement registerPatient;

    @FindBy(xpath = "(//i[@class='icon-calendar'])[2]")
    public WebElement appointmentScheduling;

    @FindBy(xpath = "//i[@class='icon-hdd']")
    public WebElement dataManagement;


    //findPatientRecord actions

    @FindBy(css = "[class='fg-button ui-button ui-state-default']")
    public List<WebElement> pages;

    @FindBy(css = "[role='alert']>tr> :nth-child(1)")
    public List<WebElement> patientIds;

    @FindBy(css = "[role='alert']>tr> :nth-child(2)")
    public List<WebElement> patientNames;

    @FindBy(css = "[id='patient-search']")
    public WebElement patientSearch;

    @FindBy(xpath = "//td[text()='No matching records found']")
    public List<WebElement> noRecordsFound;

    @FindBy(css = "[role='alert']>tr")
    public List<WebElement> patientsFound;

    @FindBy(css = "[class='info-header']")
    public List<WebElement> infoRow;

    @FindBy(css = "[id='patient-search-results-table_info']")
    public WebElement entries;


    //appointmentScheduling actions

    @FindBy(id = "appointmentschedulingui-manageAppointments-app")
    public WebElement manageAppointment;

    @FindBy(xpath = "(//div[@class='text'])[3]")
    public WebElement dateMessage;


    //registerPatient actions

    @FindBy(css = "[name='givenName']")
    public WebElement name;

    @FindBy(css = "[name='middleName']")
    public WebElement middleName;

    @FindBy(css = "[name='familyName']")
    public WebElement familyName;

    @FindBy(css = "[class='fas fa-chevron-right']")
    public WebElement nextButton;

    @FindBy(id = "gender-field")
    public WebElement selectGender;

    @FindBy(id = "birthdateDay-field")
    public WebElement day;

    @FindBy(id = "birthdateMonth-field")
    public WebElement selectMonth;

    @FindBy(id = "birthdateYear-field")
    public WebElement year;

    @FindBy(id = "address1")
    public WebElement adress;

    @FindBy(css = "[name='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(id = "relationship_type")
    public WebElement relationshipSelect;

    @FindBy(css = "[placeholder='Person Name']")
    public WebElement relationshipName;

    @FindBy(id = "submit")
    public WebElement confirm;


    //dataManagement actions

    @FindBy(css = "[class='float-sm-right']")
    public WebElement allId;

    @FindBy(id = "coreapps-mergePatientsHomepageLink-app")
    public WebElement mergePatient;

    @FindBy(id = "patient1-text")
    public WebElement patienIdtextBox1;

    @FindBy(id = "patient2-text")
    public WebElement patientIdtextBox2;

    @FindBy(id = "confirm-button")
    public WebElement confirmBtn;

    @FindBy(id = "first-patient")
    public WebElement firstPatientBox;

    @FindBy(xpath = "(//div[@class='messages-container'])[2]/h1")
    public WebElement warningMessage;


    //Patient Informations

    @FindBy(css = "[id='content']>h1")
    public List<WebElement> deletedPatient;

    @FindBy(css = " [class='float-sm-right']> :nth-child(2)")
    public WebElement individualId;

    @FindBy(css = "[class='col-11 col-lg-10']")
    public List<WebElement> generalActions;

    @FindBy(css = "[id='delete-reason']")
    public WebElement deleteReason;

    @FindBy(css = "[id='delete-patient-creation-dialog'] [class='confirm right']")
    public WebElement deleteConfirm;

    @FindBy(css = "[aria-live='polite']")
    public WebElement listFirst;

    @FindBy(css = "[class='mt-0 mb-2 name']")
    public WebElement individualName;

    @FindBy(css = "#selected-location")
    public WebElement selectedLocation;

}
