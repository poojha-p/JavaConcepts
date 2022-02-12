package com.comp301.a01sushi;

public class TunaPortion extends IngredientPortionImpl {

  public TunaPortion(double amount) {
    super(amount, new Tuna());
  }

  @Override
  public TunaPortion combine(IngredientPortion other) {
    if (!((other.getIngredient().equals(this.getIngredient()))))
      throw new IllegalArgumentException();
    else if ((other.getIngredient().equals(this.getIngredient())))
      return new TunaPortion(this.getAmount() + other.getAmount());
    else return this;
  }
}
