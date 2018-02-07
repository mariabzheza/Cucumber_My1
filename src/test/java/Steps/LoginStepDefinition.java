package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masha on 20.01.2018.
 */
public class LoginStepDefinition extends BaseUtil {

    /* OLD Method.
    @And("^I enter the username as admin and password as admin$")
    public void iEnterTheUsernameAsAdminAndPasswordAsAdmin() throws Throwable {
        System.out.println("I enter the username and password");
        //throw new PendingException();
    }*/

    /*
    @And("^I enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) throws Throwable {
        System.out.println(" UserName is " + username + " and password is " + password + " ");
    }*/

     /* OLD Method.
       @And("^I enter the following for Login$")
       public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
           System.out.println("I enter the following for Login: ");
           List<List<String>> data = table.raw();

           System.out.println("The value is (admin)" + data.get(1).get(0).toString());
           System.out.println("The value is (adminpassword)" + data.get(1).get(1).toString());
       }
   */

    private BaseUtil base;

    public LoginStepDefinition(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("I navigate to the login page ");
        base.driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");

    }


    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        System.out.println("I enter the following for Login: ");

        // Create an ArrayList
        List<User> users = new ArrayList<User>();
        // Store all users
        users = table.asList(User.class);

        /*for (User user : users) {
            System.out.println("\nThe UsersName is " + user.userName);
            System.out.println("The Password is " + user.password);
        }*/

        for (User user : users) {
            base.driver.findElement(By.name("UserName")).sendKeys(user.userName);
            base.driver.findElement(By.name("Password")).sendKeys(user.password);
        }
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        //System.out.println("and click login button ");
        base.driver.findElement(By.name("Login")).submit();

    }

    @Then("^I should see the user's form page$")
    public void iShouldSeeTheUserSFormPage() throws Throwable {

        //System.out.println("The driver is " + base.stepInfo);
        System.out.println("I should see the user's form page ");
        Assert.assertEquals(base.driver.findElement(By.id("Initial")).isDisplayed(), true);

    }

    @And("^I enter ([^\"]*) and ([^\"]*) for Login$")
    public void iEnterUserNameAndPasswordForLogin(String userName, String password) throws Throwable {
        System.out.println(" UserName is " + userName + " ");
        System.out.println(" The password is " + password + " ");
    }

    @And("^I enter the users email address as Email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {
        System.out.println("The email address is: " + email + " ");
    }

    @And("^I verify the count of my salary digits for GBR (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForGBR(@Transform(SalaryCountTransformer.class) int salary) throws Throwable {
        System.out.println("My salary digits count is: " + salary + " ");
    }

    public class User {
        private String userName;
        private String password;

        public User(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }
    }

}
