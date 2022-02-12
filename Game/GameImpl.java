package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {
  private Player player;
  private Map map;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) throw new IllegalArgumentException();
    this.player = player;
    this.map = map;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return new ArrayList<>(player.getInventory().getItems());
  }

  @Override
  public boolean getIsWinner() {
    return player.getInventory().getNumItems() == map.getNumItems();
  }

  @Override
  public void printCellInfo() {
    Cell currentLocation = map.getCell(player.getPosition());
    System.out.println("Location: " + currentLocation.getName());
    System.out.println(currentLocation.getDescription());
    if (currentLocation.getIsVisited())
      System.out.println("You have already visited this location.");
    if (currentLocation.hasChest())
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    currentLocation.visit();
  }

  @Override
  public void openChest() {
    Cell currentLocation = map.getCell(player.getPosition());
    if (currentLocation.hasChest()) {
      Inventory chest = currentLocation.getChest();
      if (chest.isEmpty()) System.out.println("The chest is empty.");
      else {
        System.out.println("You collected these items: " + chest.getItems());
        player.getInventory().transferFrom(currentLocation.getChest());
      }
    } else System.out.println("No chest to open, sorry!");
  }

  @Override
  public boolean canMove(Direction direction) {
    Position neighbor = player.getPosition().getNeighbor(direction);

    if (neighbor.getX() >= 0
        && neighbor.getY() >= 0
        && neighbor.getX() < map.getWidth()
        && neighbor.getY() < map.getHeight()
        && map.getCell(neighbor) != null) return true;
    return false;
  }

  @Override
  public void move(Direction direction) {
    if (!canMove(direction)) {
      System.out.println("You can't go that way! Try another direction.");
    } else {
      player.move(direction);
      printCellInfo();
    }
  }
}
