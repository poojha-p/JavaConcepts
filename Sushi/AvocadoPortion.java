package com.comp301.a01sushi;

public class AvocadoPortion extends IngredientPortionImpl {
  public AvocadoPortion(double amount) {
    super(amount, new Avocado());
  }

  @Override
  public AvocadoPortion combine(IngredientPortion other) {
    if (!((other.getIngredient().equals(this.getIngredient()))))
      throw new IllegalArgumentException();
    else if ((other.getIngredient().equals(this.getIngredient())))
      return new AvocadoPortion(other.getAmount() + this.getAmount());
    return this;
  }
}
