package User_Dashboard;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Register_Login extends Browser_Setup {


	public static String email="r1sk@yopmail.com";


	public static void Landing() throws InterruptedException {

		driver.get("https://devsuperapp.farmsent.io/");

		String current_url=driver.getCurrentUrl();

		//Print the current url

		System.out.println(current_url);

		//Checkt the current url is equals to the expected url

		String expected_url="https://devsuperapp.farmsent.io/";

		if (current_url.equals(expected_url)) {

			System.out.println("Entered the landing page correctly");
		}
		else {
			System.out.println("The landing page url is incorrect");
		}



		//wait for the elememt visible

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Thread.sleep(2000);


		By NotNowButton = By.xpath("//button[text()=\"Not Now\"]");

		wait (NotNowButton);

		click (NotNowButton);



		WebElement letsGrowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[contains(@class, 'rounded-full') and contains(@ng-reflect-router-link, '/auth/register')]")
				));

		// Click the Lets grow Button 
		letsGrowButton.click();


	}


	public static void Login() {

		String Login_url=driver.getCurrentUrl();

		System.out.println(Login_url);

		driver.findElement(By.xpath("//input[@id=\"emailid\"]")).sendKeys(email);

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();


	}



	//getting OTP from the yopmail

	public static void mail_otp() throws InterruptedException {

		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://yopmail.com/en/");

		Thread.sleep(20000);

		driver.findElement(By.xpath("//input[@id=\"login\"]")).sendKeys(email);


		//Arrow click Arrow_click=By.xpath("/html/body/div/div[2]/main/div[3]/div/div[1]/div[2]/div/div/form/div/div[1]/div[4]/button/i");

		driver.findElement(By.xpath("//*[@id=\"refreshbut\"]/button/i")).click();


		Thread.sleep(20000);

		driver.navigate().refresh();

		driver.navigate().refresh();

		//driver.switchTo().frame(driver.findElement(By.id("ifinbox")));

		//driver.findElement(By.xpath("/span[text()='noreply@arcana.network']")).click();


		driver.switchTo().frame(driver.findElement(By.id("ifmail"))); 

		String OTP = driver.findElement(By.xpath("//*[@id=\"mail\"]/div/center/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td/div/p[3]")).getText();

		System.out.println(OTP);

		driver.switchTo().window(tabs.get(0));

		//OTP enter 

		Thread.sleep(20000);
		//Thread.sleep(20000);

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(OTP);

		//driver.findElement(By.id("//input[@id='otp']")).sendKeys(OTP);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//Home page login

		String Homepage= driver.getCurrentUrl();

		System.out.println(Homepage);


		//Enter OTP if OTP has Separate Fields
		
		/*String[] otps = {OTP};

		int[] numericOtps = new int[otps.length];

		for (int i = 0; i < otps.length; i++) {

			String otp = otps[i];

			String otpFieldXpath = "(//input[@type='tel'])[" + (i + 1) + "]";

			WebElement otpField = driver.findElement(By.xpath(otpFieldXpath));

			String numericOtpString = otp.replaceAll("[^\\d]", "");

			numericOtps[i] = Integer.parseInt(numericOtpString);

			otpField.sendKeys(numericOtpString);*/
	}

	}
















