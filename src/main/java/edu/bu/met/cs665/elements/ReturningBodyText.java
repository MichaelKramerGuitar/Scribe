package edu.bu.met.cs665.elements;

public class ReturningBodyText implements BodyText {

  private String text = "[RETURNING CUSTOMER BODY-TEXT]\nDear Returning Customer,"
    + "\n\tour company values your continued...";

  @Override
  public String bodyText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
