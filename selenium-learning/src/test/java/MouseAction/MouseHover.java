package MouseAction;

import org.openqa.selenium.By;
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
		
		//slider
		WebElement amount = driver.findElement(By.xpath("//input[@id='amount']"));
		WebElement sliderRange = driver.findElement(By.xpath("//div[contains(@id,'slider-range')]"));
		WebElement leftSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		WebElement rightSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		int targetMin = 100;
		int targetMax = 300;
		String priceText = amount.getAttribute("value");
		int currentPrice = extractNumber(priceText);
		System.out.println(sliderRange.getSize());
		int minValue = 0;
		int maxValue = 500;
		 int sliderWidth = sliderRange.getSize().width;
	        int leftStart = leftSlider.getLocation().getX();
	        int rightStart = rightSlider.getLocation().getX();
	        int sliderStart = sliderRange.getLocation().getX(); // Awal dari slider utama

	        System.out.println("Slider Width: " + sliderWidth);
	        System.out.println("Left Slider Start: " + leftStart);
	        System.out.println("Right Slider Start: " + rightStart);
	        System.out.println("Slider Start: " + sliderStart);

	        // 🔹 Geser slider kiri ke targetMin
	        moveSliderToTarget(action, leftSlider, targetMin, minValue, maxValue, sliderWidth, sliderStart, leftStart);

	        // 🔹 Geser slider kanan ke targetMax
	        moveSliderToTarget(action, rightSlider, targetMax, minValue, maxValue, sliderWidth, sliderStart, rightStart);

	        // 🔹 Tunggu sejenak agar perubahan terlihat
	        Thread.sleep(2000);

	        // 🔹 Cek hasil setelah digeser
	        System.out.println("Harga Setelah digeser: " + amount.getAttribute("value"));


	}
	
	public static int extractNumber(String text) {
		 return Integer.parseInt(text.replaceAll("[^0-9]", ""));
	}
	   public static void moveSliderToTarget(Actions action, WebElement slider, int target, int min, int max, int sliderWidth, int sliderStart, int handleStart) {
	        int totalRange = max - min; // Rentang angka pada slider (misal 0 - 500)
	        int relativeOffset = (int) (((double) (target - min) / totalRange) * sliderWidth); // Offset relatif dalam piksel
	        int absoluteOffset = (sliderStart + relativeOffset) - handleStart; // Koreksi dengan posisi awal slider

	        System.out.println("Geser slider sejauh: " + absoluteOffset + " piksel");

	        // Geser slider langsung ke offset yang dihitung
	        action.clickAndHold(slider).moveByOffset(absoluteOffset, 0).release().perform();
	    }
}
