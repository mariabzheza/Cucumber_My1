package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Masha on 05.02.2018.
 */
public class LoginPage {

    public LoginPage(WebDriver driver) {
        //this.txtUserName = txtUserName;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;

    @FindBy(how = How.NAME, using = "Login")
    public WebElement btnLogin;

    public void login(String userName, String password){
        txtUserName.sendKeys(userName);
        txtUserName.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.submit();
    }
}
