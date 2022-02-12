package com.comp301.a07pizza;

import com.comp301.a07pizza.Pizza.Size;

public class PizzaFactory {

  public static Pizza makeCheesePizza(Size size) {
    return new PizzaImpl(
        size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, new IngredientImpl[0]);
  }

  public static Pizza makeHawaiianPizza(Size size) {
    Topping[] toppings = new Topping[2];
    toppings[0] = Topping.HAM;
    toppings[1] = Topping.PINEAPPLE;

    return new PizzaImpl(size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, toppings);
  }

  public static Pizza makeMeatLoversPizza(Size size) {
    Topping[] toppings = new Topping[4];
    toppings[0] = Topping.PEPPERONI;
    toppings[1] = Topping.SAUSAGE;
    toppings[2] = Topping.BACON;
    toppings[3] = Topping.GROUND_BEEF;

    return new PizzaImpl(size, Crust.DEEP_DISH, Sauce.TOMATO, Cheese.BLEND, toppings);
  }

  public static Pizza makeVeggieSupremePizza(Size size) {
    Topping[] toppings = new Topping[4];
    toppings[0] = Topping.SUN_DRIED_TOMATO;
    toppings[1] = Topping.GREEN_PEPPER;
    toppings[2] = Topping.MUSHROOMS;
    toppings[3] = Topping.OLIVES;

    return new PizzaImpl(size, Crust.THIN, Sauce.TOMATO, Cheese.BLEND, toppings);
  }

  public static Pizza makeDailySpecialPizza() {
    Topping[] toppings = new Topping[2];
    toppings[0] = Topping.SUN_DRIED_TOMATO;
    toppings[1] = Topping.MUSHROOMS;

    return new PizzaImpl(Size.LARGE, Crust.HAND_TOSSED, Sauce.ALFREDO, Cheese.MOZZARELLA, toppings);
  }
}
