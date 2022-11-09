package Create_Account;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Security_TC58_Password {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://www.amazon.com/");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
		List <WebElement> check=driver.findElements(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1"));
		if(check.size()!=0) {
			driver.findElement(By.id("ap_email")).sendKeys("bansalankur834@gmail.com");
			driver.findElement(By.id("continue")).click();
			List <WebElement> reCheck=driver.findElements(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/h1"));
			List <WebElement> reCheckTwo=driver.findElements(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/div/span"));
			if(reCheck.size()!=0 && reCheckTwo.size()!=0) {
				driver.findElement(By.id("ap_password")).sendKeys("B@nsalankur834");
				driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/form/div/div[2]/div/div/label/div/label/input")).click();
				driver.findElement(By.id("signInSubmit")).click();
				action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-al-your-account")));
				driver.findElement(By.linkText("Account")).click(); 
				driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a")).click();
				Boolean FinalCheck=driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[1]/h1")).isDisplayed();
				
				if(FinalCheck) {
					driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a")).click();
					Boolean display=driver.findElement(By.id("ap_cnep_header")).isDisplayed();
					if(display) {
						String oldPass="B@nsalankur834";
						String passChange="Bansal@nkur834";
						
						driver.findElement(By.id("auth-cnep-edit-password-button")).click();
						driver.findElement(By.id("ap_password")).sendKeys(oldPass);
						driver.findElement(By.id("ap_password_new")).sendKeys(passChange);
						driver.findElement(By.id("ap_password_new_check")).sendKeys(passChange);
						driver.findElement(By.id("cnep_1C_submit_button")).click();
						Boolean verifyName=driver.findElement(By.id("auth-success-message-box")).isDisplayed();
						if(verifyName) {
							System.out.println("Test Successful");
							driver.close();
						}
					}
				}
			}
				
		}

	}

}
