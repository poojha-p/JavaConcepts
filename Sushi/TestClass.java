package com.comp301.a01sushi;

import static com.comp301.a01sushi.Sashimi.SashimiType.TUNA;

public class TestClass {
  public static void main (String [] args) {
    /**IngredientPortion[] stuffIng = {new AvocadoPortion(0.2), new CrabPortion(0.34), new RicePortion(0.7), new EelPortion(0.1), new SeaweedPortion(0.05), new TunaPortion(0.44), new YellowtailPortion(0.12), new SeaweedPortion(0.025), new TunaPortion(0.21), new YellowtailPortion(0.32)};
    Sashimi test = new Sashimi(TUNA);
    Roll stuff = new Roll("California roll", stuffIng);
    System.out.println(stuff.getIngredients());
    System.out.println("Name: " + test.getName());
    Ingredient test0 = new Avocado();
    Ingredient test00 = new Avocado();
    test00.equals(test0);
    IngredientPortion test1 = new IngredientPortionImpl(0.5, new Avocado());
    IngredientPortion test2 = new IngredientPortionImpl(0.25, new Avocado());
    IngredientPortion test4 = new AvocadoPortion(0.22);
    IngredientPortion test5 = new CrabPortion(0.48);
    System.out.println(test2.getCost());
    System.out.println(test2.getCalories());
    IngredientPortion test3 = new IngredientPortionImpl(0.55, new Crab());
    test4 = test4.combine(test2);
    //test2 = test2.combine(test4);
    //test4 = test4.combine(test5);
    test1 = test1.combine(test2);
    //test2 = test2.combine(test3);**/

    recPrint(3);
  }

  public static void recPrint (int n) {
    if (n == 0)
      System.out.print("!");
    else {
      recPrint(n-1);
      System.out.print(n);
    }
  }
}
