package steps;

import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {

    protected WebDriver driver;
    public BaseSteps(CommonConditions commonConditions) {
        this.driver = commonConditions.getDriver();
    }
}