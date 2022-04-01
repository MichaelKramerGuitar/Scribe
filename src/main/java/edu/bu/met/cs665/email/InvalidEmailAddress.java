package edu.bu.met.cs665.email;

/**
 * The purpose of this class is to customize an exception when an email address
 * format is invalid.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class InvalidEmailAddress extends Exception {

  // Constructor
  public InvalidEmailAddress(String message) {
    super(message);
  }
}
