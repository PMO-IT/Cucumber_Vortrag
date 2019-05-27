package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class FormPage extends PageObject {

    @FindBy(id = "Fplz")
    private WebElement Fplz;

    @FindBy(id = "Fland")
    private WebElement Fland;

    @FindBy(id = "okButton")
    private WebElement okButton;

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOk() {
        okButton.click();
    }

    public void selectLand(String land) {
        Select selectFland = new Select(Fland);
        selectFland.selectByValue(land);
    }

    public void setPlz(String plz) {
        Fplz.clear();
        Fplz.sendKeys(plz);
    }

    public FormPage(WebDriver driver) {
        super(driver);
    }

}
