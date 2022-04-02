package edu.bu.met.cs665.utilities;

import edu.bu.met.cs665.email.*;
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
public class MultipleDecoratorsTest {
  // Singleton
  private EmailGenerationSystem generator;

  private Email returningCustomerEmail;

  // Constructor
  public MultipleDecoratorsTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.returningCustomerEmail = generator.generateEmail("returning");
  }

  /**
   * Test multiple decorators.
   */
  @Test
  public void testMultipleDecoratorsAddedToEmail() {

    Assert.assertTrue(returningCustomerEmail instanceof ReturningCustomerEmail);
    returningCustomerEmail = new GrammarChecker(returningCustomerEmail);
    returningCustomerEmail.assembleEmail();
    Assert.assertTrue(returningCustomerEmail instanceof GrammarChecker);
    Assert.assertFalse(returningCustomerEmail instanceof ReturningCustomerEmail);
    returningCustomerEmail = new SpellChecker(returningCustomerEmail);
    returningCustomerEmail.assembleEmail();
    Assert.assertTrue(returningCustomerEmail instanceof SpellChecker);
    Assert.assertFalse(returningCustomerEmail instanceof ReturningCustomerEmail);
    Assert.assertFalse(returningCustomerEmail instanceof GrammarChecker);
    returningCustomerEmail = new AsymmetricEncryptor(returningCustomerEmail);
    returningCustomerEmail.assembleEmail();
    Assert.assertTrue(returningCustomerEmail instanceof AsymmetricEncryptor);
    Assert.assertFalse(returningCustomerEmail instanceof ReturningCustomerEmail);
    Assert.assertFalse(returningCustomerEmail instanceof GrammarChecker);
    Assert.assertFalse(returningCustomerEmail instanceof SpellChecker);
    returningCustomerEmail = new SymmetricEncryptor(returningCustomerEmail);
    returningCustomerEmail.assembleEmail();
    Assert.assertTrue(returningCustomerEmail instanceof SymmetricEncryptor);
    Assert.assertFalse(returningCustomerEmail instanceof ReturningCustomerEmail);
    Assert.assertFalse(returningCustomerEmail instanceof GrammarChecker);
    Assert.assertFalse(returningCustomerEmail instanceof SpellChecker);
    Assert.assertFalse(returningCustomerEmail instanceof AsymmetricEncryptor);
    String sender = "info@scribe.com";
    String receiver = "returningcustomer@gmail.com";

    try {
      returningCustomerEmail.setSender(sender);
      returningCustomerEmail.setReceiver(receiver);
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    generator.send(returningCustomerEmail);
  }
}
