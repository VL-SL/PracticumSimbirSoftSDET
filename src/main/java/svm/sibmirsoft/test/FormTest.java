package svm.sibmirsoft.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import svm.sibmirsoft.pages.Page;
import org.testng.annotations.BeforeMethod;

public class FormTest {
    private Page page;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new Page(driver);
    }

    @Test
    public void testForm() {
        page.open();

        page.setFirstName("Владислав");
        Assert.assertEquals(page.getFirstName(), "Владислав", "First Name is incorrect");
        page.setLastName("Сливницин");
        Assert.assertEquals(page.getLastName(), "Сливницин", "Last Name is incorrect");
        page.setEmail("sliw.vladisl@yandex.ru");
        Assert.assertEquals(page.getEmail(), "sliw.vladisl@yandex.ru", "Email is incorrect");
        page.setGender("1");
        page.setMobile("6666666666");
        Assert.assertEquals(page.getMobile(), "6666666666", "Mobile is incorrect");
        page.setDateOfBirth("2003","April", "25");
        Assert.assertEquals(page.getDateOfBirth(), "25 Apr 2003", "Date of Birth is incorrect");
        page.setSubject("Maths");
        page.setPicture("C:/Users/sliwv/Downloads/test.jpg");
        page.setCurrentAddress("ВОМЗ");
        Assert.assertEquals(page.getCurrentAddress(), "ВОМЗ", "Current Address is incorrect");
        page.setSelectState("NCR");
        page.setSelectCity("Noida");

        page.submitForm();

        Assert.assertEquals(page.getModalTitle(), "Thanks for submitting the form");

        Assert.assertEquals(page.getTableValue("Student Name"), "Владислав Сливницин", "Student Name is incorrect");
        Assert.assertEquals(page.getTableValue("Student Email"), "sliw.vladisl@yandex.ru", "Student Email is incorrect");
        Assert.assertEquals(page.getTableValue("Gender"), "Male", "Gender is incorrect");
        Assert.assertEquals(page.getTableValue("Mobile"), "6666666666", "Mobile is incorrect");
        Assert.assertEquals(page.getTableValue("Date of Birth"), "25 April,2003", "Date of Birth is incorrect");
        Assert.assertEquals(page.getTableValue("Subjects"), "Maths", "Subjects is incorrect");
        Assert.assertEquals(page.getTableValue("Address"), "ВОМЗ", "Address is incorrect");
        Assert.assertEquals(page.getTableValue("State and City"), "NCR Noida", "State and City is incorrect");
    }
}
