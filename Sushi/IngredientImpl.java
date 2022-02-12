package com.comp301.a01sushi;

public class IngredientImpl implements Ingredient {
  private String name;
  private double pricePerOz;
  private int caloriesPerOz;
  private boolean isVeg;
  private boolean hasRice;
  private boolean hasShellfish;

  public IngredientImpl(
      String name, double price, int calories, boolean veg, boolean rice, boolean shell) {
    this.name = name;
    pricePerOz = price;
    caloriesPerOz = calories;
    isVeg = veg;
    hasRice = rice;
    hasShellfish = shell;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getCaloriesPerDollar() {
    return caloriesPerOz / pricePerOz;
  }

  @Override
  public int getCaloriesPerOunce() {
    return caloriesPerOz;
  }

  @Override
  public double getPricePerOunce() {
    return pricePerOz;
  }

  @Override
  public boolean getIsVegetarian() {
    return isVeg;
  }

  @Override
  public boolean getIsRice() {
    return hasRice;
  }

  @Override
  public boolean getIsShellfish() {
    return hasShellfish;
  }

  @Override
  public boolean equals(Ingredient other) {
    if (other == null) return false;
    else {
      if (other.getName().equals(name)
          && Math.abs(other.getPricePerOunce() - pricePerOz) < 0.01
          && other.getCaloriesPerOunce() == caloriesPerOz
          && other.getIsRice() == hasRice
          && other.getIsShellfish() == hasShellfish
          && other.getIsVegetarian() == isVeg) return true;
    }

    return false;
  }
}
