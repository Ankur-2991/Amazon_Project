package Create_Account;

//import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_New_TC11_Password {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.linkText("Start here.")).click();
		driver.findElement(By.id("ap_customer_name")).sendKeys("Rohit Garg");
		driver.findElement(By.id("ap_email")).sendKeys("gargrohit100@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("G@rg12");
		driver.findElement(By.id("ap_password_check")).sendKeys("G@rg12");
		driver.findElement(By.id("continue")).click();
		
			driver.close();
		
	}

}
