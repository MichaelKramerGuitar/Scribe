package edu.bu.met.cs665.elements;

public class ReturningBodyText implements BodyText {

  @Override
  public String bodyText() {
    return "[RETURNING CUSTOMER BODY-TEXT]\nDear Returning Customer,"
      + "\nour company values your continued...";
  }
}
