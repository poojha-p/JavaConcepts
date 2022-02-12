package com.comp301.a01sushi;

public class RicePortion extends IngredientPortionImpl {

  public RicePortion(double amount) {
    super(amount, new Rice());
  }

  @Override
  public RicePortion combine(IngredientPortion other) {
    if (!((other.getIngredient().equals(this.getIngredient()))))
      throw new IllegalArgumentException();
    else if ((other.getIngredient().equals(this.getIngredient())))
      return new RicePortion(this.getAmount() + other.getAmount());
    else return this;
  }
}
