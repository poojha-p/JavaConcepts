package com.comp301.a01sushi;

public class ShrimpPortion extends IngredientPortionImpl {

  public ShrimpPortion(double amount) {
    super(amount, new Shrimp());
  }

  @Override
  public ShrimpPortion combine(IngredientPortion other) {
    if (!((other.getIngredient().equals(this.getIngredient()))))
      throw new IllegalArgumentException();
    else if ((other.getIngredient().equals(this.getIngredient())))
      return new ShrimpPortion(other.getAmount() + this.getAmount());
    else return this;
  }
}
