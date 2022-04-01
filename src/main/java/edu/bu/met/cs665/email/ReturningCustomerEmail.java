package edu.bu.met.cs665.email;

/**
 * The purpose of this class is the purpose of this class is to extend the
 * abstract email class and inherit its methods as an implementation of the
 * abstract factory pattern. It IS-A Email and HAS-A SemanticElements Factory.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class ReturningCustomerEmail extends Email { // IS-A

  private SemanticElementsFactory elementsFactory; // HAS-A

  // Constructor
  public ReturningCustomerEmail(SemanticElementsFactory elementsFactory) {
    this.elementsFactory = elementsFactory;
  }

  /**
   * The purpose of this method is to implement the inherited method with the
   * appropriate semantic elements to this type of email.
   */
  @Override
  public void assembleEmail() {
    System.out.println("\n...assembling Returning Customer Email...\n");
    setHeader(elementsFactory.createHeader());
    setBodyText(elementsFactory.createBodyText());
    setFooter(elementsFactory.createFooter());
  }

  // Getters
  public SemanticElementsFactory getElementsFactory() {
    return elementsFactory;
  }
}

