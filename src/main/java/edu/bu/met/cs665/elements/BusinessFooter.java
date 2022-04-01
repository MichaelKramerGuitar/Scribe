package edu.bu.met.cs665.elements;

public class BusinessFooter implements Footer {

  private String footer = "\n[BUSINESS CUSTOMER FOOTER]\n";

  @Override
  public String footer() {
    return footer;
  }

  public void setFooter(String footer) {
    this.footer = footer;
  }

}
