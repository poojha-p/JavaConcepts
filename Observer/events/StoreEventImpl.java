package com.comp301.a08shopping.events;

import com.comp301.a08shopping.Product;
import com.comp301.a08shopping.Store;

public class StoreEventImpl implements StoreEvent {
  private final Product product;
  private final Store store;

  public StoreEventImpl(Product p, Store s) {
    if (p == null || s == null) throw new IllegalArgumentException();
    product = p;
    store = s;
  }

  @Override
  public Product getProduct() {
    return product;
  }

  @Override
  public Store getStore() {
    return store;
  }
}
