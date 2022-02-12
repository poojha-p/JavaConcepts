package com.comp301.a08shopping;

import com.comp301.a08shopping.events.BackInStockEvent;
import com.comp301.a08shopping.events.OutOfStockEvent;
import com.comp301.a08shopping.events.PurchaseEvent;
import com.comp301.a08shopping.events.SaleEndEvent;
import com.comp301.a08shopping.events.SaleStartEvent;
import com.comp301.a08shopping.events.StoreEvent;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Customer {
  private String name;
  private double budget;
  private List<ReceiptItem> purchases;

  public CustomerImpl(String name, double budget) {
    if (budget < 0 || name == null) throw new IllegalArgumentException();

    this.name = name;
    this.budget = budget;
    purchases = new ArrayList<>();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getBudget() {
    return budget;
  }

  @Override
  public void purchaseProduct(Product product, Store store) {
    if (product == null || store == null) throw new IllegalArgumentException();
    ReceiptItem purchase = store.purchaseProduct(product);
    if (purchase.getPricePaid() > budget) throw new IllegalStateException();
    budget -= purchase.getPricePaid();
    purchases.add(purchase);
  }

  @Override
  public List<ReceiptItem> getPurchaseHistory() {
    return new ArrayList<>(purchases);
  }

  @Override
  public void update(StoreEvent event) {
    if (event instanceof BackInStockEvent)
      System.out.println(
          event.getProduct().getName() + " is back in stock at " + event.getStore().getName());
    if (event instanceof OutOfStockEvent)
      System.out.println(
          event.getProduct().getName() + " is now out of stock at " + event.getStore().getName());
    if (event instanceof PurchaseEvent)
      System.out.println(
          "Someone purchased "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName());
    if (event instanceof SaleEndEvent)
      System.out.println(
          "The sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + " has ended");
    if (event instanceof SaleStartEvent)
      System.out.println(
          "New sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + "!");
  }
}
