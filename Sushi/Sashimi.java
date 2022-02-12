package com.comp301.a01sushi;

public class Sashimi implements Sushi {
  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  IngredientPortion[] ingredientPortions;

  private SashimiType _type;
  private double ozOfType;

  public Sashimi(SashimiType type) {
    _type = type;
    ingredientPortions = new IngredientPortion[1];
    // how to determine which ingredientportion class to initialize to?

    switch (type) {
      case EEL:
        ingredientPortions[0] = new IngredientPortionImpl(0.75, new Eel());
        break;
      case CRAB:
        ingredientPortions[0] = new IngredientPortionImpl(0.75, new Crab());
        break;
      case TUNA:
        ingredientPortions[0] = new IngredientPortionImpl(0.75, new Tuna());
        break;
      case SHRIMP:
        ingredientPortions[0] = new IngredientPortionImpl(0.75, new Shrimp());
        break;
      default:
        ingredientPortions[0] = new IngredientPortionImpl(0.75, new Yellowtail());
    }
  }

  @Override
  public String getName() {
    return (_type.name()).toLowerCase() + " sashimi";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return ingredientPortions;
  }

  @Override
  public int getCalories() {
    double totalCalories = 0;
    for (IngredientPortion x : ingredientPortions) {
      totalCalories += x.getCalories();
    }

    return (int) Math.ceil(totalCalories);
  }

  @Override
  public double getCost() {
    double totalCost = 0;
    for (IngredientPortion x : ingredientPortions) {
      totalCost += x.getCost();
    }

    return totalCost;
  }

  @Override
  public boolean getHasRice() {
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    for (IngredientPortion x : ingredientPortions) {
      if (x.getIsShellfish()) return false;
    }

    return true;
  }

  @Override
  public boolean getIsVegetarian() {
    return false;
  }
}
