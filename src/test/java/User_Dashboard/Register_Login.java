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


	//Get User Name from the Home Page

	public static void dashboard() throws InterruptedException {

		Thread.sleep(30000);

		WebElement UserName =driver.findElement(By.xpath("//h2[contains(@class, 'text-xl text18 text-white font-bold')]"));  

		String Username=UserName.getText();

		System.out.println("Username:" + Username);



		//Get User Balance

		WebElement totalBalance =driver.findElement(By.xpath("//h2[contains(@class,'text-3xl') and contains(@class,'text-white')]"));  


		String totalbalance = totalBalance.getText();

		System.out.println("Available balance = " + totalbalance);


        //User Has token balance - Show all the token detaild
		
		if(totalbalance != "0.00") {

			By Showmore = By.xpath("//span[text()='Show More...']");

			wait(Showmore);

			click(Showmore);

			List<WebElement> tokenNameElements = driver.findElements(By.xpath("//p[contains(@class,'text-base') and contains(@class,'font-bold')]"));
			List<WebElement> tokenBalanceElements = driver.findElements(By.xpath("//p[contains(@class,'text-lg') and contains(@class,'font-bold')]"));

			System.out.println("\n--- Tokens List ---");

			int totalTokens = Math.min(tokenNameElements.size(), tokenBalanceElements.size());

			for (int i = 0; i < totalTokens; i++) {
				String tokenName = tokenNameElements.get(i).getText();

				// Get balance + symbol
				String balanceFullText = tokenBalanceElements.get(i).getText();
				String[] parts = balanceFullText.split(" ");
				String balance = parts[0];
				String tokenSymbol = parts.length > 1 ? parts[1] : "";

				System.out.println("Token Name: " + tokenName + " | Balance: " + balance + " | Symbol: " + tokenSymbol);
			}



		}
		
		//User total balance amount is 0 , show available token names
		
		else {
			
			List<WebElement> tokenNameElements = driver.findElements(By.xpath("//p[contains(@class,'text-base') and contains(@class,'font-bold')]"));
			
			System.out.println("\n--- Tokens List ---");
			
			int totalTokens = Math.min(tokenNameElements.size(), (Integer) null);

			System.out.println("at the end ");
			
			for (int i = 0; i < totalTokens; i++) {
				String tokenName = tokenNameElements.get(i).getText();
				
				System.out.println("Token Name: " + tokenName );

		}

	}








	}
}















