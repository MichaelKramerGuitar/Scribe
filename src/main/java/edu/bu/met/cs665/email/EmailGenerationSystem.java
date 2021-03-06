package edu.bu.met.cs665.email;

import edu.bu.met.cs665.elements.BodyText;
import edu.bu.met.cs665.elements.Footer;
import edu.bu.met.cs665.elements.Header;
import java.sql.Timestamp;

/**
 * The purpose of this class is to implement the Singleton pattern for an
 * email generation system as per the assigned requirements.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class EmailGenerationSystem {

  private static EmailGenerationSystem generator; // access modifiers are key to pattern

  private static Timestamp connectionId; // for testing

  /**
   * The purpose of this method is to enforce the Singleton pattern
   * by ensuring that no other class can instantiate
   * a new constructor.
   */
  private EmailGenerationSystem() {

  }

  /**
   * The purpose of this method is to create an instance of this object if
   * one doesn't yet exists. If one exists this method returns that instance.
   * @return EmailSystemGenerator generator
   */
  public static EmailGenerationSystem getInstance() {
    if (generator == null) {
      generator = new EmailGenerationSystem(); // only place where object is created
      Timestamp timestamp = new Timestamp(System.currentTimeMillis()); // for testing
      connectionId = timestamp;
    }
    return generator; // if generator !null then we're just returning the instance
  }

  /**
   * determine type of email and assemble the email.
   * @param customerType a valid string
   * @return email
   */
  public Email generateEmail(String customerType) {
    SemanticElementsFactory elementsFactory = null;
    Email email = null;
    if (customerType.toLowerCase().equals("business")) {
      elementsFactory = new BusinessCustomerFactory();
      email = new BusinessCustomerEmail(elementsFactory);
      email.assembleEmail();
      return email;
    } else if (customerType.toLowerCase().equals("frequent")) {
      elementsFactory = new FrequentCustomerFactory();
      email = new FrequentCustomerEmail(elementsFactory);
      email.assembleEmail();
      return email;
    } else if (customerType.toLowerCase().equals("new")) {
      elementsFactory = new NewCustomerFactory();
      email = new NewCustomerEmail(elementsFactory);
      email.assembleEmail();
      return email;
    } else if (customerType.toLowerCase().equals("returning")) {
      elementsFactory = new ReturningCustomerFactory();
      email = new ReturningCustomerEmail(elementsFactory);
      email.assembleEmail();
      return email;
    } else if (customerType.toLowerCase().equals("vip")) {
      elementsFactory = new VipCustomerFactory();
      email = new VipCustomerEmail(elementsFactory);
      email.assembleEmail();
      return email;
    }
    return email;
  }

  /**
   * The purpose of this method is to send and email.
   * <p>Precondition: The email has been checked and encrypted if needed</p>
   * <p>Postcondition: the email is sent</p>
   *
   * @param email the email object to be sent
   */
  public void send(Email email) {
    Header header = email.getHeader();
    BodyText bodyText = email.getBodyText();
    Footer footer = email.getFooter();
    System.out.println("\n\n\t\t\tSending email...\n");
    System.out.println("Sender: " + email.getSender()
        + "\nReceiver: " + email.getReceiver() + "\n");
    System.out.println(header.header());
    System.out.println(bodyText.bodyText());
    System.out.println(footer.footer());
  }

  /**
   * The purpose of this method is to show the Singleton instance for testing.
   */
  public Timestamp getConnectionId() {
    return (Timestamp) connectionId.clone();
  }
}
