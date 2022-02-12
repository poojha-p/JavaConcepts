package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExpandingProximityIterator implements Iterator<Driver> {
  private Iterator<Driver> driverPool;
  // set driverPool to this when incrementing range
  private final Iterable<Driver> ogDriverPool;
  private final Position clientPosition;
  private final int expansionStep;
  private Driver nextDriver;
  private int successfulNext;
  private int totalDrivers;
  private int multFactor;

  public ExpandingProximityIterator(
      Iterable<Driver> driverPool, Position clientPosition, int expansionStep) {
    this.driverPool = driverPool.iterator();
    ogDriverPool = driverPool;
    this.clientPosition = clientPosition;
    this.expansionStep = expansionStep;
    nextDriver = null;
    successfulNext = 0;
    multFactor = 0;

    for (Driver driver : driverPool) {
      totalDrivers++;
    }
  }

  @Override
  public boolean hasNext() {
    while (getNextDriver() == null) {
      if (successfulNext < totalDrivers) {
        multFactor++;
        driverPool = ogDriverPool.iterator();
      } else {
        return false;
      }
    }

    return true;
  }

  @Override
  public Driver next() {
    if (hasNext()) {
      Driver nextDriverLocal = nextDriver;
      nextDriver = null;
      successfulNext++;
      return nextDriverLocal;
    } else {
      throw new NoSuchElementException();
    }
  }

  private Driver getNextDriver() {
    if (nextDriver == null) {
      while (driverPool.hasNext()) {
        nextDriver = driverPool.next();
        int distance = clientPosition.getManhattanDistanceTo(nextDriver.getVehicle().getPosition());

        if (multFactor == 0) {
          if (distance <= 1) return nextDriver;
        } else {
          int low = 1 + (multFactor - 1) * expansionStep;
          int high = 1 + (multFactor) * expansionStep;

          if (distance > low && distance <= high) return nextDriver;
        }
      }
      nextDriver = null;
    }

    return nextDriver;
  }
}
