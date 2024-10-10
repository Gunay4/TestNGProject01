package US_403;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass3 {

    public PomClass3() {
        PageFactory.initElements(BaseDriver.driver,this);
    }
    @FindBy(css = "#selected-location")
    public WebElement selectedLocation;
}
