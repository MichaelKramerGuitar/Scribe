package edu.bu.met.cs665.utilities;

import edu.bu.met.cs665.email.Email;

public class AsymmetricEncryptor extends Encryptor {

  public AsymmetricEncryptor(Email email) {
    this.setEmail(email);
  }

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
   * The purpose of this method is a place holder to show where in the design
   * a symmetric encryption algorithm could be implemented
   * @param element String
   * @return grammar checked String
   */
  @Override
  public String encrypt(String element) {
    // return element + " {\u2713ASYMMETRIC ENCRYPTION} ";
    return element + " {ASYMMETRIC ENCRYPTION} ";
  }
}
