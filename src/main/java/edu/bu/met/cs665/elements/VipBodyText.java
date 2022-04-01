package edu.bu.met.cs665.elements;

public class VipBodyText implements BodyText {

  private String text = "[VIP CUSTOMER BODY-TEXT]\nDear VIP Customer,"
      + "\nour company values your continued...";

  @Override
  public String bodyText() {
    return text;
  }

  @Override
  public void setText(String text) {
    this.text = text;
  }
}
