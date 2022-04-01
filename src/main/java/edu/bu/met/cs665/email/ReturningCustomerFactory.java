package edu.bu.met.cs665.email;

import edu.bu.met.cs665.elements.ReturningBodyText;
import edu.bu.met.cs665.elements.ReturningHeader;
import edu.bu.met.cs665.elements.ReturningFooter;
import edu.bu.met.cs665.elements.BodyText;
import edu.bu.met.cs665.elements.Footer;
import edu.bu.met.cs665.elements.Header;


public class ReturningCustomerFactory implements SemanticElementsFactory {
  @Override
  public Header createHeader() {
    return new ReturningHeader();
  }

  @Override
  public BodyText createBodyText() {
    return new ReturningBodyText();
  }

  @Override
  public Footer createFooter() {
    return new ReturningFooter();
  }
}