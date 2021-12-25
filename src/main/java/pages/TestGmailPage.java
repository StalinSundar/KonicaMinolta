package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestGmailPage {

	@FindBy(xpath="/html/body/header/div/div/div/a[2]")
	private WebElement signIn; 
	
	@FindBy(id="identifierId")
	private WebElement userName; 
	
	@FindBy(xpath="//*[@id=\"password\"]/div[1]/div/div[1]/input")
	private WebElement passWord; 
	
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/span")
	private WebElement unameNext;
	
	@FindBy(xpath="//*[@id=\"passwordNext\"]/div/button/span")
	private WebElement passwordNext;
	
	@FindBy(xpath="//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/img")
	private WebElement profileImage;
	
	public WebElement getSignIn() {
		return signIn;
	}
	
	public void setSignIn(WebElement signIn) {
		this.signIn = signIn;
	}	
	
	public WebElement getUserName() {
		return userName;		
	}
	
	public void setUserName(WebElement userName) {
		this.userName = userName;
	}	
	
	public WebElement getPassWord() {
		return passWord;		
	}
	
	public void setPassWord(WebElement passWord) {
		this.passWord = passWord;
	}	
	
	public WebElement getUnameNext() {
		return unameNext;
	}
	
	public void setUnameNext(WebElement unameNext) {
		this.unameNext = unameNext;
	}	
	
	public WebElement getPassNext()	{
		return passwordNext;
	}
	
	public void setPassNext(WebElement passwordNext) {
		this.passwordNext = passwordNext;
	}	
	
	public WebElement getProfileImage()	{
		return profileImage;
	}
	
	public void setProfileImage(WebElement profileImage) {
		this.profileImage = profileImage;
	}
}
