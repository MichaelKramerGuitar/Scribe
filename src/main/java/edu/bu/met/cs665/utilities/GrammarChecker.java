package edu.bu.met.cs665.utilities;

import edu.bu.met.cs665.email.Email;

/**
 * The purpose of this class is to implement decorator pattern to add hoc
 * checking functionality for an Email.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class GrammarChecker extends Checker {

  // Constructor
  public GrammarChecker(Email email) {
    this.setEmail(email);
  }

  /**
   * The purpose of this method is to get the contents of each semantic element
   * of the extended Email superclass and perform the add hoc functionality
   * indicated in this class' name.
   */
  @Override
  public void assembleEmail() {
    System.out.println("\n...GRAMMAR CHECKING Email...\n");
    Email email = getEmail();
    String checkedHeader = check(email.getHeader().header());
    email.getHeader().setHeader(checkedHeader); // apply corrected grammar
    setHeader(email.getHeader()); // set applied corrections
    String checkedBody = check(email.getBodyText().bodyText());
    email.getBodyText().setText(checkedBody);
    setBodyText(email.getBodyText());
    String checkedFooter = check(email.getFooter().footer());
    email.getFooter().setFooter(checkedFooter);
    setFooter(email.getFooter());
  }

  /**
   * The purpose of this method is a place-holder to show where in the design
   * a grammar checking algorithm could be implemented.
   * @param element String
   * @return grammar checked String
   */
  @Override
  public String check(String element) {
    // return element + " {\u2713GRAMMAR} "; // unicode checkmark doesn't compile with maven
    return element + " {CHECKED GRAMMAR} ";
  }
}
