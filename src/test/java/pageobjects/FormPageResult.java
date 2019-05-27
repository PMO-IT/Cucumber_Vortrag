package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FormPageResult extends PageObject {

    @FindBy(id = "errormsg")
    public WebElement errormsg;

    @FindBy(id = "successmsg")
    public WebElement successmsg;

    public boolean isErrormsgVisible() {
        return errormsg.isDisplayed();
    }

    public boolean isSuccessVisible() {
        return successmsg.isDisplayed();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public FormPageResult(WebDriver driver) {
        super(driver);
    }

}
