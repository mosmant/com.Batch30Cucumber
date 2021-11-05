package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.EditorPage;
import utilities.Driver;

import javax.swing.*;

public class EditorStepDefinition {
    EditorPage editorPage = new EditorPage();
    Actions actions = new Actions(Driver.getDriver());
    @Then("new butonuna tiklar")
    public void newButonunaTiklar() {
        editorPage.newButton.click();

    }

    @And("editor firstname textboxuna {string} bilgileri girer.")
    public void editorFirstnameTextboxunaBilgileriGirer(String firstName) {
        editorPage.firstName.sendKeys(firstName);
    }

    @And("editor lastName textboxuna {string} bilgileri girer.")
    public void editorLastNameTextboxunaBilgileriGirer(String lastName) {
        editorPage.lastName.sendKeys(lastName);
    }

    @And("editor position textboxuna {string} bilgileri girer.")
    public void editorPositionTextboxunaBilgileriGirer(String position) {
        editorPage.position.sendKeys(position);
    }

    @And("editor office textboxuna {string} bilgileri girer.")
    public void editorOfficeTextboxunaBilgileriGirer(String office) {
        editorPage.office.sendKeys(office);
    }

    @And("editor extension textboxuna {string} bilgileri girer.")
    public void editorExtensionTextboxunaBilgileriGirer(String extension) {
        editorPage.extension.sendKeys(extension);
    }

    @And("editor startDate textboxuna {string} bilgileri girer.")
    public void editorStartDateTextboxunaBilgileriGirer(String startDate) {
        editorPage.startDate.sendKeys(startDate);
    }

    @And("editor salary textboxuna {string} bilgileri girer.")
    public void editorSalaryTextboxunaBilgileriGirer(String salary) {
        editorPage.salary.sendKeys(salary);
    }

    @And("Create tusuna basar")
    public void createTusunaBasar() {
        editorPage.createButton.click();


    }


    @And("editor textboxuna {string} {string} {string} {string} {string} {string} {string} bilgileri girer.")
    public void editorTextboxunaBilgileriGirer(String firstName, String lastName, String position, String office, String extension, String startDate, String salary) {

        actions .sendKeys(editorPage.firstName,firstName)
                .sendKeys(Keys.TAB)
                .sendKeys(lastName)
                .sendKeys(Keys.TAB)
                .sendKeys(position)
                .sendKeys(Keys.TAB)
                .sendKeys(office)
                .sendKeys(Keys.TAB)
                .sendKeys(extension)
                .sendKeys(Keys.TAB)
                .sendKeys(startDate)
                .sendKeys(Keys.TAB)
                .sendKeys(salary)
                .click(editorPage.createButton).perform();


    }

    @Then("{string} ve {string} girerek kaydin tamamlandigini test eder.")
    public void veGirerekKaydinTamamlandiginiTestEder(String firstName, String lastName) throws InterruptedException {
        Thread.sleep(2000);
        editorPage.searchBox.click();
        editorPage.searchBox.sendKeys(firstName+" "+lastName);
        Assert.assertTrue(editorPage.firstNameCheck.isDisplayed());

    }
}
