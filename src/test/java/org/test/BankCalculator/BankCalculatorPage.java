package org.test.BankCalculator;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class BankCalculatorPage {

    //web browser setup

    public BankCalculatorPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        Configuration.baseUrl = "https://www.seb.ee/eng/loan-and-leasing/leasing/car-leasing#calculator";
    }

    // open web browser
    public void open() {
        Selenide.open("/");
    }

    public void closeWebDriver(){
        Selenide.closeWebDriver();
    }
    public void refreshBrowser(){
        Selenide.refresh();
    }

    public void agreeToPolicy(){
        $(".main.accept-selected").click();
    }

}
