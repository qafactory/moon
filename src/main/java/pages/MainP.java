package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainP extends AnyPage{
    //Top menu
    @FindBy(xpath = "//div[@class='block left first mn']")
    WebElement topDomainsMenu;

    @FindBy(xpath = "//div[@class='block left first mn']/div[@class='sub-menu abs']//li[1]/a")
    WebElement topSitesByMR;


    @FindBy(xpath = "//h1")
    WebElement header;

    //Top Sites section

    @FindBy(xpath = "(//section[@class='sites-analysis f14 p-relative in-block']/header/span)[1]")
    WebElement topSitesHeader;

    @FindBy(xpath = "(//section[@class='sites-analysis f14 p-relative in-block'])[1]/section/a/span[2]")
    List<WebElement> topSitesList;

    @FindBy(xpath = "//section[2]/header/span")
    WebElement recentSitesHeader;

    @FindBy(xpath = "//section[2]/section/a/span[2]")
    List<WebElement> recentSitesList;

    @FindBy(xpath = "//section[2]/footer/a")
    WebElement showMoreRecentSitesLink;

    @FindBy(xpath = "//section[@class='sites-analysis f14 p-relative in-block'][3]/header/span")
    WebElement sitesByPRHeader;

    @FindBy(xpath = "//section[3]//a/span[2]")
    List<WebElement> sitesByPRList;

    @FindBy(xpath = "//section[3]/footer/a")
    WebElement showMoreSitesByPRLink;





    public MainP(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }


    public boolean topSitesHeaderIsDisplayed() {
        return topSitesHeader.isDisplayed();
    }

    public List<String> getTopSitesList() {
        List<String> list = new ArrayList<String>();
        String name;
        for(WebElement site:topSitesList){
            name = site.getText();
            list.add(name);
        }
        return list;

    }

    public String getHeader() {
        return header.getText();
    }

    public void gotoTopDomainsP() {
        action.moveToElement(topDomainsMenu).moveToElement(topSitesByMR).click().build().perform();
    }

    public boolean recentSitesHeaderIsDisplayed() {
        System.out.println(recentSitesHeader.getText());
        return recentSitesHeader.isDisplayed();
    }

    public List<String> getRecentSitesList() {
        List<String> list = new ArrayList<>();
        String name;
        for(WebElement site:recentSitesList){
            name = site.getText();
            list.add(name);
        }

        return list;
    }

    public void gotoRecentSitesP() {
        showMoreRecentSitesLink.click();
    }

    public boolean sitesByPRHeaderIsDisplayed() {
        System.out.println(sitesByPRHeader.getText());
        return sitesByPRHeader.isDisplayed();
    }


    public List<String> getSitesByPR() {
        List<String> list = new ArrayList<>();
        String name;
        for(WebElement site:sitesByPRList){
            name = site.getText();
            list.add(name);
        }
        System.out.println("on main page:" + list);
        return list;
    }


    public void gotoSitesByPRP() {
        showMoreSitesByPRLink.click();

    }
}
