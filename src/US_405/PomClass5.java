package US_405;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PomClass5 {

    public PomClass5() {
        PageFactory.initElements(BaseDriver.driver, this);
    }



    @FindBy(css = "[class='zak-button']")
    public WebElement demoBtn;


    @FindBy(xpath = "//span[text()='Explore OpenMRS 2']")
    public WebElement ExploreOpenMRS2;

    @FindBy(xpath = "//span[text()='Enter the OpenMRS 2 Demo']")
    public WebElement EntertheOpenMRS2Demo;

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

    @FindBy(css = "[id='loginButton']")
    public WebElement loginButton;

    @FindBy(css = "[class='icon-user small']")
    public WebElement adminBtn;

    @FindBy(css = "[id='user-account-menu'] a")
    public WebElement myAccount;

    @FindBy(xpath = "(//div[@id='tasks']/a)[1]")
    public WebElement changePassword;

    @FindBy(xpath = "(//div[@id='tasks']/a)[2]")
    public WebElement myLanguages;

    @FindBy(css = "[class='icon-home small']")
    public WebElement returnToHomePage;

    @FindBy(css = "[class='nav-item logout']>a")
    public WebElement logOut;
}
