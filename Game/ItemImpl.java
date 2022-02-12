package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private String name;

  public ItemImpl(String name) {
    if (name == null) throw new IllegalArgumentException();
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Item) {
      if (name.equals(((Item) other).getName())) return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return name;
  }
}
