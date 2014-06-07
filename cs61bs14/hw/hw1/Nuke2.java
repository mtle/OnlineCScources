/* Nuke2.java */

import java.io.*;

/**  A class that provides a main function to read in a string
 *   from the keyboard, remove the second character and print
 *   the resulting string on the screen
 */

class Nuke2 {

  /** Prompts the user for a single string, nukes the 2nd character
   *  and output the modified string to stdout.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the
   *             user's input.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputString;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter a: ");
    /* Make sure the line is printed immediately. */
    System.out.flush();
    inputString = keyboard.readLine();
    char ch2 = inputString.charAt(0);
    inputString = ch2 + inputString.substring(2);

    System.out.println (inputString);
    System.out.flush();
  }
}
