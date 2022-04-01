package edu.bu.met.cs665.email;

public class NewCustomerEmail extends Email {

  private SemanticElementsFactory elementsFactory;

  public NewCustomerEmail(SemanticElementsFactory elementsFactory) {
    this.elementsFactory = elementsFactory;
  }

  @Override
  public void assembleEmail() {
    System.out.println("\n...assembling New Customer Email...\n");
    setHeader(elementsFactory.createHeader());
    setBodyText(elementsFactory.createBodyText());
    setFooter(elementsFactory.createFooter());
  }

  public SemanticElementsFactory getElementsFactory() {
    return elementsFactory;
  }
}

