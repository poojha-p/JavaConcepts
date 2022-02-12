package com.comp301.a07pizza;

public class IngredientImpl implements Ingredient {
  private String name;
  private boolean veg;
  private boolean vegan;

  public IngredientImpl(String name, boolean veg, boolean vegan) {
    this.name = name;
    this.veg = veg;
    this.vegan = vegan;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isVegetarian() {
    return veg;
  }

  @Override
  public boolean isVegan() {
    return vegan;
  }
}
