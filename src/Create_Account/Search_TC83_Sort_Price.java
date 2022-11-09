package Create_Account;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Search_TC83_Sort_Price {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computer");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Select drop=new Select(driver.findElement(By.id("s-result-sort-select")));
		drop.selectByValue("price-asc-rank");
		driver.findElement(By.xpath("//*[@id=\"a-popover-2\"]/div/div/ul/li[2]")).click();
	}

}
