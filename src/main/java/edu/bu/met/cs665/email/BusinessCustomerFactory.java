package edu.bu.met.cs665.email;

import edu.bu.met.cs665.elements.BusinessBodyText;
import edu.bu.met.cs665.elements.BusinessHeader;
import edu.bu.met.cs665.elements.BusinessFooter;
import edu.bu.met.cs665.elements.BodyText;
import edu.bu.met.cs665.elements.Footer;
import edu.bu.met.cs665.elements.Header;


public class BusinessCustomerFactory implements SemanticElementsFactory {
  @Override
  public Header createHeader() {
    return new BusinessHeader();
  }

  @Override
  public BodyText createBodyText() {
    return new BusinessBodyText();
  }

  @Override
  public Footer createFooter() {
    return new BusinessFooter();
  }
}
