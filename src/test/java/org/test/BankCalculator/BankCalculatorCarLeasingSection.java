package org.test.BankCalculator;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class BankCalculatorCarLeasingSection {

    //click on arrow icon expand Car leasing calculator tab
    public void clickOnCarLeasingSectToExpand() {
        $(".groups01.clear div .heading").click();
    }

    //switch to iframe
    public void switchToCarLeasingCalcIframe(){
        switchTo().frame("calculator-frame-08a");
    }

    //enter price for vehicle
    public void enterVehicleSum(String vehicleSum) {
        $("#calc08-sum").setValue(vehicleSum);
    }

    //enter downpayment for vehicle
    public void enterDownpaymentSum(String downpaymentSum) {
        $("#calc08-deposit").setValue(downpaymentSum);
    }

    //click on Add to comparations button
    public void clickOnAddToCompBtn() {
        $("#calc08 input.calc08-action-compare", 0).click();
    }

    // get vehicle price from Comparisons table - text
    public String getVehiclePriceFromCompTableTxt() {
        return $("#calc08 table td",2).getText();
    }

}


