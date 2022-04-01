package edu.bu.met.cs665.elements;

public class ReturningFooter implements Footer {

  private String footer = "[NEW CUSTOMER FOOTER]\n";
  @Override
  public String footer() {
    return footer;
  }

  public void setFooter(String footer) {
    this.footer = footer;
  }
}
