package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProximityIterator implements Iterator<Driver> {
  private Iterator<Driver> driverPool;
  private Driver nextDriver;
  private Position clientPos;
  private int proximity;

  public ProximityIterator(
      Iterable<Driver> driverPool, Position clientPosition, int proximityRange) {
    if (driverPool == null || clientPosition == null || proximityRange < 0)
      throw new IllegalArgumentException();
    this.driverPool = driverPool.iterator();
    clientPos = clientPosition;
    proximity = proximityRange;
    nextDriver = null;
  }

  @Override
  public boolean hasNext() {
    if (getNextDriver() != null) {
      return true;
    }
    return false;
  }

  @Override
  public Driver next() {
    if (hasNext()) {
      Driver nextDriverLocal = nextDriver;
      nextDriver = null;
      return nextDriverLocal;
    } else {
      throw new NoSuchElementException();
    }
  }

  private Driver getNextDriver() {
    if (nextDriver == null) {
      while (driverPool.hasNext()) {
        nextDriver = driverPool.next();
        if (clientPos.getManhattanDistanceTo(nextDriver.getVehicle().getPosition()) <= proximity) {
          return nextDriver;
        }
      }

      nextDriver = null;
    }

    return nextDriver;
  }
}
