package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AnyPage extends Page {

    @FindBy(xpath = "//a[@class='logo-header block left']")
    WebElement headerLogo;

    // Header > Search by
    @FindBy(xpath = "//div[@class='block left search mn']//span")
    WebElement searchBy;

    @FindBy(xpath = "//div[@class='block left search mn']//li/a[text()='Backlinks']")
    WebElement searchByBacklinks;

    // Header > Top Domains
    @FindBy(xpath = "//div[@class='block left first mn']/span")
    WebElement topDomains;

    @FindBy(xpath = "//div[@class='block left first mn']//li/a[text()='Top Sites by MoonRank']")
    WebElement topByMoonRank;

    @FindBy(xpath = "//div[@class='block left first mn']//li/a[text()='Top Sites by PageRank']")
    WebElement topByPageRank;

    // Search
    @FindBy(xpath = "//input[@id='q']")
    WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//h1")
    WebElement header;

    // Table
    @FindBy(xpath = "//span[@class='in-block v-align-t f14']")
    WebElement tableHeader;


//------------------------------------------------------------------

    public AnyPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void pause(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // --- Navigation
    public void gotoMainPage(){
        if(!webDriver.getCurrentUrl().equals("http://moonsearch.com/")){
            headerLogo.click();
        }
    }

    public void gotoTopDomainsByMoonRank(){
        if(!webDriver.getCurrentUrl().equals("http://moonsearch.com/report/")) {
            action.moveToElement(topDomains).moveToElement(topByMoonRank).click().build().perform();
        }
    }

    public void gotoTopRecentSites(){
        if(!webDriver.getCurrentUrl().equals("http://moonsearch.com/report/?sort=recent")) {
            webDriver.get("http://moonsearch.com/report/?sort=recent");
        }
    }

    public void gotoTopDomainsByPageRank() {
        if(!webDriver.getCurrentUrl().equals("http://moonsearch.com/report/?sort=pagerank")) {
            wait.until(ExpectedConditions.visibilityOf(topDomains));
            action.moveToElement(topDomains).moveToElement(topByPageRank).click().build().perform();
            wait.until(ExpectedConditions.textToBePresentInElement(header,"Top by PageRank"));
        }
    }

    public void gotoSearchByBacklinksPage() {
        wait.until(ExpectedConditions.visibilityOf(searchBy));
        action.moveToElement(searchBy).moveToElement(searchByBacklinks).click().build().perform();
        wait.until(ExpectedConditions.titleIs("Backlink Checker Tool - MoonSearch"));
    }

    // ------ Table
    public String getTableHeader() {
        return tableHeader.getText();
    }

    // ------ Search
    public String getSearchPlaceholder() {
        return searchField.getAttribute("placeholder");
    }

    public void search(String query) {
        type(searchField, query);
        searchButton.click();
    }


}
