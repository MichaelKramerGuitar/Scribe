package edu.bu.met.cs665.elements;

public class BusinessBodyText implements BodyText {

  private String text = "\n[BUSINESS CUSTOMER BODY-TEXT]\nDear Business Customer,"
    + "\n\tour company values your continued...\n";

  @Override
  public String bodyText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
