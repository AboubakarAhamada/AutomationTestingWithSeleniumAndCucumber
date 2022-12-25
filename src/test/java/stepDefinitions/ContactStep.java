package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactStep {

    private final static WebDriver driver = new ChromeDriver();

    private final static String url = "https://cv-aboubakarahamada.netlify.app/contact/contact.html";
    private final static By name = By.id("name");
    private final static By email = By.id("email");
    private final static By sendBtn = By.className("btn");
    @Before
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/lib/chromedriver.exe");
        driver.get(url);
    }
    @Before
    public static void clearForm(){
        driver.findElement(name).clear();
        driver.findElement(email).clear();
    }
    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @Given("user enters {string} as name and {string} as email")
    public void userEntersAsNameAndAsEmail(String arg0, String arg1) {

        driver.findElement(name).sendKeys(arg0);
        driver.findElement(email).sendKeys(arg1);

    }

    @When("user clicks send button")
    public void userClicksSendButton() {
        driver.findElement(sendBtn).click();
    }

    @Then("nothing happens")
    public void nothingHappens() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,url);
    }

}
