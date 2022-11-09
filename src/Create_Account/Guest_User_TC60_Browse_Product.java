package Create_Account;

import org.openqa.selenium.By;

//import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Guest_User_TC60_Browse_Product {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("nav-hamburger-menu")).click();
		//Actions action=new Actions(driver);
		
		driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[8]")).click();
		driver.findElement(By.linkText("Computer Accessories & Peripherals")).click();
		//action.moveToElement(driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[8]/a"))).click();
		//action.moveToElement(driver.findElement(By.linkText("Computer Accessories & Peripherals"))).click();
		Boolean result=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[1]/div/span/div/div/span")).isDisplayed();
		if(result) {
			driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div")).click();
			Boolean buyButton=driver.findElement(By.id("buy-now-button")).isDisplayed();
			if(buyButton) {
				System.out.println("Test Passed");
				driver.close();
			}
		}
		
		
	}

}
