package ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

//User class responsible for user authentication and interaction
class User extends ATM {
 Scanner sc = new Scanner(System.in);
 DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

 // HashMap to store valid customer numbers and PINs
 HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

 // Method to authenticate users based on customer numbers and PINs
 public void getLogin() throws IOException {
     int x = 1;
     do {
         try {
             // Hardcoded customer numbers and PINs for demonstration
             data.put(123, 123);
             data.put(456, 456);
             System.out.println(" Welcome to the ATM ! ");

             System.out.println(" Enter your customer Number ");
             setCustomerNumber(sc.nextInt());

             System.out.println("Enter your PIN Number ");
             setPinNumber(sc.nextInt());
         } catch (Exception e) {
             System.out.println("\n" + "Invalid Characters(s)." + "\n" + "Enter Numbers Only " + "\n");
             x = 2;
         }
         int cn = getCustomerNumber();
         int pn = getPinNumber();
         if (data.containsKey(cn) && data.get(cn) == pn) {
             getAccountType();
         } else
             System.out.println("\n" + "Wrong Customer Number or Pin Number " + "\n");
     }
     while (x == 1);
 }

 // Method to prompt user to select account type
 public void getAccountType() {
     System.out.println("Select Your Account Type : ");
     System.out.println("Type 1 - Current Account");
     System.out.println("Type 2 - Savings Account");
     System.out.println("Press 3 to Exit! ");

     int selection = sc.nextInt();

     switch (selection) {
         case 1:
             getCurrent();
             break;
         case 2:
             getSaving();
             break;
         case 3:
             System.out.println("Thank You For Using This ATM !" + "\n");
             System.out.println("          Visit Again ");
             System.out.println("         Have a Nice Day  ");
             break;
         default:
             System.out.println("Invalid choice !");
             System.out.println("Enter a valid number ");
             getAccountType();
     }
 }

 // Method to handle current account operations
 public void getCurrent() {
     // Implementation details for current account operations...
 }

 // Method to handle saving account operations
 public void getSaving() {
     // Implementation details for saving account operations...
 }
}

//Main class to run the ATM interface
class Main {
 public static void main(String[] args) throws IOException {
     User user = new User();
     user.getLogin();
 }
}