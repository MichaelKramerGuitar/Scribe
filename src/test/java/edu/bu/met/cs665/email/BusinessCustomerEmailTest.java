package edu.bu.met.cs665.email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the functionality of concrete email
 * class BusinessCustomerEmail.***NOTE*** This is additionally testing all concrete
 * corresponding semantic elements.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class BusinessCustomerEmailTest {

  // Singleton
  private EmailGenerationSystem generator;

  private Email businessEmail;

  // Constructor
  public BusinessCustomerEmailTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.businessEmail = generator.generateEmail("business");
  }

  /**
   * Test sender and receiver set.
   */
  @Test
  public void testBusinessCustomerEmailSenderReceiver() {
    String sender = "info@scribe.com";
    String receiver = "businesscustomer@gmail.com";

    try {
      businessEmail.setSender(sender);
      businessEmail.setReceiver(receiver);
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    Assert.assertEquals(businessEmail.getSender(), sender);
    Assert.assertEquals(businessEmail.getReceiver(), receiver);
  }

  /**
   * Test header.
   */
  @Test
  public void testBusinessCustomerEmailHeader() {
    String header = "[BUSINESS HEADER]\n";
    Assert.assertEquals(
      businessEmail.getHeader().header().replaceAll("\n", ""),
      header.replaceAll("\n", ""));
  }


  /**
   * Test BodyText.
   */
  @Test
  public void testBusinessCustomerEmailBodyText() {
    String text = "\n[BUSINESS CUSTOMER BODY-TEXT]\nDear Business Customer,"
      + "\n\tour company values your continued...\n";
    Assert.assertEquals(
      businessEmail.getBodyText().bodyText().replaceAll("\n", "").replaceAll("\t", ""),
      text.replaceAll("\n", "").replaceAll("\t", ""));
  }

  /**
   * Test Footer.
   */
  @Test
  public void testBusinessCustomerEmailFooter() {
    String footer = "\n[BUSINESS CUSTOMER FOOTER]\n";
    Assert.assertEquals(
      businessEmail.getFooter().footer().replaceAll("\n", ""),
      footer.replaceAll("\n", ""));
  }
}