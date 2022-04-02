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
public class GrammarCheckerTest {
  // Singleton
  private EmailGenerationSystem generator;

  private Email newCustomerEmail;

  // Constructor
  public GrammarCheckerTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.newCustomerEmail = generator.generateEmail("new");
  }

  /**
   * Test ad hoc functionality added to Email.
   */
  @Test
  public void testGrammarCheckerAddedToEmail() {
    Assert.assertTrue(newCustomerEmail instanceof NewCustomerEmail);
    newCustomerEmail = new GrammarChecker(newCustomerEmail);
    newCustomerEmail.assembleEmail();
    try {
      newCustomerEmail.setSender("info@otherbusiness.com");
      newCustomerEmail.setReceiver("newcustomer@gmail.com");
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    generator.send(newCustomerEmail);
    Assert.assertTrue(newCustomerEmail instanceof GrammarChecker);
    Assert.assertFalse(newCustomerEmail instanceof NewCustomerEmail);
  }
}