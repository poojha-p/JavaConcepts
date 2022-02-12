package com.comp301.a06image;

import java.awt.Color;

public class CircleDecorator implements Image {
  private Image image;
  private int centerX;
  private int centerY;
  private int radius;
  private Color color;

  public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
    if (image == null || radius < 0) throw new IllegalArgumentException();

    this.image = image;
    centerX = cx;
    centerY = cy;
    this.radius = radius;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x > getWidth() || y > getHeight()) throw new IllegalArgumentException();

    if (Math.sqrt(Math.pow((centerX - x), 2) + Math.pow((centerY - y), 2)) < radius) return color;
    return image.getPixelColor(x, y);
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
