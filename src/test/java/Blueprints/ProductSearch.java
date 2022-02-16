package Blueprints;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductSearch {
    WebDriver driver;

    @FindBy(className = "header-search-input")
    WebElement barSearch;
    @FindBy(className = "header-search-button")
    WebElement btnSearch;
    @FindBy(xpath = "//h1[contains(text(),'Black pants')]")
    WebElement titleProduct;
    @FindBy(className = "header-search-select")
    WebElement dropdown;
    @FindBy(className = "orderby")
    WebElement orderBy;


    public ProductSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validSearch() throws InterruptedException {
        barSearch.sendKeys("black pant");
        btnSearch.click();
        Thread.sleep(2500);
        String s = titleProduct.getText();
        Assert.assertTrue(s.contains("Black pants"));
    }

    public void checkAutoSuggestion() throws InterruptedException {
        barSearch.sendKeys("bla");
        Thread.sleep(2500);
    }

    public void typoSearch() throws InterruptedException {
        barSearch.sendKeys("triuser");
        btnSearch.click();
        Thread.sleep(2500);
    }

    public void dropDownSearch() throws InterruptedException {
        Select select = new Select(dropdown);
        select.selectByValue("watches");
        btnSearch.click();
        Thread.sleep(3000);
    }

    public void sortProduct() throws InterruptedException {
        barSearch.sendKeys("black");
        btnSearch.click();
        Thread.sleep(2500);
        Select select = new Select(orderBy);
        select.selectByValue("price");
        Thread.sleep(3000);
    }
}
