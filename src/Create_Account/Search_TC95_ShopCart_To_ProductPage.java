package Create_Account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Search_TC95_ShopCart_To_ProductPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
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
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computer");
				driver.findElement(By.id("nav-search-submit-button")).click();
				driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/div/div[1]")).click();
				//String product1=driver.findElement(By.id("productTitle")).getText();
				driver.findElement(By.id("submit.add-to-cart")).click();
				driver.findElement(By.id("attach-sidesheet-view-cart-button")).click();
				driver.findElement(By.xpath("//*[@id=\"sc-active-C6f6c7888-3bbf-46a0-a144-c8e6edc28943\"]/div[4]/div/div[3]/ul/li[1]/span/a")).click();
				
			}
		}
	}

}
