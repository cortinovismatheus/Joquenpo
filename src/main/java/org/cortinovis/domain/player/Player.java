package org.cortinovis.domain.player;
import org.cortinovis.domain.player.Gesture;

public class Player {
  private String name;
  private Gesture gesture;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Gesture getGesture() {
    return gesture;
  }

  public void setGesture(Gesture gesture) {
    this.gesture = gesture;
  }
}