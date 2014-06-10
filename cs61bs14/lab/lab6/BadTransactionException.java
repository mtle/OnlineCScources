/* BadTransactionException.java */

/**
 *  Implements an exception that should be thrown for nonexistent accounts.
 **/
public class BadTransactionException extends Exception {

  public int accountNumber;  // The invalid account number.

  /**
   *  Creates an exception object for nonexistent account "badAcctNumber".
   **/
  public BadTransactionException(int badAcctNumber) {
    super("Transaction refused: Invalid account number: " + badAcctNumber);

    accountNumber = badAcctNumber;
  }
}
