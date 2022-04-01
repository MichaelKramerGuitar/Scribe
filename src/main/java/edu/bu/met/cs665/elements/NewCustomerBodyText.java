package edu.bu.met.cs665.elements;

public class NewCustomerBodyText implements BodyText {

  private String text = "[NEW CUSTOMER BODY-TEXT]\nDear New Customer,"
      + "\nour company...";

  @Override
  public String bodyText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
