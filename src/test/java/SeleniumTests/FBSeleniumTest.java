package SeleniumTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FBSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver","C:/Users/Rayvon/OneDrive/Documents/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://facebook.com");
    }
    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    void Test() {
        WebElement aboutAnchorTag = driver.findElement(By.tagName("a"));
        String expected = "";
        String actual = aboutAnchorTag.getText();
        assertEquals(expected, actual);
    }
    @Test
    void testBack() {
        driver.navigate().to("https://twitter.com");
        driver.navigate().back();
        assertEquals("Facebook - Log In or Sign Up", driver.getTitle());
    }
    @Test
    void testForward() {
        driver.navigate().to("https://instagram.com");
        driver.navigate().back();
        driver.navigate().forward();
        assertEquals("Instagram", driver.getTitle());
    }
    @Test
    void testRefresh() {
        driver.navigate().refresh();
        assertEquals("Facebook - Log In or Sign Up", driver.getTitle());
    }
    @Test
    void testPrintAllAnchors() {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        for (WebElement anchor : anchors) {
            System.out.println(anchor.getText());
        }
    }
    @Test
    void testHasItemsAnchor() {
            List<WebElement> anchors = driver.findElements(By.tagName("a"));
            List<String> anchorContents = new ArrayList<String>();
            for(WebElement anchor : anchors) {
                anchorContents.add(anchor.getText());
            }
            assertThat(anchorContents, hasItems("Forgot Password", "Create a Page", "Watch"));


    }
    @Test
    void testAboutUrl() {
        WebElement anchor = driver.findElement(By.tagName("a"));
        anchor.click();
        assertEquals("https://facebook.com/pages/create/?ref_type=registration_form", driver.getCurrentUrl());
    }

}
