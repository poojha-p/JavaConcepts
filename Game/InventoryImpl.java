package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private List<Item> inventoryList;

  public InventoryImpl() {
    inventoryList = new ArrayList<Item>();
  }

  @Override
  public boolean isEmpty() {
    return inventoryList.isEmpty();
  }

  @Override
  public int getNumItems() {
    return inventoryList.size();
  }

  @Override
  public List<Item> getItems() {
    return new ArrayList<>(inventoryList);
  }

  @Override
  public void addItem(Item item) {
    inventoryList.add(item);
  }

  @Override
  public void removeItem(Item item) {
    int size = inventoryList.size();
    // can i use remove method? or do i have to manually remove?
    for (int i = 0; i < size; i++) {
      if (inventoryList.get(i).equals(item)) {
        inventoryList.remove(i);
        break;
      }
    }
  }

  @Override
  public void clear() {
    inventoryList.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    int size = other.getNumItems();

    for (int i = 0; i < size; i++) {
      inventoryList.add(other.getItems().get(0));
      other.removeItem(other.getItems().get(0));
    }
  }
}
