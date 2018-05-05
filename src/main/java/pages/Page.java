package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;


public abstract class Page {

	public WebDriver webDriver;
	public WebDriverWait wait;
	public Actions action;


	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
		wait = new WebDriverWait(webDriver,10);
		action = new Actions(webDriver);
	}

	public void gotoLink(String url){
		webDriver.get(url);
	}

    public void type(WebElement locator, String text){
        if(text!=null){
            locator.clear();
            locator.sendKeys(text);
        }
    }

	public int generateRandomNumber(int min,int max){
		Random rand = new Random();
		int  number = rand.nextInt((max - min) + 1) + min;
		return number;
	}


}
