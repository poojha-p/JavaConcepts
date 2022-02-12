package com.comp301.a07pizza;

public class PizzaImpl implements Pizza {
  private Size size;
  private Crust crust;
  private Sauce sauce;
  private Cheese cheese;
  private Ingredient[] toppings;

  public PizzaImpl(Size size, Crust crust, Sauce sauce, Cheese cheese, Ingredient[] list) {
    if (crust == null || sauce == null || cheese == null) throw new IllegalArgumentException();

    this.size = size;
    this.crust = crust;
    this.sauce = sauce;
    this.cheese = cheese;
    toppings = list;
  }

  @Override
  public boolean isVegetarian() {

    for (Ingredient ingredient : toppings) {
      if (!ingredient.isVegetarian()) return false;
    }

    return true;
  }

  @Override
  public boolean isVegan() {
    for (Ingredient ingredient : toppings) {
      if (!ingredient.isVegan()) return false;
    }

    return (crust.isVegan() && sauce.isVegan() && cheese.isVegan());
  }

  @Override
  public double getPrice() {
    int numToppings;

    numToppings = toppings.length;

    if (size == Size.SMALL) return 7.00 + 0.25 * numToppings;
    else if (size == Size.MEDIUM) return 9.00 + 0.50 * numToppings;
    else return 11.00 + 0.75 * numToppings;
  }

  @Override
  public Size getSize() {
    return size;
  }

  @Override
  public Ingredient getSauce() {
    return sauce;
  }

  @Override
  public Ingredient getCheese() {
    return cheese;
  }

  @Override
  public Ingredient getCrust() {
    return crust;
  }

  @Override
  public Ingredient[] getToppings() {
    return toppings;
  }

  @Override
  public Ingredient[] getIngredients() {
    Ingredient[] ingredients = new IngredientImpl[toppings.length + 3];

    for (int i = 0; i < toppings.length; i++) {
      ingredients[i] = toppings[i];
    }

    ingredients[toppings.length] = cheese;
    ingredients[toppings.length + 1] = crust;
    ingredients[toppings.length + 2] = sauce;

    return ingredients;
  }
}
