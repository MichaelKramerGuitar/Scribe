package edu.bu.met.cs665;

import edu.bu.met.cs665.email.Email;
import edu.bu.met.cs665.email.EmailGenerationSystem;
import edu.bu.met.cs665.email.InvalidEmailAddress;
import edu.bu.met.cs665.utilities.AsymmetricEncryptor;
import edu.bu.met.cs665.utilities.GrammarChecker;
import edu.bu.met.cs665.utilities.SpellChecker;
import edu.bu.met.cs665.utilities.SymmetricEncryptor;
import org.apache.log4j.Logger;
// import org.apache.log4j.PropertyConfigurator;

public class Main {

  private static Logger logger = Logger.getLogger(Main.class);

  /**
   * The purpose of this method is to log when emails are successfully sent.
   * @param email an Email object
   */
  public static void logSent(Email email) {
    logger.info("\n*Email Sent*\nSender: "
        + email.getSender() + "\nReceiver: "
        + email.getReceiver());
  }

  /**
   * A main method to run examples.
   *
   * @param args not used
   */
  public static void main(String[] args) throws InvalidEmailAddress {


    EmailGenerationSystem generator = EmailGenerationSystem.getInstance();
    //generator.getConnectionId(); // test single instance first print
    Email businessEmail = generator.generateEmail("business");
    businessEmail = new GrammarChecker(businessEmail);
    businessEmail.assembleEmail(); // re-assemble grammar checked email
    businessEmail = new SpellChecker(businessEmail);
    businessEmail.assembleEmail(); // re-assemble spell checked email
    businessEmail = new SymmetricEncryptor(businessEmail);
    businessEmail.assembleEmail(); // re-assemble encrypted email
    try {
      businessEmail.setSender("info@scribe.com");
      businessEmail.setReceiver("businesscustomer@gmail.com");
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    generator.send(businessEmail);
    logSent(businessEmail);

    for (int i = 0; i < 5; i++) {
      System.out.println();
    }

    generator = EmailGenerationSystem.getInstance();
    //generator.getConnectionId(); // test single instance
    Email frequentEmail = generator.generateEmail("frequent");
    frequentEmail = new AsymmetricEncryptor(frequentEmail);
    frequentEmail.assembleEmail();
    try {
      frequentEmail.setSender("info@otherbusiness.com");
      frequentEmail.setReceiver("frequentcustomer@gmail.com");
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    generator.send(frequentEmail);
    logSent(frequentEmail);

    for (int i = 0; i < 5; i++) {
      System.out.println();
    }

    Email newCustomer = generator.generateEmail("new");
    try {
      newCustomer.setSender("info@otherbusiness1.com");
      newCustomer.setReceiver("newcustomer@gmail.com");
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    generator.send(newCustomer);
    logSent(newCustomer);

    for (int i = 0; i < 5; i++) {
      System.out.println();
    }

    Email returningCustomer = generator.generateEmail("returning");
    try {
      returningCustomer.setSender("info@otherbusiness2.com");
      returningCustomer.setReceiver("returningcustomer@gmail.com");
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    generator.send(returningCustomer);
    logSent(returningCustomer);


    for (int i = 0; i < 5; i++) {
      System.out.println();
    }

    Email vipCustomer = generator.generateEmail("Vip");
    try {
      vipCustomer.setSender("info@otherbusiness3.com");
      vipCustomer.setReceiver("vipcustomer@gmail.com");
    } catch (InvalidEmailAddress e) {
      System.out.println(e);
    }
    generator.send(vipCustomer);
    logSent(vipCustomer);
  }

}
