package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SitesByPRP extends AnyPage {

    @FindBy(xpath = "//h1")
    WebElement header;

    @FindBy(xpath = "//td//a")
    List<WebElement> allSitesByPR;







    public SitesByPRP(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isCorrectPage() {
        String h = header.getText();
        String result = h.substring(0,15);
        System.out.println(result);
        return result.equals("Top by PageRank");
    }

    public List<String> getSitesByPRList(){
        List<String> list = new ArrayList<>();
        String name;
        for(WebElement site:allSitesByPR){
            name = site.getText();
            list.add(name);
        }
        return list;
    }

    public List<String> getSitesByPR(int i) {
        return getSitesByPRList().subList(0,i);
    }
}
