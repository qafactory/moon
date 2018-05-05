package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class RecentSitesP extends AnyPage {

    @FindBy(xpath = "//h1")
    WebElement header;

    @FindBy(xpath = "//a[@class='domain f16 in-block v-align-t']")
    List<WebElement> recentSitesList;
    
    
    
    

//--------------------------------------------
    public RecentSitesP(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isPageCorrect() {
        wait.until(ExpectedConditions.visibilityOf(header));

        String h1 = header.getText();
        String result = h1.substring(0, 23);
        System.out.println(result);
        return result.equals("Recently analysed sites");
    }

    public List<String> getAllRecentSites(){
        List<String> list = new ArrayList<>();
        String name;
        for(WebElement site:recentSitesList){
            name=site.getText();
            list.add(name);
        }
        return list;
    }

    public List<String> getRecentSites(int i) {
        List<String> list = getAllRecentSites().subList(0,i);
        return list;
    }
}
