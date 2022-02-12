package com.comp301.a01sushi;

public class EelPortion extends IngredientPortionImpl {

  public EelPortion(double amount) {
    super(amount, new Eel());
  }

  @Override
  public EelPortion combine(IngredientPortion other) {
    if (!((other.getIngredient().equals(this.getIngredient()))))
      throw new IllegalArgumentException();
    else if ((other.getIngredient().equals(this.getIngredient())))
      return new EelPortion(this.getAmount() + other.getAmount());
    else return this;
  }
}
