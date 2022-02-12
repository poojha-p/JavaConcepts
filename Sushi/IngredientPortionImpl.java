package com.comp301.a01sushi;

public class IngredientPortionImpl implements IngredientPortion {
  protected double amount;
  protected Ingredient ingredient;

  public IngredientPortionImpl(double amount, Ingredient ingredient) {
    if (amount < 0) throw new IllegalArgumentException();
    this.amount = amount;
    this.ingredient = ingredient;
  }

  @Override
  public Ingredient getIngredient() {
    return ingredient;
  }

  @Override
  public double getAmount() {
    return amount;
  }

  @Override
  public String getName() {
    return ingredient.getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return ingredient.getIsVegetarian();
  }

  @Override
  public boolean getIsRice() {
    return ingredient.getIsRice();
  }

  @Override
  public boolean getIsShellfish() {
    return ingredient.getIsShellfish();
  }

  @Override
  public double getCalories() {
    return amount * ingredient.getCaloriesPerOunce();
  }

  @Override
  public double getCost() {
    return amount * ingredient.getPricePerOunce();
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (!((other.getIngredient().equals(this.getIngredient()))))
      throw new IllegalArgumentException();
    else if ((other.getIngredient().equals(this.getIngredient())))
      return new IngredientPortionImpl(this.getAmount() + other.getAmount(), ingredient);
    return this;
  }
}
