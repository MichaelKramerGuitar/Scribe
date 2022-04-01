package edu.bu.met.cs665.elements;

public class FrequentBodyText implements BodyText {

  private String text = "\n[FREQUENT CUSTOMER BODY-TEXT]\nDear Frequent Customer,"
    + "\n\tour company values your continued...\n";

  @Override
  public String bodyText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
