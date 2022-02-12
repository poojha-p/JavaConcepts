package com.comp301.a01sushi;

public class Nigiri implements Sushi {
  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  IngredientPortion[] ingredientPortions;
  NigiriType _type;

  public Nigiri(NigiriType type) {
    ingredientPortions = new IngredientPortion[2];
    ingredientPortions[0] = new IngredientPortionImpl(0.5, new Rice());

    switch (type) {
      case EEL:
        ingredientPortions[1] = new IngredientPortionImpl(0.75, new Eel());
        break;
      case CRAB:
        ingredientPortions[1] = new IngredientPortionImpl(0.75, new Crab());
        break;
      case TUNA:
        ingredientPortions[1] = new IngredientPortionImpl(0.75, new Tuna());
        break;
      case SHRIMP:
        ingredientPortions[1] = new IngredientPortionImpl(0.75, new Shrimp());
        break;
      default:
        ingredientPortions[1] = new IngredientPortionImpl(0.75, new Yellowtail());
    }

    _type = type;
  }

  @Override
  public String getName() {
    return (_type.name()).toLowerCase() + " nigiri";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return ingredientPortions.clone();
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
    return true;
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
