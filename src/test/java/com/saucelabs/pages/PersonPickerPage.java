package com.saucelabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by Iakov Volf on 2/20/2015.
 */
public class PersonPickerPage {
    WebDriver driver;

    @FindBy(id = "processedPersonKey")
    WebElement pickProcessedPersonLink;
    @FindBy(id = "btnProcessedProcessPerson")
    WebElement pickProcessedPersonBtn;
    @FindBy(id = "btnYourselfProcessPerson")
    WebElement pickYourselfBtn;
    @FindBy(id = "PersonPickerSearchProcessPerson")
    WebElement pickerSearchInput;

    public PersonPickerPage() {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public static PersonPickerPage navigateTo(WebDriver driver) {
        driver.get("http://alphaex.insynctiveapps.com/Insynctive.Components/Pickers/BasicPerson");
        return PageFactory.initElements(driver,
                PersonPickerPage.class);
    }

    public void waitUntilElementIsLoaded(WebElement element) throws IOException, InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
    }
}
