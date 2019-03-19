package atm;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {
    int selection;
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();


    public void getLogin() {
        int x = 1;

        do{
            try{

                data.put(12345678, 9999);
                data.put(98765432, 1111);
                System.out.println("Welcome to the ATM machine!");

                System.out.print("Enter your customer number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e){
                System.out.println("\nInvalid character(s). Only numbers.\n");
                x = 2;
            }
            for(Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
            System.out.println("\nWrong customer number or PIN number.\n");
        }while(x == 1);
    }


    public void getAccountType(){
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 - Checking account");
        System.out.println("Type 2 - Saving account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection)
        {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for visiting this ATM. Have a good day.");
                System.exit(0);

            default:
                System.out.println("\nInvalidChoice\n");
                getAccountType();
        }
    }


    public void getChecking(){
        System.out.println("Checking account: ");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2 - Withdraw funds");
        System.out.println("Type 3 - Deposit funds");
        System.out.println("Type 4 - Back");
        System.out.println("Type 5 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection)
        {
            case 1:
                System.out.println("Checking account balance: " + moneyFormat.format(getCheckingBalance()) + "\n");
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                getAccountType();
                break;

            case 5:
                System.out.println("Thank you for visiting this ATM. Have a good day.");
                System.exit(0);

            default:
                System.out.println("\nInvalidChoice\n");
                getChecking();
        }
    }


    public void getSaving(){
        System.out.println("Saving account: ");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2 - Withdraw funds");
        System.out.println("Type 3 - Deposit funds");
        System.out.println("Type 4 - Back");
        System.out.println("Type 5 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection)
        {
            case 1:
                System.out.println("Saving account balance: " + moneyFormat.format(getSavingBalance()) + "\n");
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                getAccountType();
                break;

            case 5:
                System.out.println("Thank you for visiting this ATM. Have a good day.");
                System.exit(0);

            default:
                System.out.println("\nInvalidChoice\n");
                getSaving();
        }
    }
}