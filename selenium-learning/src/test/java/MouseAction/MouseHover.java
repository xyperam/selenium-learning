package MouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement elementHover= driver.findElement(By.xpath("//button[@class='dropbtn']"));
		Actions action = new Actions(driver);
		//hover
		action.moveToElement(elementHover).perform();
		//driver.findElement(By.xpath("//a[normalize-space()='Mobiles']")).click();
		//double Click
		WebElement eleDoubleClick = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		action.doubleClick(eleDoubleClick).perform();
		
		WebElement inputField = driver.findElement(By.id("field2"));
		String inputText = inputField.getAttribute("value");
		if(inputText.equals("Hello World!")) {
			System.out.println("Double Click Success");
		}else {
			System.out.println("Double Click Failed");
		}
		
		//Drag and Drop
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		action.dragAndDrop(source, target).perform();
		
		  WebElement leftSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
	        WebElement rightSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));

	        // 🔹 Tentukan nilai minimum & maksimum slider
	        int minValue = 0;
	        int maxValue = 500;
	        WebElement amount = driver.findElement(By.id("amount"));
	        // 🔹 Target nilai harga yang ingin dicapai
	        int targetMin = 100;
	        int targetMax = 300;

	        // 🔹 Ambil ukuran slider
	        WebElement sliderTrack = driver.findElement(By.id("slider-range"));
	        int sliderWidth = sliderTrack.getSize().width;

	        // 🔹 Ambil ukuran slider
	

	        // 🔹 Hitung offset berdasarkan persentase
	        int offsetMin = (int) ((double) (targetMin - minValue) / (maxValue - minValue) * sliderWidth);
	        int offsetMax = (int) ((double) (targetMax - minValue) / (maxValue - minValue) * sliderWidth);

	        // 🔹 Buat objek Actions
	

	        // 🔹 Geser slider kiri ke posisi targetMin
	        action.dragAndDropBy(leftSlider, offsetMin - 5, 0).perform();
	        Thread.sleep(1000);

	        // 🔹 Geser slider kanan ke posisi targetMax
	        action.dragAndDropBy(rightSlider, offsetMax - offsetMin, 0).perform();
	        Thread.sleep(1000);

	        // 🔹 Cek harga setelah geser slider
	        System.out.println("Harga Setelah digeser: " + amount.getAttribute("value"));
//cek
	}
	
//	public static int extractNumber(String text) {
//		 return Integer.parseInt(text.replaceAll("[^0-9]", ""));
//	}
	   
}
