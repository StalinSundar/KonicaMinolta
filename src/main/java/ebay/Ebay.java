package ebay;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.TestEbayPage;
import utils.Utils;

public class Ebay extends Utils {

    TestEbayPage testEbayPage = new TestEbayPage();
    public static String URL;
    
    public static void main(String[] args) throws IOException, InterruptedException {
    	URL = Utils.getPropertyValue("ebayURL");
        Utils.browserInialization();
        wait = new WebDriverWait(driver, 60);
        Ebay eBayObj = new Ebay();
        eBayObj.launchEBaySite();
        eBayObj.searchProduct(Utils.getPropertyValue("searchItem"));
        eBayObj.clickItem();
        Utils.closeBrowsers();
    }

    public void launchEBaySite() throws InterruptedException {
        PageFactory.initElements(driver, testEbayPage);
        driver.get(URL);
        Thread.sleep(300);
    }

    public void searchProduct(String SearchItem) {
        testEbayPage.getSearchField().sendKeys(SearchItem);
        testEbayPage.getSearchField().sendKeys(Keys.ENTER);
    }

    public void clickItem() throws InterruptedException {
        testEbayPage.getSearchResult().click();

        String mainWindowHandle = driver.getWindowHandle();
        Set < String > allWindowHandles = driver.getWindowHandles();
        Iterator < String > iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String text = testEbayPage.getItemPrice().getText();
                System.out.println("Price of the product is: " + text);
            }
        }
    }
}