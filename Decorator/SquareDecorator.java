package com.comp301.a06image;

import java.awt.Color;

public class SquareDecorator implements Image {
  private Image image;
  private int leftX;
  private int leftY;
  private int size;
  private Color color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    if (squareSize < 0 || image == null) throw new IllegalArgumentException();

    this.image = image;
    leftX = squareX;
    leftY = squareY;
    this.size = squareSize;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x > getWidth() || y > getHeight()) throw new IllegalArgumentException();

    if (x < leftX || y < leftY || y >= leftY + size || x >= leftX + size)
      return image.getPixelColor(x, y);

    return color;
  }

  @Override
  public int getWidth() {
    return image.getWidth();
  }

  @Override
  public int getHeight() {
    return image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
