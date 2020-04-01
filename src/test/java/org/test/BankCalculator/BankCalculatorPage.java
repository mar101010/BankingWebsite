package org.test.BankCalculator;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.sql.DriverManager.getDriver;

public class BankCalculatorPage {

    //web browser setup
    public BankCalculatorPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        Configuration.baseUrl = "https://www.seb.ee/eng/loan-and-leasing/leasing/car-leasing#calculator";
    }

    // open web browser
    public BankCalculatorPage open() {
        Selenide.open("/");
        return this;
    }

    public void agreePolicy(){
        $(".main.accept-selected").click();
    }

}
