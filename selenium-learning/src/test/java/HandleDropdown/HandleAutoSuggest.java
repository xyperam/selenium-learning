package HandleDropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAutoSuggest {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	driver.findElement(By.name("q")).sendKeys("selenium");
	List<WebElement> suggestion= driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
	System.out.println(suggestion.size());
	
	for(WebElement suggest:suggestion) {
		System.out.println(suggest.getText());
	}
}
}
