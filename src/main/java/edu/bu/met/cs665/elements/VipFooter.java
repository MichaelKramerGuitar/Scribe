package edu.bu.met.cs665.elements;

public class VipFooter implements Footer {

  private String footer = "[VIP CUSTOMER FOOTER]\n";

  @Override
  public String footer() {
    return footer;
  }

  public void setFooter(String footer) {
    this.footer = footer;
  }

}
