package edu.bu.met.cs665.email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the functionality of concrete email
 * class VipCustomerEmail.***NOTE*** This is additionally testing all concrete
 * corresponding semantic elements.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class VipCustomerEmailTest {

  // Singleton
  private EmailGenerationSystem generator;

  private Email vipCustomerEmail;

  // Constructor
  public VipCustomerEmailTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
    this.vipCustomerEmail = generator.generateEmail("vip");
  }

  /**
   * Test sender and receiver set.
   */
  @Test
  public void testVipCustomerEmailSenderReceiver() {
    String sender = "info@scribe.com";
    String receiver = "vipcustomer@gmail.com";

    try {
      vipCustomerEmail.setSender(sender);
      vipCustomerEmail.setReceiver(receiver);
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    Assert.assertEquals(vipCustomerEmail.getSender(), sender);
    Assert.assertEquals(vipCustomerEmail.getReceiver(), receiver);
  }

  /**
   * Test header.
   */
  @Test
  public void testVipCustomerEmailHeader() {
    String header = "[VIP CUSTOMER HEADER]\n";
    Assert.assertEquals(
      vipCustomerEmail.getHeader().header().replaceAll("\n", ""),
      header.replaceAll("\n", ""));
  }


  /**
   * Test BodyText.
   */
  @Test
  public void testVipCustomerEmailBodyText() {
    String text = "\n[VIP CUSTOMER BODY-TEXT]\nDear VIP Customer,"
      + "\n\tour company values your continued...\n";
    Assert.assertEquals(
      vipCustomerEmail.getBodyText().bodyText().replaceAll("\n", "").replaceAll("\t", ""),
      text.replaceAll("\n", "").replaceAll("\t", ""));
  }

  /**
   * Test Footer.
   */
  @Test
  public void testVipCustomerEmailFooter() {
    String footer = "\n[VIP CUSTOMER FOOTER]\n";
    Assert.assertEquals(
      vipCustomerEmail.getFooter().footer().replaceAll("\n", ""),
      footer.replaceAll("\n", ""));
  }
}