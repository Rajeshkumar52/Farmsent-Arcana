package User_Dashboard;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Runner_Class extends Browser_Setup {
	
	
	 @BeforeTest
	    public void setup() {
	        String development_url = "https://devsuperapp.farmsent.io/";
	        Boolean headless = false;
	        String browser = "chrome";

	        Browser_Setup.launch();
	    }

	    @Test(priority=1)
	    public void landing() throws InterruptedException {
	    	
	    	
	      Register_Login.Landing();
	        
	    }
	    
	    
	    @Test(priority=2)
	    public void register() {
	    	
	    
	    	Register_Login.Login();
	    	
	    }
	    
	    @Test(priority=3)
	    public void mailOTP() throws InterruptedException {
	    	
	    	Register_Login.mail_otp();
	    }
	    
	    
	    @Test(priority=4)
	    public void dashboard() throws InterruptedException {
	    	
	    	Register_Login.dashboard();
	    }
	    
		@AfterTest
		public void tesrdown() {
			
			//driver.quit();
		}
	

}
