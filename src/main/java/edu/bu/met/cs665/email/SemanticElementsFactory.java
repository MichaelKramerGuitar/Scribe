package edu.bu.met.cs665.email;

import edu.bu.met.cs665.elements.BodyText;
import edu.bu.met.cs665.elements.Footer;
import edu.bu.met.cs665.elements.Header;

/**
 * The purpose of this class is to be the creational interface providing the
 * abstract methods in the abstract factory pattern.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public interface SemanticElementsFactory {

  // Abstract Semantic Element Creational Methods
  public Header createHeader();

  public BodyText createBodyText();

  public Footer createFooter();

}
