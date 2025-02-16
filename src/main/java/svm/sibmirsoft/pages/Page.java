package svm.sibmirsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Page extends BasePage {
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

    // TODO Есть еще чекбокс хобби, но в тест-кейсе не указано протестировать их.
    // TODO А еще на странице присутствует баг. Если выделить дату и удалить, то страница залагает (все пропадет).

    public Page(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void setFirstName(String firstName) {
        inputText(this.firstName, firstName);
    }

    public void setLastName(String lastName) {
        inputText(this.lastName, lastName);
    }

    public void setEmail(String email) {
        inputText(this.email, email);
    }

    public void setMobile(String mobile) {
        inputText(this.mobile, mobile);
    }

    public void setDateOfBirth(String year, String month, String day) {
        click(this.dateOfBirth);
        selectFromDropdown(monthDropdown, month);
        selectFromDropdown(yearDropdown, year);
        click(By.xpath(String.format("//div[contains(@class, 'react-datepicker__day') and text()='%s']", day)));
    }

    public void setSubject(String subject) {
        click(this.subject);
        inputText(this.subject, subject);
        findElement(this.subject).sendKeys(Keys.ENTER);
    }

    public void setPicture(String picturePath) {
        inputText(this.picture, picturePath);
    }

    public void setCurrentAddress(String currentAddress) {
        inputText(this.currentAddress, currentAddress);
    }

    public void setSelectState(String selectState) {
        click(this.selectState);
        click(By.xpath("//div[text()='" + selectState + "']"));
    }

    public void setSelectCity(String selectCity) {
        click(this.selectCity);
        click(By.xpath("//div[text()='" + selectCity + "']"));
    }

    public void submitForm() {
        click(submit);
    }

    private By gender(String gender) {
        return By.cssSelector("label[for='gender-radio-" + gender + "']");
    }

    public void setGender(String gender) {
        click(gender(gender));
    }
}