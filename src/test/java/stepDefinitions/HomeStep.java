package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class HomeStep {
    private final static WebDriver driver = new ChromeDriver();

    private final static String homeUrl = "https://cv-aboubakarahamada.netlify.app";

    private final static String contactUrl = "https://cv-aboubakarahamada.netlify.app/contact/contact.html";
    private final static By meContacterLink = By.linkText("ME CONTACTER");
    @Given("user is one home page")
    public void userIsOneHomePage() {
        driver.get(homeUrl);
    }

    @When("user clicks ME CONTACTER link on the menu")
    public void userClicksMECONTACTERLinkOnTheMenu() {
        driver.findElement(meContacterLink).click();
    }

    @Then("user is redirected to contact page")
    public void userIsRedirectedToContactPage() {
        ArrayList<String> openTabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(openTabs.get(1));
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(contactUrl, currentUrl);
    }
}
