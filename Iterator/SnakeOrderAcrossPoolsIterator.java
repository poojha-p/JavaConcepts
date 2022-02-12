package com.comp301.a05driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SnakeOrderAcrossPoolsIterator implements Iterator<Driver> {

  private List<Iterator<Driver>> driverPools;
  private int poolIndex;
  private Driver nextDriver;
  private boolean direction;
  private int numEmpty;
  private int poolSize;
  private boolean firstTime;
  private boolean finishedFirstTime;

  public SnakeOrderAcrossPoolsIterator(List<Iterable<Driver>> driverPools) {
    this.driverPools = new ArrayList<>();
    for (Iterable<Driver> driver : driverPools) {
      this.driverPools.add(driver.iterator());
      poolSize++;
    }
    poolIndex = 0;
    nextDriver = null;
    direction = true;
    numEmpty = 0;
    firstTime = true;
    finishedFirstTime = false;
  }

  @Override
  public boolean hasNext() {
    while (getNextDriver() == null) {
      if (numEmpty == poolSize) return false;
    }
    return true;
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
      if (firstTime) {
        firstTime = false;
        finishedFirstTime = true;
        if (driverPools.get(poolIndex).hasNext()) {
          nextDriver = driverPools.get(poolIndex).next();
          poolIndex++;
          return nextDriver;
        }
      } else {
        if (finishedFirstTime)
          finishedFirstTime = false;
        else if (poolIndex == 0) direction = true;
        else if (poolIndex == driverPools.size() - 1) direction = false;
        else {
          if (direction == true) poolIndex++;
          else poolIndex--;
        }

        if (driverPools.get(poolIndex).hasNext()) {
          nextDriver = driverPools.get(poolIndex).next();
          return nextDriver;
        }
      }

      if (direction == true) poolIndex++;
      else poolIndex--;
      nextDriver = null;
      numEmpty++;
    }
    return nextDriver;
  }
}
