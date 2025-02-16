package svm.sibmirsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void inputText(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected void selectFromDropdown(By dropdownLocator, String value) {
        Select dropdown = new Select(findElement(dropdownLocator));
        dropdown.selectByVisibleText(value);
    }
}