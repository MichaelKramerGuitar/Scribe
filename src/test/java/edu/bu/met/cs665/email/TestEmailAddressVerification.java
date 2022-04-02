package edu.bu.met.cs665.email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the email address verification method
 * of the email class.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class TestEmailAddressVerification {

  // Singleton
  private EmailGenerationSystem generator;

  private Email vipCustomerEmail;

  // Constructor
  public TestEmailAddressVerification() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.vipCustomerEmail = generator.generateEmail("vip");
  }

  /**
   * Test exception thrown.
   */
  @Test
  public void TestInvalidEmailExceptionThrown() {
    String sender = "info.scribe.com";
    try {
      vipCustomerEmail.setSender(sender);
    } catch (InvalidEmailAddress e) {
      Assert.assertEquals(
        "Sender Email Address is invalid.",
        e.getMessage());
    }
  }

}
