package com.comp301.a02adventure;

public class MapImpl implements Map {
  private Cell[][] grid;
  private int numItems;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) throw new IllegalArgumentException();
    grid = new CellImpl[width][height];
    this.numItems = numItems;
  }

  @Override
  public int getWidth() {
    return grid.length;
  }

  @Override
  public int getHeight() {
    return grid[0].length;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())
      throw new IndexOutOfBoundsException();
    return grid[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    if (position == null
        || position.getX() < 0
        || position.getX() >= getWidth()
        || position.getY() >= getHeight()
        || position.getY() < 0) throw new IndexOutOfBoundsException();
    return grid[position.getX()][position.getY()];
  }

  @Override
  public void initCell(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())
      throw new IndexOutOfBoundsException();
    grid[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return numItems;
  }
}
