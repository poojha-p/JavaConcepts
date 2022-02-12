package com.comp301.a01sushi;

import java.util.ArrayList;

public class Roll implements Sushi {
  private String name;
  private IngredientPortion[] ingredientsFinal;
  private boolean hasSeaweed = false;

  public Roll(String name, IngredientPortion[] roll_ingredients) {
    for (int i = 0; i < roll_ingredients.length; i++) {
      if (roll_ingredients[i] == null) throw new IllegalArgumentException();
    }

    this.name = name;

    IngredientPortion[] list = roll_ingredients.clone();
    ArrayList<IngredientPortion> list2 = new ArrayList<>();

    for (int i = 0; i < list.length; i++) {
      list2.add(list[i]);
    }

    for (int i = 0; i < list2.size(); i++) {
      for (int j = i + 1; j < list2.size(); j++) {
        if (list2.get(i).getIngredient().equals(list2.get(j).getIngredient())) {
          list2.set(i, list2.get(i).combine(list2.get(j)));
          list2.remove(j);
        }
      }
      if (list2.get(i).getIngredient().equals(new Seaweed())) {
        if (list2.get(i).getAmount() < 0.1) list2.set(i, new SeaweedPortion(0.1));
        hasSeaweed = true;
      }
    }
    if (!hasSeaweed) {
      list2.add(new SeaweedPortion(0.1));
    }

    ingredientsFinal = new IngredientPortion[list2.size()];
    int index = 0;

    for (IngredientPortion x : list2) {
      ingredientsFinal[index] = x;
      index++;
    }
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return ingredientsFinal.clone();
  }

  @Override
  public int getCalories() {
    double totalCalories = 0;
    for (IngredientPortion x : ingredientsFinal) {
      totalCalories += x.getCalories();
    }

    return (int) Math.ceil(totalCalories);
  }

  @Override
  public double getCost() {
    double totalCost = 0;
    for (IngredientPortion x : ingredientsFinal) {
      totalCost += x.getCost();
    }

    return Math.round(totalCost * 100.0) / 100.0;
  }

  @Override
  public boolean getHasRice() {
    for (IngredientPortion x : ingredientsFinal) {
      if (x.getIsRice()) return true;
    }

    return false;
  }

  @Override
  public boolean getHasShellfish() {
    for (IngredientPortion x : ingredientsFinal) {
      if (x.getIsShellfish()) return true;
    }

    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    for (IngredientPortion x : ingredientsFinal) {
      if (!(x.getIsVegetarian())) return false;
    }
    return true;
  }
}
