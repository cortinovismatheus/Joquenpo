package org.cortinovis.domain;

public class Hand {
  Gesture gesture;
  public Hand(Gesture gesture) {
    this.gesture = gesture;
  }

  public Gesture getGesture() {
    return gesture;
  }
}
