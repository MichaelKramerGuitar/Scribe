package edu.bu.met.cs665.utilities;

import edu.bu.met.cs665.email.Email;


public class SpellChecker extends Checker {


  public SpellChecker(Email email) {
    this.setEmail(email);
  }

  @Override
  public void assembleEmail() {
    System.out.println("\n...SPELL CHECKING Email...\n");
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
   * a grammar checking algorithm could be implemented
   * @param element String
   * @return grammar checked String
   */
  @Override
  public String check(String element) {
    //return element + " {\u2713SPELLING} ";
    return element + " {CHECKED SPELLING} ";
  }
}
