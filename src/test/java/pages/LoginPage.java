package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

//******************** objects ************************
	
	@FindBy(className="login")
	WebElement loginBtn;
	
	@FindBy(name="user_login")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(className="rememberMe")
	WebElement CheckBox;
	
	@FindBy(name="btn_login")
	WebElement LoginBt2;
	
	public LoginPage(WebDriver baseDriver) {
		this.driver = baseDriver;
		
		PageFactory.initElements(baseDriver, this);
	}

	
//********************** methods **********************	
	public void Login(String UserNameValue, String PasswordValue) {
		// Locate web element and click on it
		loginBtn.click();
		
		// Wait until page get loaded
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_login")));
	
		// Locate web elements for login, fill them and submit for login
		UserName.sendKeys(UserNameValue);
		
		Password.sendKeys(PasswordValue);
		
		CheckBox.click();
		
		LoginBt2.click();
	}


}
