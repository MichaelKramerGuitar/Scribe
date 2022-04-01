package edu.bu.met.cs665.email;

import edu.bu.met.cs665.elements.BodyText;
import edu.bu.met.cs665.elements.Footer;
import edu.bu.met.cs665.elements.Header;
import java.util.regex.Pattern;

/**
 * The purpose of this class is to provide the abstraction from which concrete
 * emails can be generated in the abstract factory pattern.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public abstract class Email {

  private String sender; // ex: info@company.com
  private String receiver; // ex: receiver@gmail.com
  private Header header;
  private BodyText body;
  private Footer footer;

  /**
   * The purpose of this abstract method is such that subclasses can implement
   * and assemble the semantic elements of an email according to their respective
   * types.
   */
  public abstract void assembleEmail();

  // Getters
  public String getSender() {
    return sender;
  }

  public String getReceiver() {
    return receiver;
  }

  public Header getHeader() {
    return header;
  }

  public BodyText getBodyText() {
    return body;
  }

  public Footer getFooter() {
    return footer;
  }


  /**
   * The purpose of this method is to set the sender of this email.
   * @param sender String
   * @throws InvalidEmailAddress if email is invalid
   */
  public void setSender(String sender) throws InvalidEmailAddress {
    boolean validAddress = validEmailAddress(sender);
    if (validAddress) {
      this.sender = sender;
    }  else {
      throw new InvalidEmailAddress("Sender Email Address is invalid.");
    }
  }

  /**
   * The purpose of this method is to set the receiver of this email.
   * @param receiver String
   * @throws InvalidEmailAddress if email address is invalid.
   */
  public void setReceiver(String receiver) throws InvalidEmailAddress {
    boolean validAddress = validEmailAddress(receiver);
    if (validAddress) {
      this.receiver = receiver;
    } else {
      throw new InvalidEmailAddress("Receiver Email Address is invalid.");
    }
  }

  // Setters
  public void setHeader(Header header) {
    this.header = header;
  }

  public void setBodyText(BodyText bodyText) {
    this.body = bodyText;
  }

  public void setFooter(Footer footer) {
    this.footer = footer;
  }


  /**
   * The purpose of this method is to validate email addresses. Inspired by
   * https://www.geeksforgeeks.org/check-email-address-valid-not-java/
   *
   * @param emailAddress String email address
   * @return
   */
  public static boolean validEmailAddress(String emailAddress) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
        + "[a-zA-Z0-9_+&*-]+)*@"
        + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
        + "A-Z]{2,7}$";

    Pattern pat = Pattern.compile(emailRegex);
    if (emailAddress == null) {
      return false;
    }
    return pat.matcher(emailAddress).matches();
  }

}
