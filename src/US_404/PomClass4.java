package US_404;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PomClass4 {

    public PomClass4() {
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

    @FindBy(css ="[class='icon-user']")
    public  WebElement registerPatient;

    @FindBy(css = "[name='givenName']")
    public WebElement name;

    @FindBy(css = "[name='middleName']")
    public WebElement middleName;

    @FindBy(css = "[name='familyName']")
    public WebElement familyName;

    @FindBy(css = "[class='fas fa-chevron-right']")
    public WebElement nextButton;

    @FindBy(id = "gender-field")
    public WebElement selectgender;

    @FindBy(id = "birthdateDay-field")
    public WebElement day;

    @FindBy(id = "birthdateMonth-field")
    public WebElement selectMonth;

    @FindBy(id = "birthdateYear-field")
    public WebElement year;

    @FindBy(id = "address1")
    public WebElement adress;

    @FindBy(css = "[name='phoneNumber']")
    public WebElement phonenumber;

    @FindBy(id = "relationship_type")
    public WebElement relationshipSelect;

    @FindBy(css = "[placeholder='Person Name']")
    public WebElement relatinshipName;

    @FindBy(id = "submit")
    public WebElement confirm;


    @FindBy(css = "[class='float-sm-right']>span")
    public WebElement patiantID;

    @FindBy(css= "[class='mt-0 mb-2 name']")
    public  WebElement confirmPatientName;





}
