package edu.bu.met.cs665.email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the functionality of concrete email
 * class ReturningCustomerEmail.***NOTE*** This is additionally testing all concrete
 * corresponding semantic elements.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class ReturningCustomerEmailTest {

  // Singleton
  private EmailGenerationSystem generator;

  private Email returningCustomerEmail;

  // Constructor
  public ReturningCustomerEmailTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.returningCustomerEmail = generator.generateEmail("returning");
  }

  /**
   * Test sender and receiver set.
   */
  @Test
  public void testReturningCustomerEmailSenderReceiver() {
    String sender = "info@scribe.com";
    String receiver = "returningcustomer@gmail.com";

    try {
      returningCustomerEmail.setSender(sender);
      returningCustomerEmail.setReceiver(receiver);
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    Assert.assertEquals(returningCustomerEmail.getSender(), sender);
    Assert.assertEquals(returningCustomerEmail.getReceiver(), receiver);
  }

  /**
   * Test header.
   */
  @Test
  public void testReturningCustomerEmailHeader() {
    String header = "[RETURNING CUSTOMER HEADER]\n";
    Assert.assertEquals(
      returningCustomerEmail.getHeader().header().replaceAll("\n", ""),
      header.replaceAll("\n", ""));
  }


  /**
   * Test BodyText.
   */
  @Test
  public void testReturningCustomerEmailBodyText() {
    String text = "\n[RETURNING CUSTOMER BODY-TEXT]\nDear Returning Customer,"
      + "\n\tour company values your continued...\n";
    Assert.assertEquals(
      returningCustomerEmail.getBodyText().bodyText().replaceAll("\n", "").replaceAll("\t", ""),
      text.replaceAll("\n", "").replaceAll("\t", ""));
  }

  /**
   * Test Footer.
   */
  @Test
  public void testReturningCustomerEmailFooter() {
    String footer = "\n[RETURNING CUSTOMER FOOTER]\n";
    Assert.assertEquals(
      returningCustomerEmail.getFooter().footer().replaceAll("\n", ""),
      footer.replaceAll("\n", ""));
  }
}