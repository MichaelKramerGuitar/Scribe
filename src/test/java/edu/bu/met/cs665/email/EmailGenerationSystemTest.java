package edu.bu.met.cs665.email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this class is to test the functionality of the EmailGenerationSystem.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class EmailGenerationSystemTest {

  // Singleton
  private EmailGenerationSystem generator;

  // Constructor
  public EmailGenerationSystemTest() {}

  /**
   * The purpose of this method is to initialize the EmailGenerationSystem singleton
   */
  @Before
  public void init() {
    this.generator = EmailGenerationSystem.getInstance();
  }

  /**
   * Test EmailGenerationSystem is Singleton.
   */
  @Test
  public void testGeneratorIsSingleton() {
    EmailGenerationSystem sameGenerator = EmailGenerationSystem.getInstance();
    Assert.assertEquals(sameGenerator.getConnectionId(), generator.getConnectionId());
    // Test sameGenerator1 ID equals the sameGenerator ID
    EmailGenerationSystem sameGenerator1 = EmailGenerationSystem.getInstance();
    //Email vipEmail = sameGenerator1.generateEmail("vip");
    Assert.assertEquals(sameGenerator1.getConnectionId(), sameGenerator.getConnectionId());
  }

  /**
   * Test Returns instance of BusinessCustomerEmail.
   */
  @Test
  public void testGenerationSystemReturnsBusinessEmail() {
    Email businessEmail = generator.generateEmail("business");
    Assert.assertTrue(businessEmail instanceof BusinessCustomerEmail);
    Email businessEmail1 = generator.generateEmail("buSiness");
    Assert.assertTrue(businessEmail1 instanceof BusinessCustomerEmail);
    Email businessEmail2 = generator.generateEmail("busy person");
    Assert.assertFalse(businessEmail2 instanceof BusinessCustomerEmail);
  }

  /**
   * Test returns instance of FrequentCustomerEmail.
   */
  @Test
  public void testGenerationSystemReturnsFrequentEmail() {
    Email frequentEmail = generator.generateEmail("frequent");
    Assert.assertTrue(frequentEmail instanceof FrequentCustomerEmail);
    Email frequentEmail1 = generator.generateEmail("FReQuent");
    Assert.assertTrue(frequentEmail1 instanceof FrequentCustomerEmail);
    Email frequentEmail2 = generator.generateEmail("busy person");
    Assert.assertFalse(frequentEmail2 instanceof FrequentCustomerEmail);
  }

  /**
   * Test returns instance of NewCustomerEmail.
   */
  @Test
  public void testGenerationSystemReturnsNewCustomerEmail() {
    Email newCustomerEmail = generator.generateEmail("new");
    Assert.assertTrue(newCustomerEmail instanceof NewCustomerEmail);
    Email newCustomerEmail1 = generator.generateEmail("nEW");
    Assert.assertTrue(newCustomerEmail1 instanceof NewCustomerEmail);
    Email newCustomerEmail2 = generator.generateEmail("busy person");
    Assert.assertFalse(newCustomerEmail2 instanceof NewCustomerEmail);
  }

  /**
   * Test returns instance of ReturningCustomerEmail.
   */
  @Test
  public void testGenerationSystemReturnsReturningCustomerEmail() {
    Email returningCustomerEmail = generator.generateEmail("returning");
    Assert.assertTrue(returningCustomerEmail instanceof ReturningCustomerEmail);
    Email newCustomerEmail1 = generator.generateEmail("ReTuRNing");
    Assert.assertTrue(newCustomerEmail1 instanceof ReturningCustomerEmail);
    Email newCustomerEmail2 = generator.generateEmail("retuning");
    Assert.assertFalse(newCustomerEmail2 instanceof ReturningCustomerEmail);
  }

  /**
   * Test returns instance of VipCustomerEmail.
   */
  @Test
  public void testGenerationSystemReturnsVipCustomerEmail() {
    Email vipCustomerEmail = generator.generateEmail("vip");
    Assert.assertTrue(vipCustomerEmail instanceof VipCustomerEmail);
    Email vipCustomerEmail1 = generator.generateEmail("vIp");
    Assert.assertTrue(vipCustomerEmail1 instanceof VipCustomerEmail);
    Email vipCustomerEmail2 = generator.generateEmail("Vipe");
    Assert.assertFalse(vipCustomerEmail2 instanceof VipCustomerEmail);
  }

}