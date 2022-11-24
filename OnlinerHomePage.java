package page;
import org.openqa.selenium.By;

public class OnlinerHomePage {

    // just By methods
    driver.findElement(By.id("navigation-sidebar"));
    driver.findElement(By.name("query"));
    driver.findElement(By.className("onliner_logo"));
    driver.findElement(By.tagName("img"));
    driver.findElement(By.linkText("Санки"));
    driver.findElement(By.partialLinkText("Щетки"));

    // By.xpath() variations
    driver.findElement(By.xpath("//input[@type='text']"));
    driver.findElement(By.xpath("//button[contains(@type, 'subm')]"));
    driver.findElement(By.xpath("//span[text()='Санки']"));
    driver.findElement(By.xpath("//span[contains(text(), 'аккумуляторы')]"));

    // By.xpath() using axes
    driver.findElement(By.xpath("//div[text()='Компьютеры и сети']/ancestor::a"));
    driver.findElement(By.xpath("//div[@class='widget-item']/descendant::a"));
    driver.findElement(By.xpath("//div[@class='project-navigation']/following-sibling::div"));
    driver.findElement(By.xpath("//span[text()='Санки']//parent::span"));
    driver.findElement(By.xpath("//ul[contains(@class, 'project-navigation')]//preceding-sibling::a"));

    // By.xpath with and
    driver.findElement(By.xpath("//span[contains(@class, 'project-navigation') and text()='Санки']"));

    // By.cssSelector() variations
    driver.findElement(By.cssSelector(".widget-item"));
    driver.findElement(By.cssSelector(".b-tiles.cfix"));
    driver.findElement(By.cssSelector(".project-navigation__text .project-navigation__sign"));
    driver.findElement(By.cssSelector("#navigation-sidebar"));
    driver.findElement(By.cssSelector("input"));
    driver.findElement(By.cssSelector("input.fast-search__input"));
    driver.findElement(By.cssSelector("[target='_blank']"));
    driver.findElement(By.cssSelector("[title~='RSS']"));
    driver.findElement(By.cssSelector("[type|='text']"));
    driver.findElement(By.cssSelector("a[href^='https://catalog']"));
    driver.findElement(By.cssSelector("a[href$='superprice']"));
    driver.findElement(By.cssSelector("a[href*='people']"));
}