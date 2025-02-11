package HandleDatePicker;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker2 {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
	String month = "Mar";
	String year ="2025";
	String date ="24";
	driver.findElement(By.xpath("//input[@id='txtDate']")).click();
	WebElement monthDropdown =driver.findElement(By.xpath("//select[@aria-label='Select month']"));
	Select selectMonthDropdown = new Select(monthDropdown);
	selectMonthDropdown.selectByVisibleText(month);
	
	WebElement yearDropdown = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
	Select selectYearDropdown = new Select(yearDropdown);
	selectYearDropdown.selectByVisibleText(year);
	
	List<WebElement>allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	for(WebElement dt:allDates) {
		if(dt.getText().equals(date)) {
			dt.click();
			break;
		}
	}
	
}
}
