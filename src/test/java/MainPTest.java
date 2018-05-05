

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainP;
import pages.RecentSitesP;
import pages.SitesByPRP;
import pages.TopDomainsP;

import java.util.List;

public class MainPTest extends TBase {
    MainP mainP;
    TopDomainsP topDomainsP;
    RecentSitesP recentSitesP;
    SitesByPRP sitesByPRP;

    @BeforeClass
    public void setup(){
        mainP = PageFactory.initElements(driver,MainP.class);
        topDomainsP = PageFactory.initElements(driver,TopDomainsP.class);
        recentSitesP = PageFactory.initElements(driver,RecentSitesP.class);
        sitesByPRP = PageFactory.initElements(driver,SitesByPRP.class);
    }

    @BeforeMethod
    public void startPage(){
        driver.get(baseUrl);
    }


    @Test
    public void checkPageTitle(){
        Assert.assertEquals(mainP.getPageTitle(), "MoonSearch - Free SEO Analysis, Tools & Reports");
        System.out.println(driver.getTitle());
    }

    @Test
    public void checkHeader() {
        Assert.assertEquals(mainP.getHeader(), "Backlinks checker & SEO Report\n" +
                "500m+ urls analyzed in 22m+ domains");
    }

    @Test
    public void checkTopSitesList(){
        Assert.assertTrue(mainP.topSitesHeaderIsDisplayed());

        List<String> topSites = mainP.getTopSitesList();

        mainP.gotoTopDomainsP();
        List<String> allTopSites = topDomainsP.getTopSites(5);

        Assert.assertEquals(topSites,allTopSites);
    }

    @Test
    public void checkRecentSites(){
        Assert.assertTrue(mainP.recentSitesHeaderIsDisplayed());

        List<String> recentSitesList = mainP.getRecentSitesList();

        mainP.gotoRecentSitesP();

        Assert.assertTrue(recentSitesP.isPageCorrect());

        List<String> allRecentSites = recentSitesP.getRecentSites(5);

        Assert.assertEquals(recentSitesList, allRecentSites);
    }

    @Test
    public void checkTopSitesByPR(){
        Assert.assertTrue(mainP.sitesByPRHeaderIsDisplayed());
        List<String> sitesByPR = mainP.getSitesByPR();
        mainP.gotoSitesByPRP();

        Assert.assertTrue(sitesByPRP.isCorrectPage());
        List<String> allSitesByPR = sitesByPRP.getSitesByPR(5);
        Assert.assertEquals(sitesByPR,allSitesByPR);
    }

    

}
