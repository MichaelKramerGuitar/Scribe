package edu.bu.met.cs665.email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the functionality of concrete email
 * class FrequentCustomerEmail. ***NOTE*** This is testing all concrete
 * corresponding semantic elements additionally.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class FrequentCustomerEmailTest {

  // Singleton
  private EmailGenerationSystem generator;

  private Email frequentEmail;

  // Constructor
  public FrequentCustomerEmailTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.frequentEmail = generator.generateEmail("frequent");
  }

  /**
   * Test sender and receiver set.
   */
  @Test
  public void testFrequentCustomerEmailSenderReceiver() {
    String sender = "info@scribe.com";
    String receiver = "frequentcustomer@gmail.com";

    try {
      frequentEmail.setSender(sender);
      frequentEmail.setReceiver(receiver);
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    Assert.assertEquals(frequentEmail.getSender(), sender);
    Assert.assertEquals(frequentEmail.getReceiver(), receiver);
  }

  /**
   * Test header.
   */
  @Test
  public void testFrequentCustomerEmailHeader() {
    String header = "[FREQUENT CUSTOMER HEADER]\n";
    Assert.assertEquals(
      frequentEmail.getHeader().header().replaceAll("\n", ""),
      header.replaceAll("\n", ""));
  }


  /**
   * Test BodyText.
   */
  @Test
  public void testFrequentCustomerEmailBodyText() {
    String text = "\n[FREQUENT CUSTOMER BODY-TEXT]\nDear Frequent Customer,"
      + "\n\tour company values your continued...\n";
    Assert.assertEquals(
      frequentEmail.getBodyText().bodyText().replaceAll("\n", "").replaceAll("\t", ""),
      text.replaceAll("\n", "").replaceAll("\t", ""));
  }

  /**
   * Test Footer.
   */
  @Test
  public void testFrequentCustomerEmailFooter() {
    String footer = "\n[FREQUENT CUSTOMER FOOTER]\n";
    Assert.assertEquals(
      frequentEmail.getFooter().footer().replaceAll("\n", ""),
      footer.replaceAll("\n", ""));
  }
}