package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestEbayPage {

	@FindBy(xpath="//*[@id='gh-ac']")
	private WebElement searchField;
	
	@FindBy(xpath="//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a/h3")
	private WebElement searchResult;
	
	@FindBy(xpath="//*[@id=\"mm-saleDscPrc\"]")
	private WebElement itemPrice;
	
	public WebElement getSearchField() {
		return searchField;		
	}
	
	public void setSearchField(WebElement searchField) {
		this.searchField = searchField;
	}
		
	public WebElement getSearchResult() {
		return searchResult;	
	}
	
	public void setSearchResult(WebElement searchResult) {
		this.searchResult = searchResult;
	}
	
	public WebElement getItemPrice() {
		return itemPrice;
	}
	
	public void setItemPrice(WebElement itemPrice) {
		this.itemPrice = itemPrice;
	}
}
