package edu.bu.met.cs665.email;

public class FrequentCustomerEmail extends Email {

  private SemanticElementsFactory elementsFactory;

  public FrequentCustomerEmail(SemanticElementsFactory elementsFactory) {
    this.elementsFactory = elementsFactory;
  }
  @Override
  public void assembleEmail() {
    System.out.println("\n...assembling Frequent Customer Email...\n");
    setHeader(elementsFactory.createHeader());
    setBodyText(elementsFactory.createBodyText());
    setFooter(elementsFactory.createFooter());
  }

  public SemanticElementsFactory getElementsFactory() {
    return elementsFactory;
  }
}