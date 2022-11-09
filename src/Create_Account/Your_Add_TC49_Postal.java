package Create_Account;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Your_Add_TC49_Postal {

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
				List <WebElement> FinalCheck=driver.findElements(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[1]/h1"));
				if(FinalCheck.size()!=0) {
					driver.findElement(By.linkText("Your addresses")).click();
					driver.findElement(By.id("ya-myab-plus-address-icon")).click();
					String reFinalCheck = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/h2")).getText();
					String order="Add a new address";
					
					if(reFinalCheck==order) {
						Select drop=new Select(driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId")));
						drop.selectByValue("Canada");
						driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).clear();
						driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Ankur Bansal");
						driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4379867511");
						driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("26 Swans Arce Trail");
						driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Brampton");
						Select province=new Select(driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")));
						province.selectByValue("Ontario");
						driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6R 0B3");
						driver.findElement(By.id("address-ui-widgets-form-submit-button")).click();
							System.out.print("Test Passed");
							driver.close();
						
						}
					}
				}
				
			}
	}

}
