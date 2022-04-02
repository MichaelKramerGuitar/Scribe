package edu.bu.met.cs665.utilities;

import edu.bu.met.cs665.email.Email;
import edu.bu.met.cs665.email.EmailGenerationSystem;
import edu.bu.met.cs665.email.VipCustomerEmail;
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
public class SymmetricEncryptorTest {
  // Singleton
  private EmailGenerationSystem generator;

  private Email vipEmail;

  // Constructor
  public SymmetricEncryptorTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.vipEmail = generator.generateEmail("vip");
  }

  /**
   * Test ad hoc functionality added to Email.
   */
  @Test
  public void testSymmetricEncryptorAddedToEmail() {
    Assert.assertTrue(vipEmail instanceof VipCustomerEmail);
    vipEmail = new SymmetricEncryptor(vipEmail);
    vipEmail.assembleEmail();
    try {
      vipEmail.setSender("info@otherbusiness.com");
      vipEmail.setReceiver("vipcustomer@gmail.com");
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    generator.send(vipEmail);
    Assert.assertTrue(vipEmail instanceof SymmetricEncryptor);
    Assert.assertFalse(vipEmail instanceof VipCustomerEmail);
  }
}