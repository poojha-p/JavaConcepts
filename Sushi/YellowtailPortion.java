package com.comp301.a01sushi;

public class YellowtailPortion extends IngredientPortionImpl {

  public YellowtailPortion(double amount) {
    super(amount, new Yellowtail());
  }

  @Override
  public YellowtailPortion combine(IngredientPortion other) {
    if (!((other.getIngredient().equals(this.getIngredient()))))
      throw new IllegalArgumentException();
    else if ((other.getIngredient().equals(this.getIngredient())))
      return new YellowtailPortion(this.getAmount() + other.getAmount());
    else return this;
  }
}
