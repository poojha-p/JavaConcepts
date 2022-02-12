package com.comp301.a02adventure;

public interface Book {
  public String getTitle();
  public int getNumOfPages();
  public void setPrice(double price);
  public void setNumOfCopies(int copies);
  public double getPrice();
  public int getNumOfCopies();
  public double getStockValue();
}
