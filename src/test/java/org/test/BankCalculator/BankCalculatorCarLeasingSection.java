package org.test.BankCalculator;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BankCalculatorCarLeasingSection {

    //click on arrow icon expand Car leasing calculator tab
    public void clickOnCarLeasingSectToExpand() {
        $(".groups01.clear div .heading").click();
    }

    //enter price for vehicle
    public void enterVehicleSum(String vehicleSum) {
        $("#calc08-sum").setValue(vehicleSum);
    }

    //enter downpayment for vehicle
    public void enterDownpaymentSum(String downpaymentSum) {
        $("#calc08-deposit").setValue(downpaymentSum);
    }

    //click on arrow icon expand Car leasing calculator tab
    public void clickOnAddToComparatBtn() {
        $("#calc08 div.calc-form div div div.col2 ul li.link span span").click();
    }

    // get vehicle price from Comparisons table - text
    public String getVehiclePriceFromCompTableTxt() {
        return $("#calc08 table td",2).getText();
    }

}


