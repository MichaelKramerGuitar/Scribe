package edu.bu.met.cs665.elements;

public class BusinessHeader implements Header {

  private String header = "[BUSINESS HEADER]\n";

  @Override
  public String header() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

}
