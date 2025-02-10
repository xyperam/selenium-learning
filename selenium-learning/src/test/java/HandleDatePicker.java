import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDatePicker {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/datepicker/");
	driver.manage().window().maximize();
	driver.switchTo().frame(0);
	//if there is input form, you can input by sendkeys
	driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	//method 2 using datepicker
	String year = "2024";
	String month = "January";
	String date = "24";
//	selectFutureDate(driver,date,month,year);
	selectPastDate(driver,date,month,year);
	
	
	
}


public static void selectFutureDate(WebDriver driver,String date,String month, String year) {
	while(true) {
		String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		if(currentMonth.equals(month) && currentYear.equals(year)) {
			break;
		}
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	}
	//select date
	
	List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	for(WebElement dt:allDates) {
		if(dt.getText().equals(date)) {
			dt.click();
			break;
		}
	}
}

public static void selectPastDate(WebDriver driver,String date,String month, String year) {
	while(true) {
		String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		if(currentMonth.equals(month) && currentYear.equals(year)) {
			break;
		}
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
	}
	//select date
	
	List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	for(WebElement dt:allDates) {
		if(dt.getText().equals(date)) {
			dt.click();
			break;
		}
	}
}
}


