package edu.bu.met.cs665.email;

import edu.bu.met.cs665.elements.NewCustomerBodyText;
import edu.bu.met.cs665.elements.NewCustomerHeader;
import edu.bu.met.cs665.elements.NewCustomerFooter;
import edu.bu.met.cs665.elements.BodyText;
import edu.bu.met.cs665.elements.Footer;
import edu.bu.met.cs665.elements.Header;


public class NewCustomerFactory implements SemanticElementsFactory {

  @Override
  public Header createHeader() {
    return new NewCustomerHeader();
  }

  @Override
  public BodyText createBodyText() {
    return new NewCustomerBodyText();
  }

  @Override
  public Footer createFooter() {
    return new NewCustomerFooter();
  }
}
