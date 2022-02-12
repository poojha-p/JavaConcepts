package com.comp301.a06image;

import java.awt.Color;

public class BorderDecorator implements Image {
  private Image image;
  private int thickness;
  private Color borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (thiccness < 0 || image == null) throw new IllegalArgumentException();

    this.image = image;
    thickness = thiccness;
    this.borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) throw new IllegalArgumentException();

    if (x > getWidth() - thickness - 1 && x < getWidth()) return borderColor;
    else if (x >= 0 && x < thickness) return borderColor;
    else if (y > getHeight() - thickness - 1 && y < getHeight()) return borderColor;
    else if (y >= 0 && y < thickness) return borderColor;
    else {
      return image.getPixelColor(x - thickness, y - thickness);
    }
  }

  @Override
  public int getWidth() {
    return image.getWidth() + 2 * thickness;
  }

  @Override
  public int getHeight() {
    return image.getHeight() + 2 * thickness;
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
