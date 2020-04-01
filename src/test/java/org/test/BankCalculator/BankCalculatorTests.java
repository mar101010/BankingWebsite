package org.test.BankCalculator;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.switchTo;

public class BankCalculatorTests {

    private BankCalculatorPage bankCalculatorPage = new BankCalculatorPage();
    private BankCalculatorMaxLeaseSection bankCalcMaxLeaseSect = new BankCalculatorMaxLeaseSection();
    private BankCalculatorCarLeasingSection bankCalcCarLeasingSect = new BankCalculatorCarLeasingSection();
    private SoftAssert softAssert = new SoftAssert();
    Selenide driver;

    @BeforeTest
    public void chromeBrowserOpenAndAgree(){
        bankCalculatorPage.open();
        bankCalculatorPage.agreePolicy();
    }

    @AfterTest
    public void chromeBrowserClose(){
        bankCalculatorPage.close();
    }

    @Test
    public void anonymousUserCanStartMaxLeaseApplication(){
        //given
        String fillInLeaseApplicationMsgTxtExpected = "If you are already a client of SEB, please submit the application in the internetbank. If you are not a client of SEB, please submit the application on the website of SEB.";
        bankCalcMaxLeaseSect.enterIncome2000MaxLease();
        bankCalcMaxLeaseSect.enterLiability500MaxLease();
        //when
        bankCalcMaxLeaseSect.clickOnFillInLeaseApplicationBtn();
        String fillInLeaseApplicationMsgTxtActual = bankCalcMaxLeaseSect.getTextOfFillInLeaseApplicationMsg();
        bankCalcMaxLeaseSect.clickOnSubmitOnWebsiteBtn();
        switchTo().window(1);
        String submitPageTitleTextActual = bankCalcMaxLeaseSect.getTextOfSubmitPageHeader();
        String leasingPageTitle = "Car leasing";
        //then
        softAssert.assertEquals(fillInLeaseApplicationMsgTxtActual, fillInLeaseApplicationMsgTxtExpected);
        softAssert.assertEquals(bankCalcMaxLeaseSect.getTextOfSubmitPageHeader(), leasingPageTitle);
        softAssert.assertAll();
    }

    @Test
    public void userCanAddCarLeasingCalcComparison(){
        // given
        bankCalcCarLeasingSect.clickOnCarLeasingSectToExpand();
        switchTo().frame("calculator-frame-08a");
        bankCalcCarLeasingSect.enter9000VehicleSum();
        bankCalcCarLeasingSect.enterDownpaymentSum();
        //when
        bankCalcCarLeasingSect.clickOnAddToComparatBtn();
        String vehiclePriceFromCompTableTxtActual = bankCalcCarLeasingSect.getVehiclePriceFromCompTableTxt();
        //then
        softAssert.assertEquals(vehiclePriceFromCompTableTxtActual, "9 000,00");
        softAssert.assertAll();
        driver.switchTo().defaultContent();
    }

    @Test
    public void incomeMinimumForMaxLeaseApplication(){
        //given
        String leasingNotAllowedExpected = "We cannot provide financing with the entered data. Add a surety, if possible.";
        //when
        bankCalcMaxLeaseSect.enterIncome700Minimum();
        String allowMessageForIncome700actual = bankCalcMaxLeaseSect.getMaxLeaseNegativeResultTxtMsg();
        bankCalcMaxLeaseSect.enterIncome699LessThanMinimum();
        String allowMessageForIncome699actual = bankCalcMaxLeaseSect.getMaxLeaseNegativeResultTxtMsg();
        //then
        softAssert.assertEquals(allowMessageForIncome699actual, leasingNotAllowedExpected);
        softAssert.assertNotEquals(allowMessageForIncome700actual, leasingNotAllowedExpected);
        softAssert.assertAll();
    }

}
