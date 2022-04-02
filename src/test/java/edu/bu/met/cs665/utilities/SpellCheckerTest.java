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
public class SpellCheckerTest {
  // Singleton
  private EmailGenerationSystem generator;

  private Email businessCustomerEmail;

  // Constructor
  public SpellCheckerTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.businessCustomerEmail = generator.generateEmail("business");
  }

  /**
   * Test ad hoc functionality added to Email.
   */
  @Test
  public void testGrammarCheckerAddedToEmail() {
    Assert.assertTrue(businessCustomerEmail instanceof BusinessCustomerEmail);
    businessCustomerEmail = new SpellChecker(businessCustomerEmail);
    businessCustomerEmail.assembleEmail();
    try {
      businessCustomerEmail.setSender("info@otherbusiness.com");
      businessCustomerEmail.setReceiver("businesscustomer@gmail.com");
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    generator.send(businessCustomerEmail);
    Assert.assertTrue(businessCustomerEmail instanceof SpellChecker);
    Assert.assertFalse(businessCustomerEmail instanceof BusinessCustomerEmail);
  }
}