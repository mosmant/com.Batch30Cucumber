package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CHQAPage;

public class CHQAStepDefinitions {

    CHQAPage chqaPage = new CHQAPage();

    @Then("CH login linkine tiklar")
    public void chLoginLinkineTiklar() {
        chqaPage.loginLinki.click();
    }

    @Then("CH username kutusuna {string} yazar")
    public void ch_username_kutusuna_yazar(String kullaniciAdi) {
        chqaPage.usernameKutusu.sendKeys(kullaniciAdi);

    }
    @Then("CH password kutusuna {string} yazar")
    public void ch_password_kutusuna_yazar(String sifre) {
        chqaPage.passwordKutusu.sendKeys(sifre);
    }

    @And("CH login butonuna basar.")
    public void chLoginButonunaBasar() {

        chqaPage.loginButonu.click();
    }

    @Then("giris yapilamadigini test eder.")
    public void girisYapilamadiginiTestEder() {
        Assert.assertTrue(chqaPage.girisYapilamadiYazisi.isDisplayed());


    }


    @Then("CH basarili girid yspildigini test eder.")
    public void chBasariliGiridYspildiginiTestEder() {

    }
}
