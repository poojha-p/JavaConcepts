package com.comp301.a02adventure;

public class BookImpl implements Book {
  private final String title;
  private final int numOfPages;
  private double price;
  private int copies;

  public BookImpl (String title, int numOfPages, double price, int copies) {
    if (numOfPages<0 || price < 0 || copies < 0) {
      throw new IllegalArgumentException();
    }
    this.title = title;
    this.numOfPages = numOfPages;
    this.price = price;
    this.copies = copies;
  }

  public BookImpl (String title, int numOfPages) {
    this(title, numOfPages, 10.50, 0);
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public int getNumOfPages() {
    return numOfPages;
  }

  @Override
  public void setPrice(double price) {
    if (price < 0) {
      throw new IllegalArgumentException();
    }

    this.price = price;
  }

  @Override
  public void setNumOfCopies(int copies) {
    if (copies < 0) {
      throw new IllegalArgumentException();
    }

    this.copies = copies;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public int getNumOfCopies() {
    return copies;
  }

  @Override
  public double getStockValue() {
    return this.price*this.copies;
  }
}
