package com.comp301.a01sushi;

public class SeaweedPortion extends IngredientPortionImpl {

  public SeaweedPortion(double amount) {
    super(amount, new Seaweed());
  }

  @Override
  public SeaweedPortion combine(IngredientPortion other) {
    if (!((other.getIngredient().equals(this.getIngredient()))))
      throw new IllegalArgumentException();
    else if ((other.getIngredient().equals(this.getIngredient())))
      return new SeaweedPortion(other.getAmount() + this.getAmount());
    else return this;
  }
}
