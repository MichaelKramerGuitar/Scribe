package edu.bu.met.cs665.utilities;

import edu.bu.met.cs665.email.Email;
import edu.bu.met.cs665.email.EmailGenerationSystem;
import edu.bu.met.cs665.email.FrequentCustomerEmail;
import edu.bu.met.cs665.email.InvalidEmailAddress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the Decorator pattern with ad hoc
 * functionalities added to Email objects at run time.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class AsymmetricEncryptorTest {
  // Singleton
  private EmailGenerationSystem generator;

  private Email frequentEmail;

  // Constructor
  public AsymmetricEncryptorTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.frequentEmail = generator.generateEmail("frequent");
  }

  /**
   * Test ad hoc functionality added to Email.
   */
  @Test
  public void testAsymmetricEncryptorAddedToEmail() {
    Assert.assertTrue(frequentEmail instanceof FrequentCustomerEmail);
    frequentEmail = new AsymmetricEncryptor(frequentEmail);
    frequentEmail.assembleEmail();
    try {
      frequentEmail.setSender("info@otherbusiness.com");
      frequentEmail.setReceiver("frequentcustomer@gmail.com");
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    generator.send(frequentEmail);
    Assert.assertTrue(frequentEmail instanceof AsymmetricEncryptor);
    Assert.assertFalse(frequentEmail instanceof FrequentCustomerEmail);
  }
}