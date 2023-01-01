import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
    }

}
