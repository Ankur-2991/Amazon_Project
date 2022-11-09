package Create_Account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login_TC17_Sign_In {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
		List <WebElement> check= driver.findElements(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1"));
		if(check.size()!=0) {
			driver.findElement(By.id("ap_email")).sendKeys("bansalankur007@gmail.com");
			driver.findElement(By.id("continue")).click();
			List <WebElement> checkAgain=driver.findElements(By.xpath("//*[@id=\"auth-error-message-box\"]/div"));
			if(checkAgain.size()!=0) {
				System.out.println("Test Successful");
				driver.close();
			}
		}
	}

}
