package gmail;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.TestGmailPage;
import utils.Utils;

public class GmailLogin extends Utils {

    TestGmailPage gmailpage = new TestGmailPage();
    public static String URL;

    public static void main(String[] args) throws IOException, InterruptedException {
    	URL = Utils.getPropertyValue("gmailURL");
    	String username = Utils.getPropertyValue("username");
        String password = Utils.getPropertyValue("password");
        GmailLogin gmailObj = new GmailLogin();
        gmailObj.loginGmailAccount(username, password);   
        gmailObj.loginGmailAccount("Invalid", password);   
        gmailObj.loginGmailAccount(username, "Invalid");   
    }

    public void launchGmail() throws InterruptedException {
        PageFactory.initElements(driver, gmailpage);
        driver.get(URL);
    }

    public void loginGmailAccount(String username, String password) throws IOException, InterruptedException {
    	Utils.browserInialization();
        launchGmail();
        WebElement Sign = gmailpage.getSignIn();
        try {
            if (Sign.isEnabled()) {
                Sign.click();
            }
        } catch (Exception e) {
        }
        
        try {
	        gmailpage.getUserName().clear();
	        gmailpage.getUserName().sendKeys(username);
	        gmailpage.getUnameNext().click();
	        Thread.sleep(5000);
	        gmailpage.getPassWord().clear();
	        gmailpage.getPassWord().sendKeys(password);
	        gmailpage.getPassNext().click();
	        Thread.sleep(5000);
        } catch(Exception ex) {
        }
        isUserLoggedIn();
        Utils.closeBrowsers();
    }
    
    public void isUserLoggedIn() {
    	try {
	    	if (gmailpage.getProfileImage().isDisplayed()) {
	            System.out.println("User loggedin successfully");
	        }
    	} catch(Exception ex) {
    		System.out.println("User not loggedin successfully. Please Provide valid credentials");
    	}
    }
}