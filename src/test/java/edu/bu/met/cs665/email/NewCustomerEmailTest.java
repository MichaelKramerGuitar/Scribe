package edu.bu.met.cs665.email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the functionality of concrete email
 * class NewCustomerEmail.***NOTE*** This is additionally testing all concrete
 * corresponding semantic elements.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class NewCustomerEmailTest {

  // Singleton
  private EmailGenerationSystem generator;

  private Email newCustomerEmail;

  // Constructor
  public NewCustomerEmailTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.newCustomerEmail = generator.generateEmail("new");
  }

  /**
   * Test sender and receiver set.
   */
  @Test
  public void testNewCustomerEmailSenderReceiver() {
    String sender = "info@scribe.com";
    String receiver = "newcustomer@gmail.com";

    try {
      newCustomerEmail.setSender(sender);
      newCustomerEmail.setReceiver(receiver);
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    Assert.assertEquals(newCustomerEmail.getSender(), sender);
    Assert.assertEquals(newCustomerEmail.getReceiver(), receiver);
  }

  /**
   * Test header.
   */
  @Test
  public void testNewCustomerEmailHeader() {
    String header = "[NEW CUSTOMER HEADER]\n";
    Assert.assertEquals(
      newCustomerEmail.getHeader().header().replaceAll("\n", ""),
      header.replaceAll("\n", ""));
  }


  /**
   * Test BodyText.
   */
  @Test
  public void testNewCustomerEmailBodyText() {
    String text = "\n[NEW CUSTOMER BODY-TEXT]\nDear New Customer,"
      + "\n\tour company...\n";
    Assert.assertEquals(
      newCustomerEmail.getBodyText().bodyText().replaceAll("\n", "").replaceAll("\t", ""),
      text.replaceAll("\n", "").replaceAll("\t", ""));
  }

  /**
   * Test Footer.
   */
  @Test
  public void testNewCustomerEmailFooter() {
    String footer = "\n[NEW CUSTOMER FOOTER]\n";
    Assert.assertEquals(
      newCustomerEmail.getFooter().footer().replaceAll("\n", ""),
      footer.replaceAll("\n", ""));
  }
}