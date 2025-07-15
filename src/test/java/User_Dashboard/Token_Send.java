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

public class Token_Send extends Browser_Setup {
	
	
	
	 public static String totalBalance;

	    public static List<String> tokenNames = new ArrayList<>();
	    public static List<String> tokenBalances = new ArrayList<>();
	    public static List<String> tokenSymbols = new ArrayList<>();

	
	
	public static void dashboard() throws InterruptedException {

		Thread.sleep(30000);

		WebElement UserName =driver.findElement(By.xpath("//h2[contains(@class, 'text-xl text18 text-white font-bold')]"));  

		String Username=UserName.getText();

		System.out.println("Username:" + Username);



		//Get User Balance

		WebElement totalBalance =driver.findElement(By.xpath("//h2[contains(@class,'text-3xl') and contains(@class,'text-white')]"));  


		 String totalbalance = totalBalance.getText();

		System.out.println("Available balance = " + totalbalance);


        //User Has token balance - Show all the token detail
		
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
	
	
	
	
	
	
	public static void send_token() {
		
		
		
		
		
		
		
	}

}
