package edu.bu.met.cs665.email;

import edu.bu.met.cs665.elements.FrequentBodyText;
import edu.bu.met.cs665.elements.FrequentHeader;
import edu.bu.met.cs665.elements.FrequentFooter;
import edu.bu.met.cs665.elements.Header;
import edu.bu.met.cs665.elements.BodyText;
import edu.bu.met.cs665.elements.Footer;

public class FrequentCustomerFactory implements SemanticElementsFactory {

  @Override
  public Header createHeader() {
    return new FrequentHeader();
  }

  @Override
  public BodyText createBodyText() {
    return new FrequentBodyText();
  }

  @Override
  public Footer createFooter() {
    return new FrequentFooter();
  }
}