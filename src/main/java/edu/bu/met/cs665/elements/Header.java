package edu.bu.met.cs665.elements;

/**
 * The purpose of this class is to be an interface in the abstract factory
 * pattern such that concrete semantic elements can inherit these methods.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public interface Header {

  /**
   * The purpose of this abstract method is to generate the semantic element for a
   * a concrete class type that implements this interface.
   * <p>Precondition: A concrete type exists</p>
   * <p>Postcondition: the semantic element is generated</p>
   *
   * @return String
   */
  public String header();

  /**
   * The purpose of this method is to re-set this object in the case of a correction
   * caught by a grammar or spell checker for example.
   * <p>Precondition: a concrete type exists and has been checked.</p>
   * <p>Postcondition: corrections are applied to the object.</p>
   */
  public void setHeader(String header);
}
