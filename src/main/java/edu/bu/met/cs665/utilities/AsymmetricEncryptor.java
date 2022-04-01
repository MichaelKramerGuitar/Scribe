package edu.bu.met.cs665.utilities;

import edu.bu.met.cs665.email.Email;

/**
 * The purpose of this class is to implement decorator pattern to add hoc
 * encryption functionality for an Email.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class AsymmetricEncryptor extends Encryptor {

  // Constructor
  public AsymmetricEncryptor(Email email) {
    this.setEmail(email);
  }

  /**
   * The purpose of this method is to get the contents of each semantic element
   * of the extended Email superclass and perform the add hoc functionality
   * indicated in this class' name.
   */
  @Override
  public void assembleEmail() {
    System.out.println("\n...ASYMMETRICALLY ENCRYPTING Email...\n");
    Email email = getEmail();
    String encryptedHeader = encrypt(email.getHeader().header());
    email.getHeader().setHeader(encryptedHeader); // apply encryption
    setHeader(email.getHeader()); // set applied encryption
    String encryptedBody = encrypt(email.getBodyText().bodyText());
    email.getBodyText().setText(encryptedBody);
    setBodyText(email.getBodyText());
    String encryptedFooter = encrypt(email.getFooter().footer());
    email.getFooter().setFooter(encryptedFooter);
    setFooter(email.getFooter());
  }

  /**
   * The purpose of this method is a place-holder to show where in the design
   * a symmetric encryption algorithm could be implemented.
   * @param element String
   * @return grammar checked String
   */
  @Override
  public String encrypt(String element) {
    // return element + " {\u2713ASYMMETRIC ENCRYPTION} ";
    return element + " {ASYMMETRIC ENCRYPTION} ";
  }
}
