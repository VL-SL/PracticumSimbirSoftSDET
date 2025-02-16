package svm.sibmirsoft.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        page.setLastName("Сливницин");
        page.setEmail("sliw.vladisl@yandex.ru");
        page.setGender("1");
        page.setMobile("6666666666");
        page.setDateOfBirth("2003","April", "25");
        page.setSubject("Maths");
        page.setPicture("C:/Users/sliwv/Downloads/test.jpg");
        page.setCurrentAddress("ВОМЗ");
        page.setSelectState("NCR");
        page.setSelectCity("Noida");

        page.submitForm();
    }
}
