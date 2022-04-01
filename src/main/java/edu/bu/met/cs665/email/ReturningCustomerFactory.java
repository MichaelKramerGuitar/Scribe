package edu.bu.met.cs665.email;

import edu.bu.met.cs665.elements.BodyText;
import edu.bu.met.cs665.elements.Footer;
import edu.bu.met.cs665.elements.Header;
import edu.bu.met.cs665.elements.ReturningBodyText;
import edu.bu.met.cs665.elements.ReturningFooter;
import edu.bu.met.cs665.elements.ReturningHeader;

/**
 * The purpose of this class is to provide the concrete factory for the given
 * type to create the associated semantic elements to the type thus encapsulating
 * the creation of the semantic elements from the email which they are to comprise.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class ReturningCustomerFactory implements SemanticElementsFactory {

  /**
   * The purpose of this method is to provide a concrete implementation for the
   * creation of this semantic element.
   * @return Header of the appropriate type
   */
  @Override
  public Header createHeader() {
    return new ReturningHeader();
  }

  /**
   * The purpose of this method is to provide a concrete implementation for the
   * creation of this semantic element.
   * @return BodyText of the appropriate type
   */
  @Override
  public BodyText createBodyText() {
    return new ReturningBodyText();
  }

  /**
   * The purpose of this method is to provide a concrete implementation for the
   * creation of this semantic element.
   * @return Footer of the appropriate type
   */
  @Override
  public Footer createFooter() {
    return new ReturningFooter();
  }
}