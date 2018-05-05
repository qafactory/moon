package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PracticeP extends Page {
    @FindBy(xpath = "//ul[@class='menu-list']/li/a")
    List<WebElement> categoryList;

    @FindBy(xpath = "")
    List<WebElement> subCategoryList;




    public PracticeP(WebDriver webDriver) {
        super(webDriver);
    }

//-------- MAKEUP------------------------------
    public void selectCategory(String category) {

        for (WebElement name: categoryList) {
            if (name.getText().equals(category)) {
                name.click();
            }
        }
    }

    public void selectSubCategory(String category, String subcategory) {
        for (WebElement name: categoryList) {
            if (name.getText().equals(category)) {
                action.moveToElement(name).build();
            }else {
                throw new Error("No such category");
            }






        }
    }


}
