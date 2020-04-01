package org.test.BankCalculator;

import static com.codeborne.selenide.Selenide.$;

public class BankCalculatorMaxLeaseSection {

    // enter Monthly net income for Maximum lease calculation
    public void enterIncomeMaxLease(String income) {
        $("#netoIncome").setValue(income);
    }

    // enter Monthly financial liabilities for Maximum lease calculation
    public void enterLiabilityMaxLease(String liability) {
        $("#monthlyFinancialObligations").setValue(liability);
    }

    // get the text of Maximum Lease calculation's negative result??
    public String getMaxLeaseNegativeResultTxtMsg() {
        return $("#resultWrapperTextThree .negativeResult").getText();
    }

    // fill in a lease application
    public void clickOnFillInLeaseApplicationBtn() {
        $( "#resultWrapperNumber div.buttons-container a").click();
    }

    // get the text of lease application dialog
    public String getTextOfFillInLeaseApplicationMsg() {
        return $( "#TB_content_container div p").getText();
    }

    // submit form on SEB website
    public void clickOnSubmitOnWebsiteBtn() {
        $("#TB_content_container .actions01 .f-left:nth-child(2) a").click();
    }

    // get the text of submission page header
    public String getTextOfSubmitPageHeader() {
        return $("#headermain").getText();
    }

}
