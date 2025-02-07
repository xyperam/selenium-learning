package HandleDropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BoostrapDropdown {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
	driver.findElement(By.xpath("//input[@value='csharp']")).click();
	//capture all the options and find out size
	List<WebElement> options = driver.findElements (By.xpath("//ul[contains(@class,'multiselect')]/li/a/label"));
	for(WebElement op:options) {
		System.out.println(op.getText());
	}
	
	//select multiple options
	for(WebElement op:options) {
		String option = op.getText();
		if(option.equals("Java")|| option.equals("Python") || option.equals("Oracle")) {
			op.click();
		}
	}
}
}
