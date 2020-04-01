package org.test.BankCalculator;

import static com.codeborne.selenide.Selenide.$;

public class BankCalculatorMaxLeaseSection {

    // enter Monthly net income for Maximum lease calculation
    public void enterIncome2000MaxLease() {
        final String income2000MaxLeaseTxtboxId = "#netoIncome";
        $(income2000MaxLeaseTxtboxId).setValue("2000");
    }

    // enter Monthly net income for Maximum lease calculation
    public void enterIncome700Minimum() {
        final String income700MinTxtboxId = "#netoIncome";
        $(income700MinTxtboxId).setValue("700");
    }

    // enter Monthly net income for Maximum lease calculation
    public void enterIncome699LessThanMinimum() {
        final String income699LessThanMinTxtboxId = "#netoIncome";
        $(income699LessThanMinTxtboxId).setValue("699");
    }

    // enter Monthly financial liabilities for Maximum lease calculation
    public void enterLiability500MaxLease() {
        final String liability500MaxLeaseTxtboxId = "#monthlyFinancialObligations";
        $(liability500MaxLeaseTxtboxId).setValue("500");
    }

    // get the text of submission page title
    public String getMaxLeaseNegativeResultTxtMsg() {
        final String maxLeaseNegativeResultTxtMsg = "#resultWrapperTextThree .negativeResult";
        return $(maxLeaseNegativeResultTxtMsg).getText();
    }

    // fill in a lease application
    public void clickOnFillInLeaseApplicationBtn() {
        String fillInLeaseApplicationBtn = "#resultWrapperNumber div.buttons-container a";
        $(fillInLeaseApplicationBtn).click();
    }

    // get the text of submission page title
    public String getTextOfFillInLeaseApplicationMsg() {
        final String submitPageTitleText = "#TB_content_container div p";
        return $(submitPageTitleText).getText();
    }

    // submit form on SEB website
    public void clickOnSubmitOnWebsiteBtn() {
        String submitOnWebsiteLink = "https://e.seb.ee/ip/ipank.p?act=CRMCONTACT&topic_code=t_lseauto&pt=unknown";
        $("#TB_content_container .actions01 .f-left:nth-child(2) a").click();
    }

    // get the text of submission page title
    public String getTextOfSubmitPageHeader() {
        return $("#headermain").getText();
    }

}
