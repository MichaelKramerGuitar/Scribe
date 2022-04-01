package edu.bu.met.cs665.elements;

public class NewCustomerHeader implements Header {

  private String header = "[NEW CUSTOMER HEADER]\n";

  @Override
  public String header() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }
}
