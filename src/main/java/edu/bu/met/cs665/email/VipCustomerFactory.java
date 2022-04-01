package edu.bu.met.cs665.email;

import edu.bu.met.cs665.elements.VipBodyText;
import edu.bu.met.cs665.elements.VipHeader;
import edu.bu.met.cs665.elements.VipFooter;
import edu.bu.met.cs665.elements.BodyText;
import edu.bu.met.cs665.elements.Footer;
import edu.bu.met.cs665.elements.Header;


public class VipCustomerFactory implements SemanticElementsFactory {

  @Override
  public Header createHeader() {
    return new VipHeader();
  }

  @Override
  public BodyText createBodyText() {
    return new VipBodyText();
  }

  @Override
  public Footer createFooter() {
    return new VipFooter();
  }
}
