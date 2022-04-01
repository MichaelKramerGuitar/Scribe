package edu.bu.met.cs665.elements;

/**
 * The purpose of this class is to be a concrete implementation of this semantic
 * element in the abstract factory design pattern.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class VipFooter implements Footer {

  private String footer = "[VIP CUSTOMER FOOTER]\n";

  /**
   * The purpose of this method is to generate the semantic element and satisfy
   * the contract of the implemented interface.
   * <p>Precondition: An instance of this type exists</p>
   * <p>Postcondition: the semantic element is generated</p>
   *
   * @return String
   */
  @Override
  public String footer() {
    return footer;
  }

  /**
   * The purpose of this method is to edit the semantic element after a checker
   * makes corrections and satisfy the contract of the implemented interface.
   * <p>Precondition: An instance of this type exists and has been passed to
   * a checker and returned with changes.</p>
   * <p>Postcondition: the semantic element is edited.</p>
   */
  @Override
  public void setFooter(String footer) {
    this.footer = footer;
  }

}
