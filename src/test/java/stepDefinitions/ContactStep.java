package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
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

    private final static By subject = By.id("subject");
    private final static By message = By.id("message");
    private final static By sendBtn = By.className("btn");
    @BeforeAll
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/lib/chromedriver.exe");
        driver.get(url);
    }
    @Before
    public static void clearForm(){
        driver.findElement(name).clear();
        driver.findElement(email).clear();
        driver.findElement(subject).clear();
        driver.findElement(message).clear() ;
    }
    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @Given("user is on the contact page")
    public void userIsOnTheContactPage() {
        driver.get(url);
    }
    @When("user enters {string} as name and {string} as email")
    public void userEntersAsNameAndAsEmail(String arg0, String arg1) {

        driver.findElement(name).sendKeys(arg0);
        driver.findElement(email).sendKeys(arg1);

    }
    @And("user types {string} as subject and {string} as message")
    public void userTypesAsSubjectAndAsMessage(String arg_subject, String arg_message) {
        driver.findElement(subject).sendKeys(arg_subject);
        driver.findElement(message).sendKeys(arg_message);
    }
    @And("user clicks send button")
    public void userClicksSendButton() {
        driver.findElement(sendBtn).click();
    }

    @Then("user cannot submit message")
    public void userCannotSubmitMessage() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,url);
    }


    @Given("user is on contact page")
    public void userIsOnContactPage() {
        driver.get(url);
    }

    @When("user fulled form contact with {string} as name, {string} as email, {string} as object and {string} as message")
    public void userFulledFormContactWithAsNameAsEmailAsObjectAndAsMessage(
            String arg_name, String arg_email, String arg_subject, String arg_message)
    {
        driver.findElement(name).sendKeys(arg_name);
        driver.findElement(email).sendKeys(arg_email);
        driver.findElement(subject).sendKeys(arg_subject);
        driver.findElement(message).sendKeys(arg_message);
    }

    @And("user clicks send message button")
    public void userClicksSendMessageButton(){
        driver.findElement(sendBtn).click();
    }
    @Then("user is redirected to CAPTCHA page")
    public void userIsRedirectedToCAPTCHAPage() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://formsubmit.co/ed1d536d07089e40e71a5279c11fe729");
    }

}
