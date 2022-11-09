package Create_Account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_New_button {

	public static void main(String[] args) {
		//declaration and initialization of object of driver class
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//Action to move mouse
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.linkText("Start here.")).click();
		List<WebElement> checkList =driver.findElements(By.xpath("//*[@id=\"ap_register_form\"]/div/div/h1"));
		
		if(checkList.size()!=0) {
			driver.close();
		}
	}

}
