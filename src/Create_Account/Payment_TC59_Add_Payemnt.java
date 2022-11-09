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

public class Payment_TC59_Add_Payemnt {

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
				driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[2]/a")).click();
				Boolean FinalCheck=driver.findElement(By.xpath("//*[@id=\"cpefront-mpo-widget\"]/div/div[2]/div[2]/span")).isDisplayed();
				
				if(FinalCheck) {
					driver.findElement(By.xpath("//*[@id=\"pp-vQCkaD-10\"]/div/div/div[1]/img")).click();
					Boolean display=driver.findElement(By.xpath("//*[@id=\"cpefront-mpo-widget\"]/div/div[2]/div[3]/div/div[2]/div/h2")).isDisplayed();
					if(display) {
						driver.findElement(By.id("pp-ui4NbD-54")).click();
						action.moveToElement(driver.findElement(By.id("a-popover-header-1")));
						driver.findElement(By.id("pp-fak1MJ-16")).sendKeys("4263982640269299");
						driver.findElement(By.id("pp-fak1MJ-18")).sendKeys("Ankur");
						Select day=new Select(driver.findElement(By.id("pp-fak1MJ-19")));
						day.selectByValue("2");
						Select month=new Select(driver.findElement(By.id("pp-fak1MJ-21")));
						month.selectByValue("2023");
						driver.findElement(By.id("pp-fak1MJ-25")).sendKeys("837");
						driver.findElement(By.id("pp-fak1MJ-29")).click();
						Boolean verifyImg=driver.findElement(By.xpath("//*[@id=\"pp-0j2g78-17\"]/div/div/form/div/div[1]/div/div[2]/div[1]/div/img")).isDisplayed();
						if(verifyImg) {
							driver.findElement(By.xpath("//*[@id=\"pp-0j2g78-18\"]")).click();
							driver.findElement(By.xpath("//*[@id=\"pp-0j2g78-17\"]/div/div/form/div/div[2]/div/span[2]/span/input")).click();
							Boolean verifyCard=driver.findElement(By.xpath("//*[@id=\"cpefront-mpo-widget\"]/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div")).isDisplayed();
							if(verifyCard) {
							System.out.println("Test Successful");
							driver.close();
							}
						}
					}
				}
			}
				
		}
	}

}
