package User_Dashboard;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;



public class Browser_Setup {

	public static WebDriver driver;

	public static Wait<WebDriver> wait;

	public static JavascriptExecutor js;

	@BeforeTest
	public static WebDriver launch () {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))

				.pollingEvery(Duration.ofSeconds(10))

				.ignoring(Exception.class);

		js = (JavascriptExecutor) driver;

		return driver;

	}			

	public static WebElement find(By locator) {

		return driver.findElement(locator);

	}

	public static void click(By locator) {

		find(locator).click();

	}

	public static void sendKeys(By locator, String text) {

		find(locator).sendKeys(text);

	}

	public static WebElement wait(By locator) {

		return wait.until(ExpectedConditions.elementToBeClickable(locator));


	} 

	public static void Switch_window(int numbr){	
		((JavascriptExecutor)driver).executeScript("window.open()");

	}

	public static void Window_Handle(String url,int number) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(number));
		driver.get(url);


	}

	public static String getText(By locator) {
		return find(locator).getText();

	}




}



