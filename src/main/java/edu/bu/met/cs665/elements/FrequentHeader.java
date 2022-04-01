package edu.bu.met.cs665.elements;

public class FrequentHeader implements Header {

  private String header = "[FREQUENT CUSTOMER HEADER]\n";

  @Override
  public String header() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

}
