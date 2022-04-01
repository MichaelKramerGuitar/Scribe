package edu.bu.met.cs665.elements;

public class VipHeader implements Header {

  private String header = "[VIP CUSTOMER HEADER]\n";

  @Override
  public String header() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }
}
