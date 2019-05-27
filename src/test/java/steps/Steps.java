package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.FormPage;
import pageobjects.FormPageResult;


public class Steps {

    private WebDriver driver;

    private void setupFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\dev\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Given("^User navigates to form website$")
    public void user_navigates_to_form_website() throws Throwable {
        setupFirefoxDriver();
        driver.get("file:///C:/Users/NoName/eclipse-workspace/Kontaktformular/index.html");
        FormPage formpage = new FormPage(driver);
        String actualTitle = formpage.getTitle();
        assertEquals(actualTitle, "Formular");
    }

    @Given("^User fills in Data$")
    public void user_fills_in_Data() throws Throwable {
        FormPage formpage = new FormPage(driver);
        formpage.setPlz("1234");
        formpage.selectLand("deutschland");
    }

    @When("^User clicks on the ok button$")
    public void user_clicks_on_the_ok_button() throws Throwable {
        FormPage formpage = new FormPage(driver);
        formpage.clickOk();
    }

    @Then("^User should be taken to the success page$")
    public void user_should_be_taken_to_the_success_page() throws Throwable {
        FormPageResult formpageResult = new FormPageResult(driver);
        String formpageresultTitle = formpageResult.getTitle();
        assertEquals(formpageresultTitle, "Formular absenden");
    }

    @Then("^no errors should be displayed$")
    public void no_errors_should_be_displayed() throws Throwable {
        FormPageResult formpageResult = new FormPageResult(driver);
        assertFalse(formpageResult.isErrormsgVisible());
    }
}
