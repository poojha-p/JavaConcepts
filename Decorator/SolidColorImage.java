package com.comp301.a06image;

import java.awt.Color;

public class SolidColorImage implements Image {
  private Color pixelColor;
  private int width;
  private int height;

  public SolidColorImage(int width, int height, Color color) {
    if (width < 0 || height < 0) throw new IllegalArgumentException();

    pixelColor = color;
    this.width = width;
    this.height = height;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= width || y < 0 || y >= height) throw new IllegalArgumentException();

    return pixelColor;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getNumLayers() {
    return 1;
  }

}
