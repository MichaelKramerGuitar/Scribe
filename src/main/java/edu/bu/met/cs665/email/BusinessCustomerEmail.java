package edu.bu.met.cs665.email;

public class BusinessCustomerEmail extends Email {

  private SemanticElementsFactory elementsFactory;

  public BusinessCustomerEmail(SemanticElementsFactory elementsFactory) {
    this.elementsFactory = elementsFactory;
  }

  @Override
  public void assembleEmail() {
    System.out.println("\n...assembling Business Customer Email...\n");
    setHeader(elementsFactory.createHeader());
    setBodyText(elementsFactory.createBodyText());
    setFooter(elementsFactory.createFooter());
  }

  public SemanticElementsFactory getElementsFactory() {
    return elementsFactory;
  }
}
