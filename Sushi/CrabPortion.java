package com.comp301.a01sushi;

public class CrabPortion extends IngredientPortionImpl {

  public CrabPortion(double amount) {
    super(amount, new Crab());
  }

  @Override
  public CrabPortion combine(IngredientPortion other) {
    if (!((other.getIngredient().equals(this.getIngredient()))))
      throw new IllegalArgumentException();
    else if ((other.getIngredient().equals(this.getIngredient())))
      return new CrabPortion(this.getAmount() + other.getAmount());
    else return this;
  }
}
