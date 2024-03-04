package ATM;

import java.text.DecimalFormat;
import java.util.Scanner;

// ATM class responsible for managing account balances and operations
class ATM {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###, ##0.00");

    // Method to set customer number
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    // Method to get customer number
    public int getCustomerNumber() {
        return customerNumber;
    }

    // Method to set PIN number
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    // Method to get PIN number
    public int getPinNumber() {
        return pinNumber;
    }

    // Method to get current balance for checking account
    public double getCurrentBalance() {
        return checkingBalance;
    }

    // Method to get current balance for savings account
    public double getSavingBalance() {
        return savingBalance;
    }

    // Method to calculate withdrawal from checking account
    public double calcCurrentWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    // Method to calculate withdrawal from savings account
    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return checkingBalance;
    }

    // Method to calculate deposit to checking account
    public double calcCurrentDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    // Method to calculate deposit to savings account
    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    // Method to handle current account withdrawal
    public void getCurrentWithdrawInput() {
        System.out.println("Checking Account Balance : " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount to withdraw from your Current Account :");
        double amount = sc.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCurrentWithdraw(amount);
            System.out.println("Current account Balance :" + moneyFormat.format(checkingBalance));
        } else {
            System.err.println("Balance Cannot be Negative!.. ");
        }
    }

    // Method to handle saving account withdrawal
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance : " + moneyFormat.format(savingBalance));
        System.out.println("Enter the Amount you want to Withdraw from Savings Account :");
        double amount = sc.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New savings account Balance : " + moneyFormat.format(savingBalance));
        } else {
            System.err.println("Balance cannot be Negative!....");
        }
    }

    // Method to handle current account deposit
    public void getCurrentDepositInput() {
        System.out.println("Checking Account Balance : " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the Amount you want to Deposit to your Current Account :");
        double amount = sc.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCurrentDeposit(amount);
            System.out.println("New current account Balance : " + moneyFormat.format(checkingBalance));
        } else {
            System.err.println("Balance cannot be Negative!....");
        }
    }

    // Method to handle saving account deposit
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance :" + moneyFormat.format(savingBalance));
        System.out.println("Enter the Amount you want to Deposit to your saving Account : ");
        double amount = sc.nextDouble();

        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving account Balance :" + moneyFormat.format(savingBalance));
        } else {
            System.err.println("Balance cannot be negative !..");
        }
    }
}