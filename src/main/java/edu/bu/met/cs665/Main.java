package edu.bu.met.cs665;

import edu.bu.met.cs665.email.Email;
import edu.bu.met.cs665.email.EmailGenerationSystem;
import edu.bu.met.cs665.email.InvalidEmailAddress;
import edu.bu.met.cs665.example1.Person;
import edu.bu.met.cs665.utilities.AsymmetricEncryptor;
import edu.bu.met.cs665.utilities.GrammarChecker;
import edu.bu.met.cs665.utilities.SpellChecker;
import edu.bu.met.cs665.utilities.SymmetricEncryptor;
import org.apache.log4j.Logger;
// import org.apache.log4j.PropertyConfigurator;

public class Main {

  private static Logger logger = Logger.getLogger(Main.class);


  /**
   * A main method to run examples.
   *
   * @param args not used
   */
  public static void main(String[] args) throws InvalidEmailAddress {

    // This configuration is for setting up the log4j properties file.
    // It is better to set this using java program arguments.
    // PropertyConfigurator.configure("log4j.properties");

    // Let us create an object of the Main class.
//    Main m = new Main();
//
//    logger.info(m.doIt());

//    logger.trace("Trace Message!");
//    logger.debug("Debug Message!");
//    logger.info("Info Message!");
//    logger.warn("Warn Message!");
//    logger.error("Error Message!");
//    logger.fatal("Fatal Message!");

    EmailGenerationSystem generator = EmailGenerationSystem.getInstance();
    generator.getConnectionId(); // test single instance first print
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

    for (int i = 0; i < 5; i++) {
      System.out.println();
    }

    generator = EmailGenerationSystem.getInstance();
    generator.getConnectionId(); // test single instance
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
  }

  private String doIt() {
    Person student = new Person("John", "Doe");
    return student.getLastName() + ',' + student.getLastName();
  }

}
