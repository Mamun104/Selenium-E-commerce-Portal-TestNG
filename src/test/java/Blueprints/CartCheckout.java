package Blueprints;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CartCheckout {
    WebDriverWait wait;
    WebDriver driver;


    @FindBy(className = "header-search-input")
    WebElement barSearch;
    @FindBy(className = "header-search-button")
    WebElement btnSearch;
    @FindBy(xpath = "//h2[contains(text(),'Black trousers')]")
    WebElement header;
    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    WebElement btnCart;
    @FindBy(xpath = "//a[contains(text(),\"View cart\")]")
    List<WebElement> btnViewCart;
    @FindBy(className = "remove")
    WebElement btnDelete;
    @FindBy(className = "nav-link")
    List<WebElement> subMenu;
    @FindBy(xpath = "//h2[contains(text(),'Single Shirt')]")
    WebElement singleShirt;
    @FindBy(xpath = "//button[contains(text(),'+')]")
    WebElement btnPlus;
    @FindBy(xpath = "//h2[contains(text(),'Polo T-shirt')]")
    WebElement anotherHeader;
    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement chooseColor;
    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    WebElement btnCheckout;
    @FindBy(xpath = "//button[@id='place_order']")
    WebElement btnPlaceOrder;


    public CartCheckout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addDelete() throws InterruptedException {
        barSearch.sendKeys("trouser");
        btnSearch.click();
        Thread.sleep(2500);
        header.click();
        Thread.sleep(2500);
        btnCart.click();
        btnViewCart.get(0).click();
        Thread.sleep(3500);
        btnDelete.click();
        Thread.sleep(4000);
        String s = driver.findElement(By.xpath("//p[contains(text(),'Your cart is currently empty.')]")).getText();
        Assert.assertTrue(s.contains("currently empty"));
    }

    public void addMultipleProduct() throws InterruptedException {
        subMenu.get(2).click();
        Thread.sleep(2500);
        singleShirt.click();
        Thread.sleep(2500);
        btnPlus.click();
        btnCart.click();
        btnViewCart.get(0).click();
        Thread.sleep(3500);
    }

    public void addMultipleColor() throws InterruptedException {
        subMenu.get(1).click();
        Thread.sleep(3000);
        anotherHeader.click();
        Thread.sleep(3000);
        Select select = new Select(chooseColor);
        select.selectByValue("white");
        btnCart.click();
        btnViewCart.get(0).click();
        Thread.sleep(3500);
    }

    public void productDetail() throws InterruptedException {
        subMenu.get(1).click();
        Thread.sleep(3000);
        anotherHeader.click();
        Thread.sleep(3000);
        Select select = new Select(chooseColor);
        select.selectByValue("white");
        btnCart.click();
        btnViewCart.get(0).click();
        Thread.sleep(3500);
        btnCheckout.click();
        Thread.sleep(3500);
        String s = driver.findElement(By.xpath("//h1[contains(text(),'Checkout')]")).getText();
        Assert.assertTrue(s.contains("Checkout"));
    }

    public void checkoutNullValue() throws InterruptedException {
        subMenu.get(1).click();
        Thread.sleep(3000);
        anotherHeader.click();
        Thread.sleep(3000);
        Select select = new Select(chooseColor);
        select.selectByValue("white");
        btnCart.click();
        btnViewCart.get(0).click();
        Thread.sleep(3500);
        btnCheckout.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(btnPlaceOrder));
        Thread.sleep(10000);
        btnPlaceOrder.click();
        Thread.sleep(5000);
        String s = driver.findElement(By.xpath("//li[contains(text(),'Invalid payment method.')]")).getText();
        Assert.assertTrue(s.contains("Invalid"));
    }
}
