package com.comp301.a08shopping;

import com.comp301.a08shopping.events.BackInStockEvent;
import com.comp301.a08shopping.events.OutOfStockEvent;
import com.comp301.a08shopping.events.PurchaseEvent;
import com.comp301.a08shopping.events.SaleEndEvent;
import com.comp301.a08shopping.events.SaleStartEvent;
import com.comp301.a08shopping.events.StoreEvent;
import com.comp301.a08shopping.exceptions.OutOfStockException;
import com.comp301.a08shopping.exceptions.ProductNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreImpl implements Store {
  private final String name;
  private List<StoreObserver> observers;
  private List<Product> products;
  private Map<Product, Integer> inventory;
  private Map<Product, Double> discount;
  private double previousPercentOff;

  public StoreImpl(String name) {
    if (name == null) throw new IllegalArgumentException();

    this.name = name;
    observers = new ArrayList<>();
    products = new ArrayList<>();
    inventory = new HashMap<>();
    discount = new HashMap<>();
    previousPercentOff = 0;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void addObserver(StoreObserver observer) {
    if (observer == null) throw new IllegalArgumentException();
    observers.add(observer);
  }

  @Override
  public void removeObserver(StoreObserver observer) {
    if (observer == null) throw new IllegalArgumentException();
    observers.remove(observer);
  }

  @Override
  public List<Product> getProducts() {
    return new ArrayList<>(products);
  }

  @Override
  public Product createProduct(String name, double basePrice, int inventory) {
    Product p = new ProductImpl(name, basePrice);
    products.add(p);
    this.inventory.put(p, inventory);
    return p;
  }

  @Override
  public ReceiptItem purchaseProduct(Product product) {
    if (product == null) throw new IllegalArgumentException();
    else if (products.contains(product)) {
      if (inventory.get(product) == 0) throw new OutOfStockException();
      else {
        int copies = inventory.get(product) - 1;
        if (copies == 0) notify(new OutOfStockEvent(product, this));
        inventory.replace(product, copies);
      }
      double price;
      if (discount.containsKey(product))
        price = product.getBasePrice() * (1 - discount.get(product));
      else price = product.getBasePrice();

      notify(new PurchaseEvent(product, this));
      return new ReceiptItemImpl(product.getName(), price, name);
    } else throw new ProductNotFoundException();
  }

  @Override
  public void restockProduct(Product product, int numItems) {
    if (product == null || numItems < 0) throw new IllegalArgumentException();
    else if (products.contains(product)) {
      int copies = inventory.get(product);
      if (copies == 0) notify(new BackInStockEvent(product, this));
      inventory.replace(product, copies + numItems);
    } else throw new ProductNotFoundException();
  }

  @Override
  public void startSale(Product product, double percentOff) {
    if (product == null || percentOff <= 0.0 || percentOff >= 1.0)
      throw new IllegalArgumentException();
    else if (products.contains(product)) {
      if (discount.containsKey(product)) previousPercentOff = discount.get(product);
      discount.put(product, percentOff);
      notify(new SaleStartEvent(product, this));
    } else throw new ProductNotFoundException();
  }

  @Override
  public void endSale(Product product) {
    if (product == null) throw new IllegalArgumentException();
    else if (products.contains(product)) {
      discount.put(product, previousPercentOff);
      notify(new SaleEndEvent(product, this));
    } else throw new ProductNotFoundException();
  }

  @Override
  public int getProductInventory(Product product) {
    if (product == null) throw new IllegalArgumentException();
    else if (products.contains(product)) return inventory.get(product);
    else throw new ProductNotFoundException();
  }

  @Override
  public boolean getIsInStock(Product product) {
    if (product == null) throw new IllegalArgumentException();
    else if (products.contains(product)) return inventory.get(product) != 0;
    else throw new ProductNotFoundException();
  }

  @Override
  public double getSalePrice(Product product) {
    if (product == null) throw new IllegalArgumentException();
    else if (products.contains(product)) {
      double returnPrice;
      if (discount.containsKey(product))
        returnPrice = product.getBasePrice() * (1 - discount.get(product));
      else returnPrice = product.getBasePrice();
      return Math.round(returnPrice * 100.0) / 100.0;
    } else throw new ProductNotFoundException();
  }

  @Override
  public boolean getIsOnSale(Product product) {
    if (product == null) throw new IllegalArgumentException();
    else if (products.contains(product)) {
      if (discount.containsKey(product)) return discount.get(product) != 0.0;
      return false;
    } else throw new ProductNotFoundException();
  }

  private void notify(StoreEvent e) {
    for (StoreObserver s : observers) {
      s.update(e);
    }
  }
}
