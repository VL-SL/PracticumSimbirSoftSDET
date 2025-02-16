package svm.sibmirsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page {
    private final WebDriver driver;

    // TODO Есть еще чекбокс хобби, но в тест-кейсе не указано протестировать их.
    // TODO А еще на странице присутствует баг. Если выделить дату и удалить, то страница залагает (все пропадет).

    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.cssSelector("#userEmail");
    private final By mobile = By.cssSelector("#userNumber");
    private final By dateOfBirth = By.cssSelector("#dateOfBirthInput");
    private final By monthDropdown = By.className("react-datepicker__month-select");
    private final By yearDropdown = By.className("react-datepicker__year-select");
    private final By subject = By.cssSelector("#subjectsInput");
    private final By picture = By.xpath("//*[@id='uploadPicture']");
    private final By currentAddress = By.cssSelector("#currentAddress");
    private final By selectState = By.cssSelector("#state");
    private final By selectCity = By.cssSelector("#city");
    private final By submit = By.cssSelector("#submit");

    private By gender(String gender){
        return By.cssSelector("label[for='gender-radio-" + gender + "']");
    }

    public void setGender(String gender) {
        driver.findElement(gender(gender)).click();
    }

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void setFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void setMobile(String mobile) {
        driver.findElement(this.mobile).sendKeys(mobile);
    }

    public void setDateOfBirth(String year, String month, String day) {
        driver.findElement(this.dateOfBirth).click();

        Select monthSelect = new Select(driver.findElement(monthDropdown));
        monthSelect.selectByVisibleText(month);

        Select yearSelect = new Select(driver.findElement(yearDropdown));
        yearSelect.selectByVisibleText(year);

        driver.findElement(By.xpath(String.format("//div[contains(@class," +
                " 'react-datepicker__day') and text()='%s']", day))).click();
    }

    public void setSubject(String subject) {
        WebElement subjectInput = driver.findElement(this.subject);
        subjectInput.click();

        subjectInput.sendKeys(subject);
        subjectInput.sendKeys(Keys.ENTER);
    }

    public void setPicture(String picturePath) {
        driver.findElement(this.picture).sendKeys(picturePath);
    }

    public void setCurrentAddress(String currentAddress) {
        driver.findElement(this.currentAddress).sendKeys(currentAddress);
    }

    public void setSelectState(String selectState) {
        driver.findElement(this.selectState).click();
        driver.findElement(By.xpath("//div[text()='" + selectState + "']")).click();
    }

    public void setSelectCity(String selectCity) {
        driver.findElement(this.selectCity).click();
        driver.findElement(By.xpath("//div[text()='" + selectCity + "']")).click();
    }

    public void submitForm() {
        driver.findElement(submit).click();
    }
}
