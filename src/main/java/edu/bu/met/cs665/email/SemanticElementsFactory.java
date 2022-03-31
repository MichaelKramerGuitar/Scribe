package edu.bu.met.cs665.email;

import edu.bu.met.cs665.elements.BodyText;
import edu.bu.met.cs665.elements.Footer;
import edu.bu.met.cs665.elements.Header;

public interface SemanticElementsFactory {

  public Header createHeader();

  public BodyText createBodyText();

  public Footer createFooter();

}
