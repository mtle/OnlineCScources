/* BankApp.java */

import java.io.*;
import sortedlist.*;

/**
 *  A bank application.  Allows a user to create and manipulate
 *  banking accounts, using an ATM that is shared by all banking applications.
 */
public class BankApp {
  private BufferedReader bReader =
          new BufferedReader(new InputStreamReader(System.in));
  private VirtualTeller ATM = new VirtualTeller();

  public static void main(String[] args) throws BadAccountException{
      greeting();
      usage();
      BankApp bankApp = new BankApp();

      String command = "";
      try {
          command = bankApp.readLine("--> ");
      } catch (IOException e) {
          System.err.println("Caught IOException: " + e.getMessage());
      }
      while (!command.equals("quit")) {
          try {
              if (command.equals("open")) {
                  bankApp.open();
              } else if (command.equals("deposit")) {
                  bankApp.doDeposit();
              } else if (command.equals("withdraw")) {
                  bankApp.doWithdraw();
              } else if (command.equals("inquire")) {
                  bankApp.doInquire();
              } else {
                  System.err.println("Invalid command: " + command);
                  usage();
              }
          } catch(IOException e) {
              System.err.println(e);
          } catch (BadAccountException e) {
              System.err.println(e);
          } catch (BadTransactionException e) {
              System.err.println(e);
          }
          try {
              command = bankApp.readLine("--> ");
          } catch (IOException e) {
              System.err.println("Caught IOException: " + e.getMessage());
          }
      };
      }

      public BankApp() {
          // The field declarations have initializers;
          //   no initialization is needed here.
      }

      /**
       *  open() prompts the user to create an account and creates one in the ATM.
       *  @exception IOException if there are problems reading user input.
       */
      private void open() throws IOException {
          String name = readLine("Enter name: ");
          int newNum = ATM.openAccount(name);

          System.out.println(name + ", your new account number is: " + newNum);
          System.out.println("Thanks for opening an account with us!");
      }

      /**
       *  doDeposit() prompts the user for an account number and tries to perform a
       *  deposit transaction on that account.
       *  @exception IOException if there are problems reading user input.
       */
      private void doDeposit() throws IOException, BadAccountException {
          // Get account number.
          int acctNumber = readInt("Enter account number: ");
          int amount = readInt("Enter amount to deposit: ");

          try {
          ATM.deposit(acctNumber, amount);
          } catch (BadAccountException e) {
              throw e;
          }
      }

      /**
       *  doWithdraw() prompts the user for an account number and tries
       *  to perform a withdrawal transaction from that account.
       *  @exception IOException if there are problems reading user input.
       */
      private void doWithdraw() throws IOException, BadTransactionException {
          // Get account number.
          int acctNumber = readInt("Enter account number: ");
          int amount = readInt("Enter amount to withdraw: ");

          try {
              ATM.withdraw(acctNumber, amount);
          } catch (BadTransactionException e) {
              throw e;
          }
      }

      /**
       *  doInquire() prompts the user for an account number, then attempts to
       *  discover and print that account's balance.
       *  @exception IOException if there are problems reading user input.
       */
      private void doInquire() throws IOException {
          int acctNumber = readInt("Enter account number: ");

          System.out.println("Balance for #" + acctNumber + " is " +
                  ATM.balanceInquiry(acctNumber));
      }

      /**
       *  greeting() displays a greeting message on the screen.
       */
      private static void greeting() {
          System.out.println("-------------------");
          System.out.println("Welcome to the bank");
          System.out.println("-------------------");
          System.out.println();
      }

      /**
       *  usage() displays instructions on using the command line arguments.
       */
      private static void usage() {
          System.out.println("Valid commands are: " +
                  "open, deposit, withdraw, inquire, quit");
      }

      /**
       *  readLine() prints the given prompt and returns a string from the
       *  input stream.
       *  @param prompt is the string printed to prompt the user.
       */
      private String readLine(String prompt) throws IOException {
          System.out.print(prompt);
          System.out.flush();
          return bReader.readLine();
      }

      /**
       *  readInt() returns an integer from the input stream after prompting
       *  the user.
       *  @param prompt is the string printed to prompt the user.
       *  @return an int read from the user.
       */
      private int readInt(String prompt) throws IOException {
          String text = readLine(prompt);
          return Integer.valueOf(text).intValue();
      }
  }
