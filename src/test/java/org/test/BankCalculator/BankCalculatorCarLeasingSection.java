package org.test.BankCalculator;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BankCalculatorCarLeasingSection {

    //click on arrow icon expand Car leasing calculator tab
    public void clickOnCarLeasingSectToExpand() {
        final String carLeasingSectExpand = ".groups01.clear div .heading";
        $(carLeasingSectExpand).click();
    }

    //enter price for vehicle
    public void enter9000VehicleSum() {
        final String vehicleSumTxtboxId = "#calc08-sum";
        $(vehicleSumTxtboxId).setValue("9000");
    }

    //enter downpayment for vehicle
    public void enterDownpaymentSum() {
        final String downpaymentSumTxtboxId = "#calc08-deposit";
        $(downpaymentSumTxtboxId).setValue("50");
    }

    //click on arrow icon expand Car leasing calculator tab
    public void clickOnAddToComparatBtn() {
        final String addToComparBtn = "#calc08 div.calc-form div div div.col2 ul li.link span span";
        $(addToComparBtn).click();
    }

    // get vehicle price from Comparisons table - text
    public String getVehiclePriceFromCompTableTxt() {
        final String vehiclePriceFromCompTablElement = "#calc08 table td";
        return $(vehiclePriceFromCompTablElement,2).getText();
    }

}


