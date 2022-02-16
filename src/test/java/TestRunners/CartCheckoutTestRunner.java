package TestRunners;

import Blueprints.CartCheckout;
import Setup.Setup;
import org.testng.annotations.Test;

public class CartCheckoutTestRunner extends Setup {
    @Test(groups = "cart", description = "Add and delete a product from cart")
    public void addAndDeleteProduct() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        CartCheckout cartCheckout = new CartCheckout(driver);
        cartCheckout.addDelete();
    }

    @Test(groups = "cart", description = "Add multiple product")
    public void addMultiple() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        CartCheckout cartCheckout = new CartCheckout(driver);
        cartCheckout.addMultipleProduct();
    }

    @Test(groups = "cart", description = "Add multiple color by drop-down")
    public void addColor() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        CartCheckout cartCheckout = new CartCheckout(driver);
        cartCheckout.addMultipleColor();
    }

    @Test(groups = "cart", description = "To check if product details are displayed properly")
    public void checkOut() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        CartCheckout cartCheckout = new CartCheckout(driver);
        cartCheckout.productDetail();
    }

    @Test(groups = "cart", description = "Placing order without filling up any information")
    public void placeOrder() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        CartCheckout cartCheckout = new CartCheckout(driver);
        cartCheckout.checkoutNullValue();
    }
}
