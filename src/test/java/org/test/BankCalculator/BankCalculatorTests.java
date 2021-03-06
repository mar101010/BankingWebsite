package org.test.BankCalculator;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.switchTo;

public class BankCalculatorTests {

    public BankCalculatorPage bankCalcPage = new BankCalculatorPage();
    public BankCalculatorMaxLeaseSection bankCalcMaxLeaseSect = new BankCalculatorMaxLeaseSection();
    public BankCalculatorCarLeasingSection bankCalcCarLeasingSect = new BankCalculatorCarLeasingSection();
    public SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void openPage() {
        bankCalcPage.open();
        bankCalcPage.agreeToPolicy();
}

    @AfterClass
    public void tearDown() {
        bankCalcPage.closeWebDriver();
    }

//    @BeforeMethod
    public void setUp() {
  //      bankCalcPage.open();
   //     bankCalcPage.agreeToPolicy();
    }

    @AfterMethod
    public void refresh() {
        bankCalcPage.refreshBrowser();
    }

    @Test
    public void userCanSubmitApplicationForLease() {
        //given
        bankCalcMaxLeaseSect.enterIncomeMaxLease("2000");
        bankCalcMaxLeaseSect.enterLiabilityMaxLease("500");
        //when
        bankCalcMaxLeaseSect.clickOnFillInLeaseApplicationBtn();
        String fillInLeaseApplicationMsgTxtExpected = "If you are already a client of SEB, please submit the application in the internetbank. If you are not a client of SEB, please submit the application on the website of SEB.";
        String fillInLeaseApplicationMsgTxtActual = bankCalcMaxLeaseSect.getTextOfFillInLeaseApplicationMsg();
        bankCalcMaxLeaseSect.clickOnSubmitOnWebsiteBtn();
        switchTo().window(1);
        String submitPageTitleTxtActual = bankCalcMaxLeaseSect.getTextOfSubmitPageHeader();
        String submitPageTitleTxtExpected = "Sõidukiliising";
        //then
        softAssert.assertEquals(fillInLeaseApplicationMsgTxtActual, fillInLeaseApplicationMsgTxtExpected);
        softAssert.assertEquals(submitPageTitleTxtActual, submitPageTitleTxtExpected);
        softAssert.assertAll();
    }

    @Test
    public void userCanAddCarLeasingCalcComparison(){
        // given
        bankCalcCarLeasingSect.clickOnCarLeasingSectToExpand();
        bankCalcCarLeasingSect.switchToCarLeasingCalcIframe();
        bankCalcCarLeasingSect.enterVehicleSum("9000");
        bankCalcCarLeasingSect.enterDownpaymentSum("50");
        //when
        bankCalcCarLeasingSect.clickOnAddToCompBtn();
        String vehiclePriceFromCompTableTxtActual = bankCalcCarLeasingSect.getVehiclePriceFromCompTableTxt();
        //then
        softAssert.assertEquals(vehiclePriceFromCompTableTxtActual, "9 000,00");
        System.out.println("actual is " + vehiclePriceFromCompTableTxtActual + ", expected is 9 000,00");
        softAssert.assertAll();
    }

    @Test
    public void incomeMinimumForMaxLeaseApplication(){
        //given
        String maxLeaseNegativeResultTxtMsgExpected = "We cannot provide financing with the entered data. Add a surety, if possible.";
        //when
        bankCalcMaxLeaseSect.enterIncomeMaxLease("700");
        boolean maxLeaseNegativeResultTxtMsgFor700= bankCalcMaxLeaseSect.isMaxLeaseNegativeResultTxtMsgVisible();
        bankCalcMaxLeaseSect.enterIncomeMaxLease("699");
        boolean maxLeaseNegativeResultTxtMsgFor699= bankCalcMaxLeaseSect.isMaxLeaseNegativeResultTxtMsgVisible();
        String maxLeaseNegativeResultTxtMsgActual = bankCalcMaxLeaseSect.getMaxLeaseNegativeResultTxtMsg();
        //then
        softAssert.assertEquals(maxLeaseNegativeResultTxtMsgActual, maxLeaseNegativeResultTxtMsgExpected);
        softAssert.assertFalse(maxLeaseNegativeResultTxtMsgFor700);
        softAssert.assertFalse(!maxLeaseNegativeResultTxtMsgFor699);
        System.out.println("max lease neg res exp = "+maxLeaseNegativeResultTxtMsgExpected+", max lease neg res act = "+maxLeaseNegativeResultTxtMsgActual);
        softAssert.assertAll();
    }

}


