package Create_Account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_Acc_name_empty {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.linkText("Start here.")).click();
		driver.findElement(By.id("ap_customer_name")).sendKeys("");
		driver.findElement(By.id("continue")).click();
		List<WebElement> checkList =driver.findElements(By.xpath("//*[@id=\"auth-customerName-missing-alert\"]/div/div"));
		
		if(checkList.size()!=0) {
			driver.close();
		}
		
	}

}
