package com.comp301.a06image;

import java.awt.Color;

public class ZoomDecorator implements Image {
  private Image image;
  private int multiplier;

  public ZoomDecorator(Image image, int multiplier) {
    if (multiplier <= 0 || image == null) throw new IllegalArgumentException();

    this.image = image;
    this.multiplier = multiplier;
  }

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) throw new IllegalArgumentException();

    int xx = x / multiplier;
    int yy = y / multiplier;

    return image.getPixelColor(xx, yy);
  }

  @Override
  public int getWidth() {
    return image.getWidth() * multiplier;
  }

  @Override
  public int getHeight() {
    return image.getHeight() * multiplier;
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
