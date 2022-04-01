package edu.bu.met.cs665.elements;

public class ReturningHeader implements Header {

  private String header = "[RETURNING CUSTOMER HEADER]\n";

  @Override
  public String header() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }
}
