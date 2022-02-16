package TestRunners;

import Blueprints.ProductSearch;
import Setup.Setup;
import org.testng.annotations.Test;

public class SearchTestRunner extends Setup {
    @Test(groups = "search", description = "Search a valid product")
    public void searchValidProduct() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        ProductSearch search = new ProductSearch(driver);
        search.validSearch();
    }

    @Test(groups = "search", description = "Check if auto suggestion works in search bar")
    public void autoSuggestion() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        ProductSearch search = new ProductSearch(driver);
        search.checkAutoSuggestion();
    }

    @Test(groups = "search", description = "Search by typo")
    public void searchByTypo() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        ProductSearch search = new ProductSearch(driver);
        search.typoSearch();
    }

    @Test(groups = "search", description = "Search by drop-down")
    public void searchByDropDown() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        ProductSearch search = new ProductSearch(driver);
        search.dropDownSearch();
    }

    @Test(groups = "search", description = "Sorting products by price after search")
    public void productSort() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        ProductSearch search = new ProductSearch(driver);
        search.sortProduct();
    }
}
