package seminar05.test;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest {
    @Test
    void testUserAuth() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton\\Desktop\\Testing\\libs\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.id("login-button"));
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        button.click();
        WebElement label = driver.findElement(By.className("title"));
        assertThat(label.getText()).isEqualTo("Products");
        driver.quit();
    }


}
