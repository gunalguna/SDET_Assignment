import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
   public static void main(String[] args) {
	String browser="Chrome";
	WebDriver driver=null;
	if(browser.equalsIgnoreCase("Chrome")){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("edge")){
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	driver.get("https://www.makemytrip.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	if(driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/a/picture/img")).isDisplayed()){
		System.out.println("MakeMyTrip Logo is present");
	}
	else{
		System.out.println("MakeMyTrip Logo is not present");
	}
	driver.close();
	
}
}
