package edu.bu.met.cs665.utilities;

import edu.bu.met.cs665.email.Email;

/**
 * The purpose of this class is to implement observer pattern to add hoc
 * encryption functionality for Email subclasses.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public abstract class Encryptor extends Email { // IS-A

  private Email email; // HAS-A relationship

  /**
   * The purpose of this method is to inherit from Email and pass down to
   * subclasses to "make the magic happen" for the decorator pattern.
   */
  public abstract void assembleEmail();

  /**
   * The purpose of this method to be inherited is to create the space for
   * concrete encryption algorithms to be implemented adhering to the
   * decorator pattern.
   * @param element A semantic element as a string.
   * @return an ecrypted String of the semantic element.
   */
  public abstract String encrypt(String element);

  // Getters
  public Email getEmail() {
    return this.email;
  }

  // Setters
  public void setEmail(Email email) {
    this.email = email;
  }

}
