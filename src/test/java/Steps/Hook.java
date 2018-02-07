package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Masha on 23.01.2018.
 */
public class Hook extends BaseUtil{

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(){
        System.out.println(" Opening the Browser : MOCK ");

        //Passing a dummy WebDriver instance
        //base.stepInfo = "Firefox Driver";

        /*System.setProperty("webdriver.firefox.marionette", "D:\\AutomationTmp\\Drivers\\geckodriver.exe");
        base.driver = new FirefoxDriver(); */
        System.setProperty("webdriver.gecko.driver", "D:\\AutomationTmp\\Drivers\\geckodriver.exe");
        base.driver = new FirefoxDriver();
        /*System.setProperty("webdriver.chrome.driver", "D:\\AutomationTmp\\Drivers\\chromedriver.exe");
        base.driver = new ChromeDriver();*/

    }

    @After
    public void TearDownTest(Scenario scenario){
        if (scenario.isFailed()) {
            //Take some screenshort if scenario is failed!!!
            System.out.println("The name of failed scenario is " + scenario.getName()+ " ");
        }
        System.out.println(" Closing the Browser : MOCK ");
        base.driver.close();
    }

}
