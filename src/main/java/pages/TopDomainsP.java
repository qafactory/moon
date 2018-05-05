package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emma on 6/26/15.
 */
public class TopDomainsP extends AnyPage{

    @FindBy(xpath = "//div[@class='dom-wd in-block v-align-t f16']/a")
    List<WebElement> topList;



//------------------------------------------------------------------

    public TopDomainsP(WebDriver webDriver) {
        super(webDriver);
    }


    public List<String> getTopSitesList() {
        List<String> list = new ArrayList<String>();
        String name;
        for(WebElement site: topList){
            name=site.getText();
            list.add(name);
        }

        return list;
    }

    public List<String> getTopSites(int n) {
        System.out.println();
        return getTopSitesList().subList(0,n);
    }
}
