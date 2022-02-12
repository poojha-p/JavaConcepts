package com.comp301.a02adventure;

public class PlayerImpl implements Player {
  private String name;
  private Position playerPos;
  private Inventory playerInv;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) throw new IllegalArgumentException();
    this.name = name;
    playerPos = new PositionImpl(startX, startY);
    playerInv = new InventoryImpl();
  }

  @Override
  public Position getPosition() {
    return playerPos;
  }

  @Override
  public Inventory getInventory() {
    return playerInv;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void move(Direction direction) {
    playerPos = playerPos.getNeighbor(direction);
  }
}
